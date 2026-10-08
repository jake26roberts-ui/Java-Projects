#  Assignment 6: Simulating a vending machine
To simulate the vending machine, the code must do 2 things:  
## Task 1: Implement the customer mode
  * Create a loop that waits for customer input and continues running until the vending machine is shut down
  * The main while loop could look like the following:
``` text
boolean inService = true;
while (inService) {
// Display menu
// Process snack selection
// Inside the loop the boolean variable inService will be
// changed to false when the shutdown code 999 & COOKIES is entered
}
o Display a menu showing a vending machine with the following snacks:
*******************************************
Snack Machine
*******************************************
Pop Tarts Pop Tarts Pop Tarts
1A $0.90 1B $0.90 1C $0.90
This assignment is not for distribution online or by any other means. Copyright M. Gonzalez UCCS
--------------------------------------------
Pretzels Pretzels Pretzels
2A $0.70 2B $0.70 2C $0.70
--------------------------------------------
Funyuns Funyuns Funyuns
3A $1.50 3B $1.50 3C $1.50
--------------------------------------------
```
  * Prompt the customer for the number of snacks they want to purchase
* The maximum number of snacks allowed is 3.
* This step is also where the vending machine can be shut down
* See Task 2 for details on shutting down the vending machine.
  * Validate the number of snacks
* Use a while loop to validate user input.
* The program does not proceed until the number of snacks is valid or shutdown mode has been entered.
* When the loop ends, the number of snacks is either valid, or shutdown mode has been selected.
  * If the number of snacks is not the shutdown number (999), process the snack purchases:
* Create a for loop that iterates based on the number of snacks the user wants:
* Prompt the customer for one snack selection
  * Be sure to handle upper- and lower-case letters (e.g. 1A and 1a should be accepted as valid user inputs).
  * The snack selection must be read as a String.
* Validate the snack selection
  * Use a while loop to validate user input.
* Display a receipt for the individual snack, including:
  * The snack selected
  * The snack price
* Update the following counters:
  * Total number of each specific snack purchased (# pop tarts, etc.)
  * Total number of all snacks purchased
  * Total sales  
## Task 2: Implement a way to shut down the vending machine & print a report with grand totals.  
  * Essentially, we need a way to stop the customer mode and end the program.
  * We’ll refer to this as “shutting down the vending machine.”
  * To shut down the vending machine, the user must enter two inputs:
* Shutdown code – 999
* Shutdown password - COOKIES
  * Perform the following steps to shut down the vending machine:
* At the main menu, when promoted for the number of snacks, an employee enters the shutdown code (999).
* If 999 is entered, the program must then prompt for the shutdown password.
* If both the shutdown code (999) and shutdown password (“COOKIES”) are entered correctly:
* Exit the main while loop
* Generate and display a shutdown report that includes:
  * Total sales for all customers
  * Total number of snacks sold for all customers
  * Total number of pop tarts, pretzels, and funyuns sold
