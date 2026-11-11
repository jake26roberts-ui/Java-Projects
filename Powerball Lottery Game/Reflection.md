# Reflection – Powerball Lottery Game in Java

## Project Overview

This project was Assignment 4 of CS1150. It is a console program that simulates a simple Powerball lottery game. The player enters two letters from A to Z and one Powerball number from 1 to 10 to make a ticket. The program then generates a random winning ticket in the same format, compares the two tickets, and prints the prize, if any.

The prizes are a jackpot for matching both letters and the number, $100 for matching both letters, $40 for matching one letter, and $20 for matching only the Powerball number. The program must end right away if the player types an invalid string, an invalid letter, or an invalid number.

The main goal was to practice working with individual characters in a string, generating random values, comparing values with `if` statements, and validating input with nested `if` statements.

---

## What I Learned

Before starting this project, I knew how to get input, store values in variables, and print results. I did not know how to pull single characters out of a string, how to create random letters, or how to stop the program cleanly when the input is wrong.

Throughout this project, I learned:

- **Working with characters:** How to use `charAt()` to get each letter from the input string, and how to use `Character.toUpperCase()` so the user can type lowercase letters.
- **ASCII values:** How the letter `'A'` has the ASCII value 65, and how adding a random number from 0 to 25 to 65 and casting the result to a `char` produces a random letter.
- **Constants:** How to use `final` values like `MIN_POWERBALL`, `MAX_POWERBALL`, and `MIN_LETTER` so each range is set in one place.
- **Comparing booleans:** How to store each match in a `boolean` variable, such as `letter1Matches`, and then check the combinations in an `if`/`else if` chain.
- **Nested validation:** How to check the length of the string first, then the letters, then the number, with each invalid case printing an error in its own `else` block.
- **Using the debugger:** How to step through the code to find a mistake in the prize logic. The `!=` check I had in the wrong place was easy to find that way.

One of my biggest takeaways was that the order of the checks in an `if`/`else if` chain decides which prize message the player sees.

---

## Code Demonstrations

This section contains screenshots or short recordings demonstrating important parts of the program.

### 1. Validating the Player's Letters

**Method:** `main()`

The program first checks that the string has exactly two characters. Then it converts each letter to uppercase and checks that both are between `'A'` and `'Z'`. Any other input prints an error and ends the program.

<!-- Insert screenshot or recording here -->

### 2. Generating the Winning Ticket

**Method:** `main()`

The winning letters are created by adding a random number from 0 to 25 to `MIN_LETTER` (65, the ASCII value for `'A'`) and casting the result to a `char`. The winning number is `1 + (int)(Math.random() * 10)`, which gives a value from 1 to 10.

<!-- Insert screenshot or recording here -->

### 3. Deciding the Prize

**Method:** `main()`

The program stores each match in a `boolean`, then checks the jackpot, the $100 prize, the $40 prize, and the $20 prize in order.

<!-- Insert screenshot or recording here -->

### 4. Sample Output

**Method:** `main()`

A run with the player ticket `ab 5` printed the player's ticket next to the winning ticket. The program printed one of the prize messages, or `Your Powerball ticket did not win.` when nothing matched.

<!-- Insert screenshot or recording here -->

---

## Challenges

The hardest part was the prize logic. I first had every check in its own `if` statement, which made the program give the wrong result. I had to move the checks into one `if`/`else if` chain so only one prize message prints for each ticket. The debugger helped me find where the `!=` check was in the wrong place.

Validation was also a challenge. I had to make sure the program stops right away when the input is wrong, without using `System.exit()`, `return`, or `break`. Putting the checks in nested `if` statements made each error stop the flow of the program.

Working through these challenges helped me understand how the order of conditions controls the output.

---

## What Went Well

The program handles the input validation as the assignment asked. A string such as `P#` prints `Invalid entry - need 2 letters between A and Z for a Valid Powerball ticket` and stops. A valid letter pair with the number `11` prints `Invalid entry - need number between 1 and 10 for this ticket to be valid` and stops.

The random draw works as expected. In a batch of 400 runs with the player ticket `ab 5`, the program printed the one-letter prize ($40) 30 times and the number-only prize ($20) 46 times. The other 324 runs printed `did not win`. A two-letter win ($100) appeared in an earlier test run.

I also used constants for the ranges and the ASCII value, which made the random letter and number code easy to read.

---

## What I Would Improve

The biggest issue is the one-letter prize. If the player matches one letter and also matches the Powerball number, the program prints `did not win`. The assignment only tests the cases it lists, so this is not wrong by itself, but a player who matches one letter and the number should probably still win something. I would decide that rule first and then update the `if` chain to match it.

I also have not tested the jackpot path. The code checks it first, and it should print `Congratulations! You won the Jackpot!` when all three values match. In 400 random runs with the ticket `ab 5`, the jackpot never appeared, so I cannot show it working from a real run.

I would also move the prize rules into a method, such as `determinePrize()`, so `main()` only handles the input and output.

---

## Final Thoughts

This project helped me understand how a program can use random values to simulate something from real life. It also helped me see why input validation has to happen before the rest of the program runs.

The biggest thing I learned was how to compare several conditions in the right order. The debugger was also useful because it let me see the values as the program ran.

Overall, this project made me more confident working with characters, random values, and nested conditions in Java.
