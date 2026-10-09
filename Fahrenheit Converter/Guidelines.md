# Fahrenheit to Celsius Converter Assignment Details:
* Convert every 10 degrees from 0 to 100 degrees using the formula C = (F – 32) X 5/9
* Create a table of temperatures
  *   Place the formula for the conversion directly into the print statements.
  *   Use spaces in the print statements to help make a table that looks like this:
```text
Fahrenheit               Celsius  
---------------------------------------  
0                   -17.77777777777778  
10                  -12.222222222222223  
20                  -6.666666666666667  
30                  -1.1111111111111112  
40                  4.444444444444445  
50                  10.0  
60                  15.555555555555557  
70                  21.11111111111111  
80                  26.666666666666668  
90                  32.22222222222222  
100                 37.77777777777778  
```
## Notes:
* DO NOT enter the above Celsius values directly into the print statements in your code.
 * Placing manually computed results directly into your code in double quotes is called
hard coding. For example, DO NOT write code with print statements like this:
Don’t do this
```text
             System.out.print ("0 -17.77777777777778");
```
* Instead, use the formula and have the computer compute the Celsius values.
* One way to do this is to place the formula for the computation directly inside
the parentheses of the System.out.println statements.
* As an example of placing a computation inside System.out.println, place this
line of code in your program and run the program to see how it works:
```text
             System.out.println("The result is " + (5 * 5 + 2));

     You will see displayed in the console window: The result is 27
     Use this experiment to now compute Celsius for 0 degrees, then 10, etc.
```
