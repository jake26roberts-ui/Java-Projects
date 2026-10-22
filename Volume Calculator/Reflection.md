# Project Reflection

## Running Demo
[Watch the Volume Calculator demo](<../artifacts/java-demos/videos/volume.mp4>) — this was recorded from the program running.

## Project Overview
**Project:** Volume Calculator
**Language/Tools:** Java, Eclipse
**Purpose:** Calculate the volume of a cube, sphere, cylinder, or rectangular prism using a menu.

## What I Learned
* I practiced putting calculations in separate methods. Each shape has its own method that returns a volume.
* I learned to use `Math.PI` and `Math.pow()` in the formulas.
* I used a `do while` loop in the menu method so the menu repeats if the user enters a number outside the choices.
* I practiced passing the same `Scanner` into a method to read the menu choice.
* I used `printf` to show each answer with two decimal places.

## Challenges
The menu has to appear before the program can check what the user chose, so I had to get used to how a `do while` loop works. I also needed to make the sphere formula use `4.0 / 3.0`; using whole numbers there would give the wrong result in Java.

The main program has several `if` statements for the different shapes. It works, but I think I could make that section easier to follow as I learn more about `switch` statements.

## What I Would Improve
* Check the dimensions and make sure they are positive numbers.
* Check for letters before using `nextInt()` or `nextDouble()` so the program can handle mistakes better.
* Try a `switch` statement for choosing the shape.
* Store each result in a variable before printing it, as the assignment asks.

## Final Takeaway
I am glad I was able to make a menu that lets someone calculate more than one shape without restarting the program. This project gave me practice with methods and loops. I am still learning how to organize a longer `main` method, and I would like to make the menu easier to follow next time.
