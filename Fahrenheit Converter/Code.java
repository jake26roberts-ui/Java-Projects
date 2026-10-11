import java.util.Scanner;
public class FahrenheitConverter {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Part 2 – working with expressions
		//Title of the table that I am going to make
		System.out.println("Fahrenheit to Celsius Conversion Table");
		
		System.out.println("Please enter a value to start at: ");
		int start = input.nextInt();
		System.out.println(" Fahrenheit               Celsius ");
		
		System.out.println("---------------------------------------------");
		
		//This is a scalable version of my first set of code.
		for (double i = start; i <= start + 100; i += 10) {
			double celsius = (i - 32)*5/9;
			System.out.printf("%10d     %10.4f%n", (int)i, celsius);
		}//end of for-loop
		
	} // main
} // end class FahrenheitConverter
