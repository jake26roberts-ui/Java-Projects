# Assignment Description
*Write a program that simulates a simple Powerball lottery game. The program will first obtain several
Powerball values from the player to generate the player’s lottery ticket, second the program randomly
generates a Powerball lottery ticket, and finally to simulate the game, the program compares the
player’s ticket to the randomly generated ticket. See the output section below showing example runs.  
**The Powerball game details are:**
Simple Powerball:
  * The player (user) enters values that are used to create a “player” lottery ticket:
    * 2 letters between A and Z
    * 1 Powerball number between 1 and 10
  * The code generates the following random values to create a “generated” lottery ticket:
    * 2 letters between A and Z
    * 1 Powerball number between 1 and 10
  * The player ticket is compared to the randomly generated ticket to determine if player won:
    * Jackpot
    * $100.00
    * $40.00
    * $20.00

## Specifications:  
**Write code that:**
* Displays a menu for the game.
  * See output section below for example.
* Prompts the user for the player lottery ticket letters:
  * Read user input as one string
* If the user entered a 2-character string without spaces between the letters
  * Validate the player lottery ticket letters in the string:
    * Each character must be between A and Z
  * If the player lottery ticket letters are valid,
    * Prompts and validates user input for player Powerball number:
      * 1 number that must be between 1 and 10
* If user input is valid for the player ticket (letters & number)
  * Create the randomly generated lottery ticket:
    * 2 letters between A and Z and
    * 1 number between 1 and 10
* Display player lottery ticket and generated lottery ticket.
* Test if player ticket is a winner and display results:
  * **Note:** Not all possible cases for the 2 letters and 1 number are being tested, only the
following cases:
  * Win jackpot:
    * Player ticket matched the 2 letters and number of the generated ticket
  * Win $100:
    * Player ticket matched only the 2 letters of the randomly generated ticket
  * Win $40:
    * Player ticket matched only 1 letter of the randomly generated ticket
  * Win $20:
    * Player ticket matched only the Powerball number of the randomly
generated ticket

  
**The code must handle user validation for:**
* Player lottery ticket letters
  * If an invalid string length is entered, MUST print message and END PROGRAM
    * Accepting only 2 letters
  * If an invalid character is entered, MUST print message and END PROGRAM
    * Each letter must be between ‘A’ and ‘Z’ or ‘a’ and ‘z’
* Player lottery ticket number
  * If an invalid Powerball number is entered, MUST print message and END PROGRAM
* **Note:**
  * **End program means:** once an input error occurs, the program must display an error
message and perform no more processing.
  * For example:
    * If the user enters the string P# when asked for the 2 letters, the program
must display an invalid entry error message and complete at that point.
    * At this point, no processing for the Powerball number must occur.
    * See error output example #3 below.
  * Use NESTED IF statements to properly handle errors in user input.
    * Use an if statement to perform a test (say on the number of letters entered)
and if the test fails, the else clause executes, displays the error message,
and the program terminates.
    * DO NOT use System.exit(0) to exit program if error occurs.
    * DO NOT use break or return statements if error occurs.
    * Using System.exit, return, or break will result in loss of points for
correctness.
    * The purpose is to learn to write properly nested if-statements.
