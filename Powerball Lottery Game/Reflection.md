# Example 1:
https://github.com/user-attachments/assets/ea178fbb-a9ff-4706-a4d4-c96459a25000

# Example 2:
https://github.com/user-attachments/assets/349f97b0-0d32-46e4-b83e-87340316dbfa

# Example 3:
https://github.com/user-attachments/assets/decbb4c8-4379-4afc-b9be-14c340b8fc71

## Running Demo
[Watch the Powerball demo](<../artifacts/java-demos/videos/powerball.mp4>) — this was recorded from the program running.

# Reflection

## What the Program Does
The user enters two letters and a number from 1 to 10. The program makes a random ticket and compares it with the user's ticket. It then prints a message based on which parts match.

## What I Learned
* I learned to use `charAt()` to get a letter out of a `String`, and `Character.toUpperCase()` to handle lowercase letters too.
* I practiced using `Math.random()` to pick letters and a number for the computer's ticket.
* I learned that checking input in order matters. The program checks the letters before it asks for the number.
* I used boolean variables to remember which parts of the ticket match.

## Challenges
The nested `if` statements were confusing at first. I had the checks in the wrong places, so the program did not go through the steps in the order I expected. I used the debugger and some help to work out how to arrange them.

I also had to think carefully about the different match combinations. Looking back, there are combinations the current `if` statements do not cover, such as matching one letter and the number. I would like to work on that logic more.

## What I Would Improve
* Check that the number input is actually a number before trying to read it.
* Make sure every possible match combination gets the right message.
* Add an option to play again and move the prize amounts into named constants.

## Final Takeaway
This project gave me practice working with characters, random values, and nested decisions. I am still getting comfortable with boolean logic, and figuring out what each match condition meant was the hardest part. I would like to test more combinations next time.
