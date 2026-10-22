# Example 1:
https://github.com/user-attachments/assets/bced3fb6-6353-4776-8970-a6f7ff70671b

# Example 2:
https://github.com/user-attachments/assets/2d5f5995-1d0b-416a-bb62-2950f516f212

## Running Demo
[Watch the Sales Statistics demo](<../artifacts/java-demos/videos/sales.mp4>) — this was recorded from the program running.

## What the Program Does
The program reads sales amounts until the user enters `-1`. For each amount, it prints a small bar made of stars. At the end it prints information such as the number of sales, the total, the average, and the smallest and largest amounts.

## What I Learned
* I learned that `Scanner` can read several numbers from one line, one at a time.
* I practiced using a `while` loop that stops when it reads the special value `-1`.
* I used another loop to print stars based on each sale amount.
* I learned how to keep track of a total, a count, and the smallest and largest values while reading the sales.

## Challenges
The star chart was difficult to get right at first. I had to divide the sale by 100 so a sale of a few hundred dollars would not print hundreds of stars.

I also had to read the first sale before the loop so the program can handle `-1` as the first input. While reviewing the results, I noticed that the code's middle category starts at 800, even though the label says 500. That means some sales are counted in the wrong category.

## What I Would Improve
* Fix the middle sales category so it starts at $500.
* Check the input so a letter does not stop the program.
* Print a clearer message if there are no sales.
* Test values around $500, $800, and $2,000 to check the categories.

## Final Takeaway
This project helped me practice loops and keeping track of numbers as the program runs. I am still learning to test the edge cases, and I found that the program can look correct with some sample numbers but still have a problem with values between $500 and $799.
