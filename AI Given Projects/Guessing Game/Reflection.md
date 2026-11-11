# Reflection – Guessing Game in Java

## Project Overview

This project is one of the AI Given Projects in my repo. It is a console game that follows the specification in `Guidelines.md`. The player starts with a balance of $100. Each round, the computer chooses a random whole number from 1 to 10, and the player guesses a number. An exact match wins $30, and any other guess loses $10. The game keeps running while the balance is above zero, then prints the ending messages.

The program is split into three helper methods, `win()`, `lose()`, and `userEntry()`, so the main game loop stays short. The code is in the `aiProjects` package.

The main goal was to practice generating random numbers, reading input safely with a `Scanner`, and using methods to update a value in a loop.

---

## What I Learned

Before starting this project, I knew how to use a `Scanner`, `while` loops, and `if`/`else` statements. I had not used `Math.random()` to make a random number, and I had not split a game into helper methods that return values.

Throughout this project, I learned:

- **Generating a random number:** How `(int)((Math.random() * 10) + 1)` produces a whole number from 1 to 10. `Math.random()` returns a value from 0 up to, but not including, 1, so multiplying by 10 and adding 1 gives the range the game needs.
- **Checking input without crashing:** How `input.hasNextInt()` checks the next token before `nextInt()` reads it, so a word like `abc` does not throw an error.
- **Consuming bad input:** How `userEntry()` calls `input.next()` when the token is not an integer, then returns `-1` as an error value.
- **Returning values from methods:** How `win(int bal, int s)` and `lose(int bal, int s)` take the balance and an amount, then return the new balance for the main program to store.
- **Looping on a condition:** How the `while (balance > 0)` loop repeats the game until the player runs out of money.

One of my biggest takeaways was that a method can hide a small job, like reading valid input, so the main loop reads like the rules of the game.

---

## Code Demonstrations

This section contains screenshots or short recordings demonstrating important parts of the program.

### 1. Generating the Computer's Number

**Method:** `main()`

The computer's number is created with `(int)((Math.random() * 10) + 1)`. It prints as `Computer's Guess: ` followed by a number from 1 to 10 each round.

<!-- Insert screenshot or recording here -->

### 2. Reading the Player's Guess

**Method:** `userEntry(Scanner input)`

This method prints the prompt and checks `input.hasNextInt()`. If the next token is a whole number, it returns it. Otherwise it reads and discards the token with `input.next()` and returns `-1`.

<!-- Insert screenshot or recording here -->

### 3. Winning and Losing

**Methods:** `win(int bal, int s)` and `lose(int bal, int s)`

`win()` adds the prize to the balance and `lose()` subtracts the penalty. The main loop stores the returned value in `balance` and prints it.

<!-- Insert screenshot or recording here -->

### 4. Ending the Game

**Method:** `main()`

When the balance drops to zero or below, the loop stops and the program prints `Well thats too bad... you're out of money :(` and `Have a nice drive home :)`.

<!-- Insert screenshot or recording here -->

### 5. Sample Output

**Method:** `main()`

A short run with the guess `1` showed the win and loss messages and the running balance after each round.

<!-- Insert screenshot or recording here -->

---

## Challenges

The main challenge was deciding how hard to make the game. The guidelines say the computer picks from 1 to 10, but the input check in the code accepts 1 to 100. The range controls how often the player can win, so the input check and the computer's range have to agree.

Another challenge was making the computer keep playing until the player runs out of money. The `while (balance > 0)` loop does this, but I had to make sure the balance is updated with the returned value from `win()` or `lose()` each round.

Working through these challenges helped me understand how a loop, a condition, and a method call all work together to keep a game running.

---

## What Went Well

The game follows the main rules in the spec. It starts with $100, awards $30 for an exact match, takes $10 for a miss, and ends with the two closing messages when the balance reaches zero.

The input handling works for bad input. Entering `abc` prints `Invalid input.` and asks for a new guess without crashing the program. Entering `0` prints the same error because it is outside the accepted range.

Moving the win and loss math into `win()` and `lose()` made the main loop easy to follow.

---

## What I Would Improve

The biggest issue is the range mismatch. The code accepts any guess from 1 to 100, but the computer only picks from 1 to 10. In a test run I entered `50`, and the program accepted it without an error. A guess from 11 to 100 can never win, which is not what the game rules say. The error message also says `1 to 10`, but the check uses 100. I would make the range check match the computer's range, then make the message match the check.

The game also has no way to quit early. The spec suggests entering `0` or `q` to leave. Right now the only way to stop is to lose all the money or to close the program. When I ended the input in a test run, the program crashed with `java.util.NoSuchElementException`, because `userEntry()` calls `input.next()` and there was no more input to read.

Finally, the `Scanner` is never closed. The spec suggests closing it before the program exits, and I would add `input.close()` at the end of `main()`. I would also make the win message and the lose message use the same capitalization. Right now one says `Your Current Balance` and the other says `Your current balance`.

---

## Final Thoughts

This project showed me how a small game can be built from a few clear pieces: a random number, input checking, a loop, and helper methods that return new values.

The biggest thing I learned was how to check input before using it. `hasNextInt()` and returning an error value kept the game running after a bad guess. I also learned that a range check and a random number range need to match, or some valid guesses can never win.

Overall, this project made me more comfortable with random numbers, methods that return values, and loops that run until a condition changes.
