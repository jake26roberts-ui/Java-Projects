
# Reflection – BMI Calculator in Java

## Project Overview

This project was Assignment 2 of CS1150. It is a console program that asks the user for their name, their weight in pounds, and their height in feet and inches. It converts the height to total inches, calculates the Body Mass Index (BMI) for the current weight, and prints a table showing the BMI for weights 15, 10, and 5 pounds below and 5, 10, and 15 pounds above the current weight. The table ends with the Department of Health BMI categories.

The main goal was to practice reading several kinds of input from the user, using those values in a formula, and formatting printed output so it lines up like a table.

---

## What I Learned

Before starting this project, I knew how to print text and store user input in variables. I had not used a `Scanner` much, and I did not know how to show a decimal with only two places.

Throughout this project, I learned:

- **Reading input with a `Scanner`:** How to read a full line with `nextLine()` for the name and numbers with `nextDouble()` for the weight and height, then close the `Scanner` with `close()` at the end.
- **Converting units:** How to turn feet and inches into one height in inches with `(heightInFeet * 12) + heightInInches`, since the BMI formula needs inches.
- **Using a formula in code:** How to write the BMI formula as `703 * (weight / (height * height))`. The `height * height` part has to be in parentheses so the division happens after the height is squared.
- **Formatting decimals:** How to use `String.format("%.2f", ...)` so each BMI value shows exactly two decimal places.
- **Building a table with `println`:** How to line up the weight column and the BMI column with spaces, and how to add `(Current Weight)` to the row for the current weight.
- **Line breaks:** How to use `\n` inside a string to add blank lines without adding extra `println` calls.

One of my biggest takeaways was that a formula is only as correct as the order of its operations. Writing the formula with the height squared in parentheses made the result match the value from the assignment.

---

## Code Demonstrations

This section contains screenshots or short recordings demonstrating important parts of the program.

### 1. Gathering User Input

**Method:** `main()`

This section reads the name with `nextLine()`, then reads the weight, feet, and inches with `nextDouble()`. The height is converted to total inches before any calculation happens.

<!-- Insert screenshot or recording here -->

### 2. Calculating the BMI Table

**Method:** `main()`

Each row of the table adds or subtracts 5, 10, or 15 pounds from the current weight and runs the BMI formula on that value. The current weight row is marked with `(Current Weight)`.

<!-- Insert screenshot or recording here -->

### 3. Program Output

**Method:** `main()`

This shows the full run for the input `Jacob`, `180`, `5`, `10`. The program prints the height as `70.0` inches and the current BMI as `25.82`. The table runs from 165.0 to 195.0 pounds in 5-pound steps.

<!-- Insert screenshot or recording here -->

---

## Challenges

The hardest part was getting the formula right. The BMI formula uses the height squared, and I had to be careful to write `height * height` in parentheses so the division happens after the height is squared. Once I did that, the values matched the assignment.

Another challenge was formatting. Java prints the weights as decimals such as `165.0` by default, so I had to decide how to line up the columns and where to put the two-decimal formatting. I used `String.format("%.2f", ...)` for the BMI values and kept the weight values as plain text in the table.

Working through these challenges helped me see how a formula, input conversion, and output formatting each have to be correct for the final table to make sense.

---

## What Went Well

The program does what the assignment asked for. It reads the name, weight, and height, converts the height to inches, and prints the seven-row table with the current weight marked.

I also kept each calculation in its own line so the formula was easy to check against the assignment. The table is easy to read, and the program prints the BMI categories at the bottom as the assignment asked.

The run with `Jacob`, `180`, `5`, `10` produced a BMI of 25.82 for the current weight, which is in the overweight range listed at the bottom of the output.

---

## What I Would Improve

The program has no input validation. If the user types a letter where a number is expected, the `Scanner` throws an error and the program stops. A negative weight or a height of zero would also print values that make no sense. I would add checks so the program only accepts numbers that are in a reasonable range.

The table is also written as seven separate `println` lines that repeat the same formula. I would move the BMI calculation into a method, such as `calculateBMI(double weight, double height)`, and use a loop for the rows. That would remove repeated code and make the table easier to change.

Finally, I would like the output to show the category for the current BMI directly, instead of only listing all the categories at the bottom.

---

## Final Thoughts

This project was my first time working with a `Scanner` for several kinds of input at once, and it taught me how important the order of operations is in a formula.

The biggest thing I learned was how to take user input, convert it into the units a formula needs, and print the result in a clean table. I also learned that the code can be correct and still be hard to maintain, which is why I want to move repeated work into methods in the future.

Overall, this project gave me a solid foundation for reading input, using calculations, and formatting output in Java.
