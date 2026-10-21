# Guessing Game — Guidelines / Specification

## Overview
A simple guessing game where the player starts with a balance and wagers are applied each round depending on whether the player's guess matches the computer's randomly chosen number.

## Starting Conditions
- Each player begins with a balance of $100.

## Round Flow
- Each round the computer randomly selects an integer between 1 and 10 (inclusive).
- The player is prompted: "Please enter your guess now:" and must enter a whole number.
- The program displays the computer's number each round (e.g., "Computer's Guess: 42").
- After the result is shown, the current balance is printed.

## Win / Loss Rules
- Exact match:
  - Player wins $30.
  - Messages:
    - "Congratulations, you have bested the computer."
    - "You have won $30."
- Non-match:
  - Player loses $10.
  - Message:
    - "Tough luck!"

## Balance & End Condition
- The balance is updated after each round and printed.
- The game loop repeats while balance > 0.
- When balance <= 0 the program ends with these messages:
  - "Well thats too bad... you're out of money :("
  - "Have a nice drive home :)"

## Input Validation
- Only integer input is accepted.
- If the player inputs a non-integer token, the input is consumed and treated as invalid.
- If the entered integer is outside 1–100, the program prints:
  - "Invalid input."
  - "Please enter a whole number from 1 to 10."
- The user entry method returns `-1` for non-integer input (or an invalid sentinel).

## Implementation Details (methods)
- `userEntry(Scanner input)`: Prompts for the guess, returns the next `int` or `-1` on invalid (non-integer) input.
- `win(int bal, int s)`: Returns `bal + s`.
- `lose(int bal, int s)`: Returns `bal - s`.

## Messages & UX
- Print an introductory message that explains the rules and starting balance.
- Print the computer's number each round.
- After each round print the updated balance.
- Print the ending messages when the balance reaches zero or below.

## Example Session (sample output)
- Welcome text / rules
- Prompt: "Please enter your guess now: "
- User enters 5
- Computer prints: "Computer's Guess: 7"
- "Tough luck!"
- "Your current balance: 90"
- ...repeat until balance <= 0
- End messages when out of money

## Suggested Improvements (optional)
- Close the Scanner before program exit to avoid resource warnings.
- Improve input loop to re-prompt immediately on invalid input instead of consuming a turn.
- Add an option to quit early (e.g., enter 0 or `q`).
- Add rounding, logging, or persistent high-score tracking.
- Make win/loss amounts configurable constants.

## Notes
- The current implementation uses `Math.random()` to generate the computer's number: `(int) ((Math.random() * 100) + 1)`.
- Keep messages and spelling consistent (e.g., "Well thats" → "Well that's").
