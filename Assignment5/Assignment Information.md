# Assignment 5 Description - Sales Statistics
In this assignment you will write a simple while loop. Assume the manager of several small coffee shops
wants some statistics regarding the daily sales in all the shops. Write a program that prompts the
manager for an unspecified number of daily sales amounts for each coffee store. The number -1 will be
used as a sentinel value to indicate the end of the sales amounts. Process the list of sales amounts to
determine the statistics as specified in the specifications below.
## Specifications
 Write code that:
  * Initializes the necessary counters – numSales, totalOfAllSales, etc.
  * Prompts the user for an unspecified number of sales for all the coffee shops
    * All sales must be entered on a single line.
    * The last sales amount must be -1.
    * See Must Do and Tips section for tips and the Output section for examples.
  * Reads the first sales amount
    * It could be a -1 so need to read before the loop
  * Uses a while loop to perform the following 4 tasks for each sales amount:
    * Add current sales amount to the running total for:
      * Total of all sales
    * Increment counters for the following based on the current sales amount
      * Number of sales
      * Number of sales less than $500, between $500 and $2000, or greater than
$2000
    * Determine if the current sales amount is:
      * The smallest sale in the sequence
      * The largest sale in the sequence
    * Display bar chart with asterisks for current sales amount
      * Display a specific number of asterisks for the sales amount
      * Each asterisk represents $100 in sales.
      * This requires another loop inside the main while loop.
  * After the main while loop completes:
    * Determine and display the following statistics:
    * The number of sales entered
    * The smallest sales amount
    * The largest sales amount
    * The total sum of all sales
    * The average of the sales
    * How many sales amounts are less than $500
    * How many sales amounts are between $500 and $2000
    * How many sales amounts are more than $2000
## Must Do and Tips
* ### Must Do: Use variables of correct types
  * int should be used for counters
  * double should be used for each sales amount, the total of all sales, and other numeric values
* ### Must Do: Allow user to enter all values before you start processing
  * This means you should prompt only one time for the sales amounts
  * The user should enter all values on one line then press enter. See example below in Output.
  * The sales amount must be read as a double.
  * DO NOT read input as a string and parse.
* ### Must Do: Use a while loop
  * Each iteration of the main loop processes 1 sales amount in the sequence of entered values.
  * When the value -1 is read, it indicates the end of the list, so the loop ends.
  * The first sales amount must be read before entering the loop to handle the case where the user
enters only a -1 and the loop needs to be skipped. See output example #3 below for this case.
* ### Must Do: Display bar charts before the statistics
  * For the bar chart to be displayed before the statistics, create and display the bar chart for each
sales amount inside the main while loop.
* ### Must Not Do:
**  The following will each individually result in a loss of points.**
  * DO NOT read input as a string and parse.
  * DO NOT use a do-while loop.
  * DO NOT use an array or array list to store the sales amounts.
  * DO NOT use System.exit() or break statements to exit the loop
    * Instead, write the loop properly so it completes when the boolean expression is false.
  * Increment in the number of sales counter
  * Determine if the sale is < 500, between 500 and 2000, or > 2000
    * Increment correct counter
  * Determine if the sale is larger than the largest sale seen so far
    * If it is - update largest
  * Determine if the sale is smaller than the smallest sale seen so far
    * If it is - update smallest
  * Display the bar chart for the current sales amount
  * Read the next sale from the list as the last task in the while loop.

##Output 
Your output should look like the following:
Example #1
```text
Enter sales from all coffee shops, end input by entering -1: 245 820 2010 801 1421 -1
Sales #1: **
Sales #2: ********
Sales #3: ********************
Sales #4: ********
Sales #5: **************
Values entered when
Number of sales amounts = 5 running the code
Smallest sales amount = 245.0
Largest sales amount = 2010.0
Total of all sales amounts = 5297.0
Average = 1059.40
Number of sales amounts less than $500 = 1
Number of sales amounts between $500 and $2000 = 3
Number of sales amounts more than $2000 = 1
```
Example #2
```text
Enter sales from all coffee shops, end input by entering -1: 3001 728 -1
Sales #1: ******************************
Sales #2: *******
Number of sales = 2
Smallest sales amount = 728.0
Largest sales amount = 3001.0
Total of all sales amounts = 3729.0
Average = 1864.50
Number of sales amounts less than $500 = 0
Number of sales amounts between $500 and $2000 = 1
Number of sales amounts more than $2000 = 1
```
Example #3
```text
Enter sales from all coffee shops, end input by entering -1: -1
No sales amounts entered except -1
```
