# Assignment Description - Beach Snack Bar  
Create a "very" simple beach snack bar program that allows the user to select a snack and a drink. The
program reports what snacks were ordered, the cost, any reductions, taxes, and the total cost. The
program must handle invalid selections as described in specification #6 below. See the output section
below for example runs with valid and invalid selections.
Assume the following for this snack bar program:
* The program will process only 1 customer.
* Only one snack from the menu can be ordered.
* The snack bar is limited to the 3 types of snacks listed in the table below.
* The prices are fixed as stated in the table:
``` text
    Snack With                     Small Drink     With Large Drink
    Sandwich / Chip / Drink        $15.50          $17.50
    Sandwich / Brownie / Drink     $14.00          $16.00
    Drink Only                     $5.75           $7.75
```
* College students get a 10% reduction and military get a 15% reduction off snack cost.
* There is a 7.5% charge for taxes (compute after any reduction on total cost)

## Specifications:  
*For variables and constants
  * Be sure to use correct data types (int vs double)
  * Use constants for numeric values that will not change while the code runs.
  * See Must Do and Tips section for an example regarding the use of constants.
* Write code in main that:
  * Displays a menu with the different snacks and prices with a drink
  * Prompts user to select a snack to purchase
  * Reads user input for snack selection and store in a variable
  * If the snack choice is valid
  *  Prompts user for drink size
  * Reads user input for drink size and store in a variable
  * If the drink size is valid
    * Prompts user if student or military or other
    * Reads user input for student or military or other and store in a variable
    * If the customer type is valid
      * Compute the cost and display:
        * Selected snack and its cost for selected drink size
        * Reduction amount (student 10%, military 15%, other 0%)
        * Taxes (after reduction)
        * Total cost
  * See the output section below for example runs of the code.
  * See Must Do and Tips section for more details about properly structuring the code.
* The code must handle invalid user selections for the following 3 user inputs:
  * Snack selection in the menu
    * If an invalid snack option is entered in the menu
      * The code MUST print a message and END PROGRAM
  * Drink size
    * If invalid drink size is entered
      * The code MUST print a message and END PROGRAM
  * Customer type
    * If an invalid customer type is entered,
      * The code MUST print a message BUT continue processing with $0 reduction to the order cost.
## Note:
  * End program means: if a user input error occurs, the program must display an error message and perform no more processing.
  * For example:
    * When asked to select a snack, valid values are 1, 2, and 3 so if the user
enters 4, the program must display an error message and stop at that point.
    * At this point, the code must NOT prompt for the drink size.
    * See output examples #3 and #4 below.
```text
                         What snack would you like? Select option 1, 2, or 3: 4
                         4 is not a valid snack menu item. Please try again, aloha!
```
  * Use NESTED IF statements to handle invalid user input properly.
    * DO NOT use System.exit(0) to exit program if an error occurs.
    * DO NOT use break or return statements if an error occurs.
    * The purpose is to learn to write properly nested if-statements.
