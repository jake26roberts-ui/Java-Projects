# Assignment 2 Description - BMI Calculator:  
The UCCS gym needs a program to calculate a person’s body mass index (BMI). The program must prompt the user for their personal information and then present the results in a table showing the BMI for the person’s current weight as well as for the weight 5, 10 and 15 pounds below and above the
current weight. Overall, the program must do the following:
* Prompt for the personal details needed to compute BMI
* Display the personal details and computed BMI values in a well formatted table
* Display the extra BMI values from the department of health. (See output below for example)  
  
**The formula for calculating BMI is:**  
BMI = 703 X (𝑤𝑒𝑖𝑔ℎ𝑡𝐼𝑛𝑃𝑜𝑢𝑛𝑑𝑠/ℎ𝑒𝑖𝑔ℎ𝑡𝐼𝑛𝐼𝑛𝑐ℎ𝑒𝑠 𝑥 ℎ𝑒𝑖𝑔ℎ𝑡𝐼𝑛𝐼𝑛𝑐ℎ𝑒𝑠)


# Specifications:   
Use the following constants/variables:
* int constant for the constant value in the BMI formula – set the integer constant to 703
* String data type for the person’s name
* double data type for the numeric values
  
Write a program that computes and displays the BMI values for one person by doing the following:
* Prompt (i.e. ask) the user for each of the following details then read each input from the
user and store each input in a variable:
  * Name - use the nextLine method in the Scanner class to read the person’s name
  * Weight – use the nextDouble method in the Scanner class
  * Height in feet and inches - use the nextDouble method in the Scanner class
* Compute the following values and store each value in a variable:
  * Person’s height in inches
    * Use the values entered by the user (ex. 5’ 8’’ = 68”)
  * BMI for current weight
    * Use the given formula
  * BMI for 5, 10, and 15 pounds less than current weight
    * Use the given formula but change weight
  * BMI for 5, 10, and 15 pounds greater than current weight
    * Use the given formula but change weight
* Display a nicely formatted table that shows the following details.
  * Name
  * Weight
  * Height
  * BMI for 5, 10, 15 pounds less than current weight
  * BMI for current weight
  * BMI for 5, 10, 15 pounds greater than current weight
* Display the BMI values from the department of health.
