# Volume Calculator

## Overview

A Java console application that calculates the volume of common three-dimensional shapes. It uses a menu-driven interface so a user can calculate multiple volumes during one run and exit when finished.

## Features

- Calculate the volume of a cube, sphere, cylinder, or rectangular prism.
- Repeat calculations without restarting the program.
- Validate menu choices and prompt again when a choice is outside the available options.
- Keep calculation logic in separate methods and display results in `main`.
- Format calculated volumes to two decimal places.

## Volume Formulas

| Shape | Formula | Variables |
|---|---|---|
| Cube | `V = s^3` | `s` = side length |
| Sphere | `V = (4/3) * pi * r^3` | `r` = radius |
| Cylinder | `V = pi * r^2 * h` | `r` = radius; `h` = height |
| Rectangular prism | `V = l * w * h` | `l` = length; `w` = width; `h` = height |

## Menu

| Option | Shape |
|---:|---|
| 1 | Cube |
| 2 | Sphere |
| 3 | Cylinder |
| 4 | Rectangular prism |
| 5 | Exit |

## Program Structure

The program uses a menu method to validate and return the selected option, plus separate methods for calculating each shape's volume. The method signatures are shown here as a reference; this snippet is not a complete, standalone Java program.

```java
public static int getShapeOption(Scanner userInput)
public static double cubeVolume(double side)
public static double sphereVolume(double radius)
public static double cylinderVolume(double radius, double height)
public static double rectangularPrismVolume(double length, double width, double height)
```

The main loop gets a menu choice, processes the selected shape, and asks for another choice until the user selects the exit option. The returned menu choice is stored in a variable each time.

```java
int shapeOption = getShapeOption(userInput);

while (shapeOption != EXIT) {
    // Use a switch statement to process the selected shape.
    // Read the required dimensions and store them in variables.
    // Store the calculated volume in a variable before displaying it.

    shapeOption = getShapeOption(input);
}
```

## Design Notes

- `getShapeOption` handles invalid menu choices and keeps prompting until the user selects a valid option.
- Each volume method performs the calculation and returns a `double`.
- The `main` method handles user interaction and displays results.
- Store method return values in variables before using them in output statements.
- Keep methods focused on one responsibility and add comments explaining their purpose.

## Concepts Practiced

Java methods, return values, `while` loops, `switch` statements, console input with `Scanner`, input validation, and arithmetic with `Math.PI`.
