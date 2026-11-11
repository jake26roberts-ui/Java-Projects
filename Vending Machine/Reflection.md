
# Reflection – Vending Machine in Java

## Project Overview

This project was Assignment 6 of CS1150. It is a console program that simulates a snack vending machine with three snacks: Pop Tarts, Pretzels, and Funyuns. Each snack has three slots, labeled A, B, and C, so there are nine selections in total.

A customer can buy one to three snacks per transaction, and the program prints a receipt for each snack. The machine keeps running until a manager enters the shutdown code 999 and the password `COOKIES`. When it shuts down, it prints the grand totals for all customers, including the number of each snack sold and the total sales.

The main goal was to practice nested `while` loops, `for` loops, and a flag variable that controls when a program stops.

---

## What I Learned

Before starting this project, I knew how to use `while` loops, `for` loops, and `if`/`else if`/`else` statements. I did not know how to put loops inside other loops or how to create a shutdown condition for a program that runs continuously.

Throughout this project, I learned:

- **Nested loops:** How an outer `while (inService)` loop keeps the machine running while an inner `for` loop handles each snack in a customer's order.
- **Shutdown conditions:** How to use a `boolean` flag, `inService`, that changes to `false` only when the shutdown code 999 and the password `COOKIES` are both entered.
- **Input checks:** How to keep prompting until the number of snacks is 1, 2, 3, or 999 with a `while` loop.
- **Reading strings:** How to read the selection with `input.next().toUpperCase()` so lowercase codes like `1a` are accepted.
- **Running totals:** How to add to a counter for each snack type, then calculate the total sales after the loop ends.
- **Constants for prices:** How to store prices in `final` variables so they are written once.

One of my biggest takeaways was that a flag variable is the cleanest way to stop a loop that does not have a fixed number of runs.

---

## Code Demonstrations

This section contains screenshots or short recordings demonstrating important parts of the program.

### 1. Displaying the Menu

**Method:** `main()`

The menu is printed at the start of each pass through the outer `while (inService)` loop. It lists the nine selections and their prices.

<!-- Insert screenshot or recording here -->

### 2. Processing Each Snack

**Method:** `main()`

The number of snacks is read first. A `for` loop then runs once for each snack, reading the selection as a `String`, converting it to uppercase, and checking it with an `if`/`else if` chain. Each snack increases its own counter.

<!-- Insert screenshot or recording here -->

### 3. Shutdown Check

**Method:** `main()`

When the number of snacks is 999, the program asks for the password. If the password is `COOKIES`, `inService` is set to `false`, and the outer loop stops at the end of that pass.

<!-- Insert screenshot or recording here -->

### 4. Shutdown Report

**Method:** `main()`

After the loop ends, the program calculates the total sales and prints the number of each snack sold, the total number of snacks, and the total sales.

<!-- Insert screenshot or recording here -->

---

## Challenges

The hardest part was understanding how loops inside loops work together. The outer loop keeps the machine running, and the inner loop handles a single customer's snacks. Keeping track of which loop I was in made the code easier to read once I understood it.

Another challenge was the shutdown. The program must keep running until both the code and the password are correct. Using a `boolean` flag made it possible to stop the outer loop without ending the program early.

The invalid selection check was also difficult. When an invalid selection is entered, the inner loop reads a new value. I did not realize at first that the loop reads two tokens each time it repeats, which I discuss below.

---

## What Went Well

The machine processes a customer's snacks correctly. In a test run I entered `1a` and `3C`, which the program accepted as `1A` and `3C` because the input is converted to uppercase. The shutdown check worked as well: `999` followed by a wrong password returned to the menu, and `999` followed by `COOKIES` shut the machine down.

The final report printed the counts for each snack and the total number of snacks. In that run the report showed Pop Tarts 1, Pretzels 0, Funyuns 1, total snacks 2, and total sales 2.4.

Storing the prices in `final` variables kept the price values in one place.

---

## What I Would Improve

The invalid selection loop has a bug. The loop reads `selection = input.next()` and then calls `input.next()` again without using the value. In a test with the input `1`, `9`, `1A`, `x`, the program printed the invalid message for `9`, then accepted `1A` as the selection and silently discarded `x`. The `x` was never checked, and the loop did not ask for a new selection. I would change the loop so that it reads one value per pass and only consumes the next token when a valid selection is entered.

The total sales also print as a raw `double`. The test run printed `Total overall Sales: 2.4` instead of `$2.40`. I would use `printf("%.2f")` so the total always shows two decimal places in dollars.

Finally, I would move the prices and the snack lookup into a method so the `if` chain for each snack is not repeated in the code.

---

## Final Thoughts

This project showed me how a program can keep running for as long as it needs to and then stop cleanly. It also showed me how nested loops can each have a clear job.

The biggest thing I learned was that input handling needs as much care as the main logic. A loop that reads one token too many can make a program behave in ways that are hard to predict.

Overall, this project made me more comfortable with nested loops, flags, and running totals in Java.
