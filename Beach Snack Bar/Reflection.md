# Example output 1:

https://github.com/user-attachments/assets/4fd14259-c278-493a-ab48-0f5e403b7b00

# Example output 2:

https://github.com/user-attachments/assets/9f853d81-5411-4f25-9b8b-348ad253f3ee

# Example output 3:

https://github.com/user-attachments/assets/d50ce5ce-df2b-4a0f-ade2-67cb6ff8851c

## Running Demo
[Watch the Beach Snack Bar demo](<../artifacts/java-demos/videos/snack-bar.mp4>) — this was recorded from the program running.

## Reflection
The program shows a menu with three snack choices and two drink sizes. It asks about student and military discounts, then prints the price, discount, tax, and total on a receipt.

### What I Learned
* I practiced using `equalsIgnoreCase()` so the user can type words with different capitalization.
* I learned to use `while` loops to ask again when the snack, drink size, or yes/no answer is not valid.
* I used constants for the tax and discount amounts. That made it easier to see what those numbers are for.
* I practiced calculating the discount before adding tax, as the assignment asks.
* I used `printf` to make the menu and receipt look more organized.

### Challenges
The receipt took some adjusting to make the item names and amounts line up. I also had to handle the leftover newline after reading the snack number; otherwise the drink question could get skipped. Figuring out when to use `nextInt()` and when to read a whole line took some practice.

The version I have now asks again for invalid answers. The assignment instructions wanted the program to stop after some invalid choices, so my input handling does not exactly follow that part of the instructions.

### What I Would Change
* Let the program handle another customer's order without restarting.
* Make the receipt show the student and military discounts separately.
* Add more input checks so unexpected answers are handled clearly.

### Final Takeaway
This project gave me practice with menus, `if` statements, loops, and simple money calculations. I am still learning how to handle all the different kinds of input, but I like that the program produces a receipt instead of only printing a total.
