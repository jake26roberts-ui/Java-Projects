
# Reflection – Volume Calculator in Java

## Project Overview

This project was Assignment 7 of CS1150. It is a console program that calculates the volume of four shapes: a cube, a sphere, a cylinder, and a rectangular prism. The user chooses a shape from a menu, enters the measurements, and the program prints the volume with two decimal places. The user can keep choosing shapes until they enter 0 to quit.

Each formula is in its own method, so the main program only handles the menu and the input. The menu is shown by a separate method, `getShapeOption()`, which repeats until the user enters a number from 0 to 4.

The main goal was to practice writing and calling methods that return values, using a `do-while` loop, and formatting numbers with `printf`.

---

## What I Learned

Before starting this project, I knew how to use a `Scanner`, `while` loops, `for` loops, and `printf`. I did not know how to write my own methods, how to return a value from a method, or how to use a `do-while` loop.

Throughout this project, I learned:

- **Methods that return values:** How to write methods like `cube(double s)` and `sphere(double r)` that take inputs and return a volume with `return`.
- **Calling methods:** How to call a method from `main()` and use the returned value in a `printf` statement, such as `printf("Your Volume is: %5.2f\n\n", cube(side))`.
- **Do-while loops:** How to write `getShapeOption()` so the menu always shows at least once and repeats while the number is outside the range 0 to 4.
- **Math formulas in Java:** How to use `Math.PI` and `Math.pow()` for the sphere, cylinder, and cube formulas, and how `4.0/3.0` is written with decimals so the division is not rounded to an integer.
- **Nested `if` statements:** How to check the menu choice and then run the matching set of input prompts and calculations.
- **Formatting output:** How to use `printf("%5.2f")` to show each volume with two decimal places.

One of my biggest takeaways was that a method can do one job, like computing a formula, and return the result, so `main()` stays short and easy to read.

---

## Code Demonstrations

This section contains screenshots or short recordings demonstrating important parts of the program.

### 1. Choosing a Shape

**Method:** `getShapeOption(Scanner input)`

This method uses a `do-while` loop to print the menu and read the user's number. If the number is less than 0 or greater than 4, it prints the error and asks again. It returns the number once it is in range.

<!-- Insert screenshot or recording here -->

### 2. Calculating the Volume of a Shape

**Methods:** `cube(double s)`, `sphere(double r)`, `cylinder(double r, double h)`, `rectangularPrism(double l, double w, double h)`

Each method takes the measurements as parameters and returns the volume. The formulas are `s^3`, `(4/3)πr^3`, `πr^2h`, and `l × w × h`.

<!-- Insert screenshot or recording here -->

### 3. Main Program Loop

**Method:** `main(String[] args)`

The `while (selection != 0)` loop runs the chosen calculation, prints the result, and then calls `getShapeOption()` again. When the user enters 0, the program prints `Happy Mathing :)` and closes the `Scanner`.

<!-- Insert screenshot or recording here -->

### 4. Sample Output

**Method:** `main(String[] args)`

These test runs printed the expected volumes:

- Cube with side 3: 27.00
- Sphere with radius 2: 33.51
- Cylinder with radius 3 and height 4: 113.10
- Rectangular prism 2 × 3 × 4: 24.00

An entry of `9` printed `9 is not a valid entry - try again`, and an entry of `0` printed `Happy Mathing :)`.

<!-- Insert screenshot or recording here -->

---

## Challenges

The main challenge was understanding how a method returns a value and how that value gets used. At first it was hard to see why `cube(side)` could go inside `printf` without storing it in a variable. Once I saw that the method call is replaced by its return value, it made sense.

Another challenge was the `do-while` loop. I had to make sure the menu prints at least once, and that the loop repeats only when the number is outside the range. Writing the loop condition as `selection < 0 || selection > 4` took a few tries to get right.

Working through these challenges helped me become more comfortable writing methods and using their results in the main program.

---

## What Went Well

The program correctly calculates all four volumes. The test runs matched the expected values for the cube, sphere, cylinder, and prism.

The input check works as intended. Entering `9` prints the error and shows the menu again, and entering `0` quits the program.

Splitting each formula into its own method made the code easy to check. Each method is short, and the main program does not need to know the math.

---

## What I Would Improve

The `else` branch in `main()` that prints `Invalid input, Here are the options again` can never run. `getShapeOption()` already rejects any number outside 0 to 4 and asks again, so `main()` only sees valid numbers. I would remove that branch so the code does not suggest that it can happen.

The program also does not handle text input. If the user types a letter when a number is expected, `input.nextInt()` will throw an error and stop the program. I did not test this case, but I would add a check for non-numeric input.

I would also consider putting the prompts and the calculations for each shape into their own methods, so the `if` chain in `main()` would be shorter.

---

## Final Thoughts

This project helped me understand how to split a program into small methods. Each method has one job, and the code is easier to test than one long `main()`.

The biggest thing I learned was how to return a value from a method and use it in the main program. I also learned that a `do-while` loop is a good fit for a menu that must show at least once.

Overall, this project made me more confident writing methods, using loops for menus, and formatting numeric output in Java.
