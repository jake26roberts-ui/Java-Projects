#!/usr/bin/env python3
"""Create terminal-style MP4 demo clips from captured Java console runs."""
from __future__ import annotations

import os
import pathlib
import pty
import select
import shutil
import subprocess
import sys
import time

import cv2
import numpy as np
from PIL import Image, ImageDraw, ImageFont

ROOT = pathlib.Path(__file__).resolve().parents[2]
ARTIFACTS = ROOT / "artifacts" / "java-demos"
CLASSES = ARTIFACTS / "classes"
OUT = ARTIFACTS / "videos"
WIDTH, HEIGHT = 1280, 720
FPS = 12
FONT_PATHS = [
    "/usr/share/fonts/truetype/dejavu/DejaVuSansMono.ttf",
    "/usr/share/fonts/dejavu/DejaVuSansMono.ttf",
]
PROJECT_SOURCES = {
    "guessing": ("AI Given Projects/Guessing Game/Code.java", "GuessingGame.java", "aiProjects.GuessingGame"),
    "bmi": ("BMI Calculator/Code.java", "BMICalculator.java", "BMICalculator"),
    "snack-bar": ("Beach Snack Bar/Code.java", "BeachSnackBar.java", "BeachSnackBar"),
    "fahrenheit": ("Fahrenheit Converter/Code.java", "FahrenheitConverter.java", "FahrenheitConverter"),
    "powerball": ("Powerball Lottery Game/Code.java", "PowerballSimulation.java", "PowerballSimulation"),
    "sales": ("Sales Statistics/Code.java", "SalesStatistics.java", "SalesStatistics"),
    "vending": ("Vending Machine/Code.java", "VendingMachine.java", "VendingMachine"),
    "volume": ("Volume Calculator/Code.java", "VolumeCalculator.java", "VolumeCalculator"),
}


def java_tool(name: str) -> str:
    local = ROOT / ".tools" / "java" / "bin" / name
    found = shutil.which(name)
    if found:
        return found
    if local.is_file():
        return str(local)
    raise RuntimeError(f"{name} is required to compile and run the Java demos")


def prepare_classes() -> None:
    """Compile each Code.java under its actual Java public class filename."""
    javac = java_tool("javac")
    for slug, (source, target_name, main_class) in PROJECT_SOURCES.items():
        folder = CLASSES / slug
        src = folder / "src"
        if slug == "guessing":
            src = src / "aiProjects"
        src.mkdir(parents=True, exist_ok=True)
        classes = folder / "classes"
        classes.mkdir(parents=True, exist_ok=True)
        target = src / target_name
        shutil.copyfile(ROOT / source, target)
        result = subprocess.run([javac, "-encoding", "UTF-8", "-d", str(classes), str(target)], capture_output=True, text=True)
        if result.returncode:
            raise RuntimeError(f"Could not compile {source}:\\n{result.stderr}")
        (folder / "main-class.txt").write_text(main_class)

DEMOS = {
    "guessing": {
        "name": "Guessing Game",
        "scenario": "Repeated play until the $100 starting balance is gone",
        "prompts": [("Please enter your guess now:", "5")],
        "repeat_last": True,
    },
    "bmi": {
        "name": "BMI Calculator",
        "scenario": "A 160 lb, 5 ft 8 in profile and the surrounding BMI table",
        "prompts": [("Enter your name:", "Morgan Riley"), ("Enter your weight in pounds:", "160"), ("Enter your height in feet :", "5"), ("Enter your height in inches:", "8")],
    },
    "snack-bar": {
        "name": "Beach Snack Bar",
        "scenario": "Large combo order with student discount and tax",
        "prompts": [("option 1, 2, or 3:", "2"), ("drink size (Small or Large):", "Large"), ("college student (y/n):", "y"), ("military (y/n):", "n")],
    },
    "fahrenheit": {
        "name": "Fahrenheit Converter",
        "scenario": "Temperature table starting below freezing",
        "prompts": [("Please enter a value to start at:", "-40")],
    },
    "powerball": {
        "name": "Powerball Simulation",
        "scenario": "A valid ticket compared with the generated drawing",
        "prompts": [("Enter 2 letters between A and Z with no space between them:", "AB"), ("Enter the number on your ticket (1-10):", "7")],
    },
    "sales": {
        "name": "Sales Statistics",
        "scenario": "Several stores, bar charts, and summary statistics",
        "prompts": [("Enter sales from all coffee shops, end input by entering -1:", "245 820 2010 801 1421 -1")],
    },
    "vending": {
        "name": "Vending Machine",
        "scenario": "Two snacks purchased, followed by authorized shutdown",
        "prompts": [("How many snacks would you like? Limit is 3:", "2"), ("Enter snack selection:", "1a"), ("Enter snack selection:", "2B"), ("How many snacks would you like? Limit is 3:", "999"), ("Enter shutdown password:", "COOKIES")],
    },
    "volume": {
        "name": "Volume Calculator",
        "scenario": "Cube and sphere calculations, then quit",
        "prompts": [("Please enter a number 1 - 4 or 0 to quit:", "1"), ("Please enter the side length of the cube:", "3"), ("Please enter a number 1 - 4 or 0 to quit:", "2"), ("Please enter the radius of the sphere:", "3"), ("Please enter a number 1 - 4 or 0 to quit:", "0")],
    },
}


