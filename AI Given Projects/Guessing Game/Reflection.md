# Reflection

## Running Demo
[Watch the Guessing Game demo](<../../artifacts/java-demos/videos/guessing.mp4>) — this was recorded from the program running.

## What the Program Does
The game starts the player with $100. The computer picks a number and the player enters a guess. A correct guess adds $30, and a wrong guess takes away $10. The game keeps going while there is still money left.

## What I Learned
* I learned how to make a random number with `Math.random()`. I still have to think about the multiplication and adding 1 to get the range I want.
* I practiced using methods. `userEntry` gets the guess, while `win` and `lose` update the balance. Making these methods helped me split up the program.
* I learned to use `hasNextInt()` to check whether the next input is a whole number before reading it.
* I also got more practice with a `while` loop and keeping the balance updated between rounds.

## Challenges
One challenge was deciding what number range to use. I changed the computer's range to 1 through 10, but I missed updating the input check and message, which still say 1 through 100. This means some guesses are accepted even though the computer cannot pick them. I need to make those ranges agree.

Another challenge was making the game repeat and stop at the right time. The balance changes after each round, and the loop ends once it is no longer above zero. I had to pay attention to where the balance gets updated so the game would not keep going forever.

## What I Would Improve
* Make the guess range and the instructions match.
* Let the player add money or choose to stop playing.
* Make the money amounts easier to change by putting them in named constants.
* Give invalid guesses another prompt and close the scanner when the game ends.

## Final Takeaway
This project helped me practice methods, random numbers, input checking, and loops in one program. I am still learning how to keep different parts of a program consistent, and the range mismatch showed me why I need to test more than one example. I would like to improve the input checks next.
