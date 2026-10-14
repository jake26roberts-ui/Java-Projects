# Example 1:
https://github.com/user-attachments/assets/bced3fb6-6353-4776-8970-a6f7ff70671b

# Example 2:
https://github.com/user-attachments/assets/2d5f5995-1d0b-416a-bb62-2950f516f212

# Explination of Program:
This program takes all integer values, separated by spaces, and uses them as individual "transactions" and prints out one "*" per number of hundreds in each transactions. The program continues to record data until the user types "-1" as shown in example 2 and it continues to record all data of transactions.

## What I learned:
* When using an input scanner, an input of multiple numbers separated by a space are treated as individual inputs, as opposed to one long number.
* How to use a while loop and set the condition to be based off one of the numbers in a sequence that is given by the user.
* To print out each of the "*" outputs and relate those to the number of hundreds that are associated to each transaction.


## Challenges:
* The part I struggled with the most was the for loop that is responsible for printing out "*".


## What I would improve:
* I would add an outer while loop to have a tolerance for mistypeing or "fat-fingering" and typing a letter.
  *   As of right now, the code only reads numbers and has an error if there is a letter in the user's input. To remedy this, I would make it to where it reads up until that point and then asks for you to re-enter the transaction without the letter instead of completely stopping the program.