def font(size: int) -> ImageFont.FreeTypeFont | ImageFont.ImageFont:
    for path in FONT_PATHS:
        if pathlib.Path(path).is_file():
            return ImageFont.truetype(path, size)
    return ImageFont.load_default()


def launch(slug: str, demo: dict) -> tuple[list[str], str]:
    """Run the original Java class in a pseudo-terminal and capture its real session."""
    folder = CLASSES / slug
    main_class = (folder / "main-class.txt").read_text().strip()
    master, slave = pty.openpty()
    proc = subprocess.Popen(
        [java_tool("java"), "-cp", str(folder / "classes"), main_class],
        cwd=ROOT,
        stdin=slave,
        stdout=slave,
        stderr=slave,
        start_new_session=True,
        close_fds=True,
    )
    os.close(slave)
    prompt_plan = demo["prompts"]
    prompt_index = 0
    scanned = 0
    transcript = bytearray()
    deadline = time.monotonic() + 25
    try:
        while time.monotonic() < deadline:
            ready, _, _ = select.select([master], [], [], 0.15)
            if ready:
                try:
                    chunk = os.read(master, 8192)
                except OSError:
                    break
                if not chunk:
                    break
                transcript.extend(chunk)
                current = transcript.decode("utf-8", errors="replace")
                while prompt_index < len(prompt_plan):
                    prompt, response = prompt_plan[prompt_index]
                    found = current.find(prompt, scanned)
                    if found < 0:
                        break
                    scanned = found + len(prompt)
                    os.write(master, (response + "\n").encode())
                    prompt_index += 1
                if demo.get("repeat_last") and prompt_index == len(prompt_plan):
                    prompt_plan.append(prompt_plan[-1])
                if b"out of money" in transcript.lower():
                    break
            if proc.poll() is not None:
                break
        if proc.poll() is None:
            try:
                proc.wait(timeout=1)
            except subprocess.TimeoutExpired:
                pass
        if proc.poll() is None:
            proc.terminate()
            try:
                proc.wait(timeout=2)
            except subprocess.TimeoutExpired:
                proc.kill()
                proc.wait()
            raise RuntimeError(f"{slug} did not complete its interactive run before timeout")
    finally:
        os.close(master)
    if proc.returncode:
        raise RuntimeError(f"{slug} exited {proc.returncode}: {transcript.decode(errors='replace')[-500:]}")
    raw = transcript.decode("utf-8", errors="replace").replace("\r\n", "\n").replace("\r", "\n")
    if prompt_index < len(prompt_plan) and not demo.get("repeat_last"):
        raise RuntimeError(f"{slug} did not reach all planned input prompts ({prompt_index}/{len(prompt_plan)})")
    (folder / "sample-output.txt").write_text(raw)
    return raw.splitlines(), raw


def wrap_text(draw: ImageDraw.ImageDraw, text: str, ft, max_width: int) -> list[str]:
    words = text.split()
    lines: list[str] = []
    line = ""
    for word in words:
        candidate = (line + " " + word).strip()
        if line and draw.textbbox((0, 0), candidate, font=ft)[2] > max_width:
            lines.append(line)
            line = word
        else:
            line = candidate
    if line:
        lines.append(line)
    return lines


