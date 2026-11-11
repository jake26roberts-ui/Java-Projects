# Reflection – Sales Statistics in Java

## Project Overview

This project was Assignment 5 of CS1150. It is a console program that helps a coffee shop manager track daily sales from several shops. The program keeps asking for sales amounts until the user enters -1, which is the sentinel value that ends the input.

For each sale, the program prints a line of stars to show its size, with one star for every $100. At the end, it prints the statistics: the number of sales, the smallest and largest sale, the total, the average, and how many sales fall into each of three ranges (less than $500, $500 to $2,000, and more than $2,000).

The main goal was to practice a `while` loop that runs for an unknown number of inputs, keep track of running totals, and use counters and comparisons to find the smallest and largest values.

---

## What I Learned

Before starting this project, I knew how to get input, do calculations, and use `if` statements. I did not know how to keep a loop running for an unknown number of inputs or how to track the smallest and largest values as they come in.

Throughout this project, I learned:

- **Sentinel-controlled loops:** How to keep reading sales with `input.nextDouble()` until the user enters -1. The loop reads the first value before it starts, and the last line of the loop reads the next value, so the loop stops on the sentinel.
- **Counters:** How to use `numSales++` and the range counters to count each sale as it is read.
- **Smallest and largest values:** How to set both to the first sale when `numSales == 1`, then update them only when a new sale is smaller or larger.
- **Average:** How to divide the total by the number of sales, and only do that when `numSales > 0`, so the program does not divide by zero.
- **For loops for output:** How to use a `for` loop to print one star for each $100 in a sale, using `(int)(sale / 100)`.
- **Debugging:** How to use the debugger to check the values of the counters on each pass through the loop.

One of my biggest takeaways was how a loop can run without knowing the number of inputs ahead of time, as long as a sentinel value ends it.

---

## Code Demonstrations

This section contains screenshots or short recordings demonstrating important parts of the program.

### 1. Reading the Sales and Updating the Totals

**Method:** `main()`

The `while` loop runs until the sale is -1. On each pass it adds the sale to `totalOfAllSales`, increases `numSales`, and updates the smallest and largest values.

<!-- Insert screenshot or recording here -->

### 2. Sorting Sales into Ranges

**Method:** `main()`

Each sale is placed in one of three counters: less than $500, between $500 and $2,000, or more than $2,000. The middle range check is written with `if`/`else if`/`else` statements.

<!-- Insert screenshot or recording here -->

### 3. Printing the Stars

**Method:** `main()`

A `for` loop prints one `*` for each $100 in the sale, so a $1,421 sale prints 14 stars. Each sale line is labeled with its number.

<!-- Insert screenshot or recording here -->

### 4. Statistics Output

**Method:** `main()`

The statistics section prints the count, smallest, largest, total, and average. The average uses `printf("%.2f")` so it shows two decimal places.

<!-- Insert screenshot or recording here -->

---

## Challenges

The main challenge was tracking the smallest and largest sales. I had to set both to the first sale when the count is 1, because a starting value of 0 would have made the smallest sale always 0. Checking `numSales == 1` before the comparisons fixed that.

The second challenge was the range counts. I had the middle range check written as `sale <= 2000 && sale >= 800` instead of `sale >= 500`. When I tested it, sales between $500 and $799 were counted as more than $2,000. I had not caught this when I first wrote the code.

Working through these challenges helped me understand how a single wrong number in a condition can change the result without causing an error.

---

## What Went Well

The program matches the sample output for the first example in the assignment. The input `245 820 2010 801 1421 -1` printed 5 sales with a total of 5297.0, an average of $1,059.40, and counts of 1, 3, and 1 for the three ranges.

The star output also works. The `for` loop prints one star per $100, and each sale has its own labeled line.

Using the `sentinel` value of -1 kept the loop simple, and the average check for zero sales kept the program from dividing by zero.

---

## What I Would Improve

The biggest problem is the middle range check. It should be `sale >= 500 && sale <= 2000`, but the code uses 800 as the lower limit. When I ran `500 650 -1`, the program printed 0 sales under $500, 0 between $500 and $2,000, and 2 over $2,000. The correct result is 0, 2, and 0. The second example from the assignment, `3001 728 -1`, has the same problem: it prints 0, 0, and 2 when the correct result is 0, 1, and 1.

When the user enters only -1, the program prints the statistics with zeros for the smallest and largest values. The assignment asks for a message such as `No sales amounts entered except -1`, and my program does not print that message.

I would also store the three range limits as constants, such as `LOW_LIMIT` and `HIGH_LIMIT`, so the boundaries are written once and easy to check.

---

## Final Thoughts

This project showed me how a `while` loop with a sentinel value works, and how to track running totals and extremes as data comes in.

The biggest thing I learned was to test the boundary values of a condition. The bug in the middle range check only showed up when I tested sales between $500 and $799.

Overall, this project made me more comfortable with loops, counters, and the statistics that a program can calculate from a list of values.
