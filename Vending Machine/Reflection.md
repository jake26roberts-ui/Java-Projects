# Reflection

## Running Demo
[Watch the Vending Machine demo](<../artifacts/java-demos/videos/vending.mp4>) — this was recorded from the program running.

## What the Program Does
The program shows a snack machine menu. A customer chooses how many snacks to buy and enters a slot like `1A` or `2B`. The machine keeps track of the different snacks sold. An employee can enter a shutdown code and password to end the program and print the totals.

## What I Learned
* I practiced using a `while` loop to keep the machine running for more than one customer.
* I used a `for` loop to ask for each snack in an order.
* I learned to compare text with `equals()` and to change lowercase slot entries to uppercase.
* I used counters to keep track of how many of each snack were sold.
* I got practice working with several loops and `if` statements in the same program.

## Challenges
There are a lot of steps in this program, so keeping track of which loop or `if` statement I was in could be confusing. I also had to make the shutdown option different from a normal snack count.

When reviewing the code, I noticed an extra `input.next()` in the invalid snack-selection loop. That might consume the next answer after an invalid selection, so I would remove it and test the retry again. I also did not add checks for letters where the program expects a number.

## What I Would Improve
* Check numeric input before reading it so a typo does not stop the program.
* Tell the employee when the shutdown password is incorrect.
* Make the final sales amount print with two decimal places.
* Add a way for the machine to accept payment and give change.

## Final Takeaway
This project helped me practice using loops to keep a program running and to process more than one item. It was one of the bigger programs I had tried at that point, so getting the snack choices and totals to work together felt like progress. I still need more practice with input errors and checking each path through the program.