def make_frame(name: str, scenario: str, lines: list[str], progress: int, total: int, cursor: bool) -> np.ndarray:
    image = Image.new("RGB", (WIDTH, HEIGHT), (12, 17, 27))
    draw = ImageDraw.Draw(image)
    title_font = font(33)
    body_font = font(18)
    small_font = font(17)
    # Desktop-console titlebar and prompt-style chrome.
    draw.rounded_rectangle((36, 28, WIDTH - 36, HEIGHT - 28), radius=20, fill=(21, 28, 41), outline=(57, 70, 91), width=2)
    draw.rounded_rectangle((38, 30, WIDTH - 38, 92), radius=18, fill=(31, 41, 57))
    for x, color in [(66, (255, 95, 87)), (93, (255, 189, 46)), (120, (40, 201, 64))]:
        draw.ellipse((x - 8, 55 - 8, x + 8, 55 + 8), fill=color)
    draw.text((160, 39), name, font=title_font, fill=(238, 243, 250))
    draw.text((66, 112), "JAVA CONSOLE DEMO", font=small_font, fill=(116, 195, 255))
    scenario_lines = wrap_text(draw, scenario, small_font, WIDTH - 140)
    for idx, text in enumerate(scenario_lines):
        draw.text((66, 143 + idx * 24), text, font=small_font, fill=(167, 184, 207))
    # Console body: reserve room for a useful number of rows while keeping
    # both wide formatted tables and prompts legible at 720p.
    start_y = 205 + max(0, len(scenario_lines) - 1) * 22
    max_rows = 19
    visible = lines[max(0, progress - max_rows):progress]
    line_height = min(25, int((HEIGHT - start_y - 90) / max_rows))
    for idx, line in enumerate(visible):
        y = start_y + idx * line_height
        clipped = line[:106]
        # Colour user input lines and status markers for easier scanning.
        color = (220, 231, 244)
        if "?" in line and idx == len(visible) - 1:
            color = (119, 213, 170)
        draw.text((66, y), clipped, font=body_font, fill=color)
    if cursor and progress < total:
        y = start_y + len(visible) * line_height
        draw.rectangle((66, y + 2, 79, y + 23), fill=(119, 213, 170))
    # Progress indicator and subtle progress bar.
    draw.text((66, HEIGHT - 84), f"{progress:02d} / {total:02d} lines", font=small_font, fill=(142, 157, 178))
    bar_x, bar_y, bar_w = 280, HEIGHT - 82, WIDTH - 360
    draw.rounded_rectangle((bar_x, bar_y, bar_x + bar_w, bar_y + 10), radius=5, fill=(48, 59, 78))
    draw.rounded_rectangle((bar_x, bar_y, bar_x + int(bar_w * progress / max(total, 1)), bar_y + 10), radius=5, fill=(66, 177, 148))
    return cv2.cvtColor(np.asarray(image), cv2.COLOR_RGB2BGR)


def main() -> None:
    prepare_classes()
    OUT.mkdir(parents=True, exist_ok=True)
    for slug, demo in DEMOS.items():
        lines, raw = launch(slug, demo)
        if not lines:
            raise RuntimeError(f"{slug} produced no output")
        path = OUT / f"{slug}.mp4"
        writer = cv2.VideoWriter(str(path), cv2.VideoWriter_fourcc(*"mp4v"), FPS, (WIDTH, HEIGHT))
        if not writer.isOpened():
            raise RuntimeError("OpenCV FFmpeg MPEG-4 MP4 writer unavailable")
        # Title card, paced line-by-line reveal, and end card pause.
        empty_lines: list[str] = []
        title_frames = 12
        reveal_frames = 2
        end_frames = 18
        for _ in range(title_frames):
            writer.write(make_frame(demo["name"], demo["scenario"], empty_lines, 0, len(lines), False))
        for count in range(1, len(lines) + 1):
            for _ in range(reveal_frames):
                writer.write(make_frame(demo["name"], demo["scenario"], lines, count, len(lines), count < len(lines)))
        for _ in range(end_frames):
            writer.write(make_frame(demo["name"], demo["scenario"], lines, len(lines), len(lines), False))
        writer.release()
        cap = cv2.VideoCapture(str(path))
        frame_count = int(cap.get(cv2.CAP_PROP_FRAME_COUNT))
        width = int(cap.get(cv2.CAP_PROP_FRAME_WIDTH))
        height = int(cap.get(cv2.CAP_PROP_FRAME_HEIGHT))
        cap.release()
        if frame_count < 30 or width != WIDTH or height != HEIGHT:
            raise RuntimeError(f"Invalid video output for {slug}: {frame_count} frames at {width}x{height}")
        print(f"{path.relative_to(ROOT)}: {frame_count / FPS:.1f}s, {path.stat().st_size / 1_000_000:.2f} MB")


if __name__ == "__main__":
    main()
