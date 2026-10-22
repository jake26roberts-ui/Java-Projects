# Reflection

https://github.com/user-attachments/assets/da67aad0-f1c6-440a-816d-796bb0d60543

## Running Demo
[Watch the BMI Calculator demo](<../artifacts/java-demos/videos/bmi.mp4>) — this was recorded from the program running.

## What the Program Does
The program asks for a name, weight, and height. It changes the height from feet and inches into total inches, then uses the BMI formula to print BMI values for the current weight and for weights 5, 10, and 15 pounds above and below it. It also prints BMI ranges for comparison.

## What I Learned
* I practiced reading text and numbers with a `Scanner`. I used `nextLine()` for the name and `nextDouble()` for the measurements.
* I learned to convert feet to inches before using the height in the BMI formula.
* I used `String.format` to show the BMI numbers with two decimal places. That makes the table easier to read.
* I got practice printing a group of results in a table-like layout.

## Challenges
There are several long calculations in the print statements. It was easy to lose track of parentheses, and I can see how a method could help me avoid repeating the same formula.

I also had to get the height conversion right. The formula needs inches, so I multiply the feet by 12 and add the remaining inches. If that part is wrong, all of the BMI results will be wrong too.

## What I Would Improve
* Put the BMI calculation in a method so I do not have to repeat the formula in each row.
* Add checks so letters or invalid measurements do not stop the program.
* Use a loop to print the different weights instead of writing each row separately.
* Make the columns line up more neatly and allow the user to calculate BMI for another person without restarting.

## Final Takeaway
This project helped me connect user input, unit conversion, math, and formatted output. I am still learning how to organize repeated calculations, and this program showed me that methods and loops could make it easier to read. I am happy that it prints the current BMI along with some nearby values for comparison.
