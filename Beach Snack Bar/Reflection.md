
# Reflection – Beach Snack Bar in Java

## Project Overview

This project was Assignment 3 of CS1150. It is a console program that simulates a beach snack bar for one customer. The program shows a menu of three snack options with their prices for a small or large drink. The customer picks a snack, a drink size, and says whether they are a college student and whether they are a veteran or active military. The program then prints a receipt with the base price, any reduction, the taxes, and the total.

The assignment also asked for specific error handling. An invalid snack or drink size should end the program, and an invalid customer type should print a message and continue with no reduction. It also asked for nested `if` statements to handle those errors, not loops. My program does not fully meet those requirements, which I describe below.

The main goal was to practice `if`/`else` branches, discounts that depend on user answers, and printing a formatted receipt.

---

## What I Learned

Before starting this project, I knew how to get input, store values in variables, and do basic calculations. I did not know how to choose between several options based on two answers, or how to apply a discount before adding tax.

Throughout this project, I learned:

- **Nested `if` statements:** How to check the snack choice first and then check the drink size inside each snack option.
- **Choosing between options:** How to pick the right base price for each snack and drink combination with `if` and `else` branches.
- **Input validation loops:** How to use a `while (true)` loop with `break` to keep asking until the answer is valid. I also learned that this is not the same as the nested `if` approach the assignment asked for.
- **Stacking discounts:** How to add the student rate (0.10) and the military rate (0.15) into one `totalDiscountRate` before applying it.
- **Calculating taxes after discounts:** How to apply the 7.5% tax to the price after the reduction, not the original price.
- **Formatting a receipt:** How to use `printf` with `%-22s` and `%.2f` so the labels line up and each dollar amount shows two decimal places.

One of my biggest takeaways was that the order of the calculations matters. The reduction has to come first, then the tax, then the total.

---

## Code Demonstrations

This section contains screenshots or short recordings demonstrating important parts of the program.

### 1. Printing the Menu

**Method:** `main()`

The menu uses `printf` with a fixed format string so the snack names and the two price columns line up. Each snack has a small and a large drink price.

<!-- Insert screenshot or recording here -->

### 2. Choosing the Base Price

**Method:** `main()`

This section uses nested `if` statements. The outer check picks the snack, and the inner check picks the price for a small or large drink.

<!-- Insert screenshot or recording here -->

### 3. Calculating the Discount, Tax, and Total

**Method:** `main()`

This section adds the student and military discount rates together, subtracts the reduction from the base price, and then applies the 7.5% tax to the discounted price.

<!-- Insert screenshot or recording here -->

### 4. Receipt Output

**Method:** `main()`

This section prints the item, the reduction, the taxes, and the total. A run with `1`, `Small`, `y`, `n` printed the following receipt values:

- Base price: $15.50
- Reduction: $1.55
- Taxes: $1.05
- Total: $15.00

A second run with `2`, `Large`, `n`, `y` printed a base price of $16.00, a reduction of $2.40, taxes of $1.02, and a total of $14.62.

<!-- Insert screenshot or recording here -->

---

## Challenges

The hardest part was understanding the difference between the way I wrote the error handling and the way the assignment asked for it. The assignment says invalid input should end the program and that I should use nested `if` statements. I wrote `while (true)` loops instead, so an invalid snack like `4` prints `Invalid selection. Please enter 1, 2, or 3.` and the program asks again. That is not the behavior the assignment asked for.

Another challenge was keeping the discount math correct. The student and military rates are added together before the reduction is applied, and the tax is applied to the reduced price. Checking the two test runs by hand helped me confirm the numbers.

Working through these challenges helped me understand how the order of calculations and the structure of the input checks each change the result.

---

## What Went Well

The receipt calculations are correct for the valid runs I tested. The first run, `1`, `Small`, `y`, `n`, produced a reduction of $1.55 (10% of $15.50), taxes of $1.05 on the discounted $13.95, and a total of $15.00. The second run, `2`, `Large`, `n`, `y`, produced a reduction of $2.40 (15% of $16.00) and a total of $14.62.

The menu is also easy to read. The `printf` format string keeps the columns aligned, and I used constants for the tax and discount rates so they are only written once.

---

## What I Would Improve

The biggest change would be to match the error handling in the assignment. For the snack choice and the drink size, the program should print the error and end. I would replace the `while (true)` loops with nested `if` statements so the program stops after the first bad answer.

For an invalid customer type, the program should print a message and continue with a $0 reduction. Right now it asks the question again. Changing this would make the program follow the assignment exactly.

I would also store the prices in a single place. The prices for each snack and drink size are written as literal numbers inside the `if` branches, and the same numbers appear in the menu. Constants for the prices would make the program easier to change.

---

## Final Thoughts

This project helped me practice nested `if` statements and the order of discount and tax calculations. It also showed me that a program can produce correct numbers and still not follow every rule in the assignment.

The biggest thing I learned was that the error handling is part of the requirements, not an extra. Next time I will read the error rules before I choose a loop or a branch.

Overall, this project made me more comfortable with branching logic, discounts, and formatting receipts in Java.
