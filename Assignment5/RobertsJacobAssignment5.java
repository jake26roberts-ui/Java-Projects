import java.util.Scanner;

public class RobertsJacobAssignment5 {
	/* 
	*Name: Jacob Roberts
	* Class: CS1150 (T/Thu)
	* Due: Oct 1, 2026
	* Description: Assignment #5
	* In this assignment you will write a simple while loop. Assume the manager of several small coffee shops
	* wants some statistics regarding the daily sales in all the shops. Write a program that prompts the
	* manager for an unspecified number of daily sales amounts for each coffee store. The number -1 will be
	* used as a sentinel value to indicate the end of the sales amounts. Process the list of sales amounts to
	* determine the statistics as specified in the specifications below
	*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
				
		int numSales = 0;
		int lessThan500 = 0;
		int between500And2000 = 0;
		int moreThan2000 = 0;
		
		double totalOfAllSales = 0;
		double smallestSale = 0;
		double largestSale = 0;
		
		System.out.println("Enter sales from all coffee shops, end input by entering -1: ");
		double sale = input.nextDouble();
		
		//	while loop making the comparisons of the data.
		while (sale != -1) {
			
			totalOfAllSales += sale;
			numSales++;
			
			if (sale < 500) {
				lessThan500++;
			}// end if Statement
			else if (sale <= 2000 && sale >= 800) {
				between500And2000++;
			}	//end else if statement
			else {
				moreThan2000++;
			}//	end else statement
			
			
			
			// find smallest and largest sales
			if (numSales ==1) {
				smallestSale = sale;
				largestSale = sale;
			}//end if statement
			else {
				if (sale <smallestSale) {
					smallestSale = sale;
				}//end if statement
				
				if (sale > largestSale) {
					largestSale = sale;
				}//	end if statement
				
			}// end else statement
			//Printing out the stars like what is in the example
			System.out.println("Sales #" + numSales + ": ");
			
			int starts = (int)(sale / 100);
			
			for (int i=0; i < starts; i++) {
				System.out.print("*");
			}//	end for loop
			
			System.out.println();
			
			sale = input.nextDouble();
		}//	end while loop
		
		//	calculating the average
		double average = 0;
		
		if (numSales > 0) {
			average = totalOfAllSales / numSales;
		}//	end if statement
		
		
		System.out.println();
		System.out.println("values entered when running the code:");
		System.out.println("Number of Sales amounts = " + numSales);
		System.out.println("Smallest sales amount = " + smallestSale);
		System.out.println("Largest sales amount = " + largestSale);
		System.out.println("Total of all sales amounts = " + totalOfAllSales);
		System.out.printf("Average = %.2f%n", average);
		System.out.println("Number of sales amounts less than $500 = " + lessThan500);
		System.out.println("Number of sales amounts between $500 and $2,000 = " + between500And2000);
		System.out.println("Number of sales amounts more than $2,000 = " + moreThan2000);
		
		input.close();
	}//	End of Class

}
