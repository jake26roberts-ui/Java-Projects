import java.util.Scanner;
public class RobertsJacobAssignment3 {
	public static void main(String[] args) {
		
		//Discount and Tax Variables
		double taxes = 0.075;
		double studentDiscount = 0.1;
		double militaryDiscount = 0.15;

		String format = "%-40s %-25s %-30s%n";
        
        
        // Print data rows
        System.out.printf(format, "Snack", "With Small Drink", "With Large Drink");
        System.out.println("-----------------------------------------------------------------"); // Divider

        System.out.printf(format, "1. Sandwich / Chip / Drink   ", "$15.50", "$17.50");
        System.out.printf(format, "2. Sandwich / Brownie / Drink", "$14.00", "$16.00");
        System.out.printf(format, "3. Drink Only                ", "$5.75 ", "$7.75 ");
        
        
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("What snack would you like? Select option 1, 2, or 3: ");
        int snackSelection = input.nextInt();
        
        input.nextLine();
                
        System.out.println("Please choose your drink size (Small or Large): ");
        String drinkSelection = input.nextLine();
                
        System.out.println("Are you currently a college student: y/n");
        String studentStatus = input.nextLine();
        System.out.println("Are you currently or have served in the military: y/n");
        String militaryStatus = input.nextLine();
        
        
       //Step 1: Selection Calculations
        double basePrice = 0.0;
        String itemName = "";
        
        if (snackSelection == 1) {
            itemName = "Sandwich/Chip/Drink";
            if (drinkSelection.equalsIgnoreCase("Small")) {
                basePrice = 15.50;
            } // end of second if statement
            else {
                basePrice = 17.50;
            }//end of else statement
        } //end of initial if statement
        
        
        else if (snackSelection == 2) {
            itemName = "Sandwich/Brownie/Drink";
            if (drinkSelection.equalsIgnoreCase("Small")) {
                basePrice = 14.00;
            } //end of else if statement
            else {
                basePrice = 16.00;
            }//end of else statement
        } //end of else if statement
        
        
        else if (snackSelection == 3) {
            itemName = "Drink Only";
            if (drinkSelection.equalsIgnoreCase("Small")) {
                basePrice = 5.75;
            } //end of if statement
            else {
                basePrice = 7.75;
            }//end of else statement
        }//end of else if statement
        
        //Step 2: Calculate Discounts
        double totalDiscountRate = 0.0;
        
        if (studentStatus.equalsIgnoreCase("y")) {
            totalDiscountRate += studentDiscount;
        }//end if statement
        if (militaryStatus.equalsIgnoreCase("y")) {
            totalDiscountRate += militaryDiscount;
        }//end if statement
        
        double reductionAmount = basePrice * totalDiscountRate;
        double priceAfterDiscount = basePrice - reductionAmount;
        
        //Calculations for Taxes and Totals
        double taxAmount = priceAfterDiscount * taxes;
        double finalTotal = priceAfterDiscount + taxAmount;
        
        //printing the final receipt
        System.out.println("\nBeach Snack Receipt");
        System.out.println("---------------------------------");
        
        // Using left alignment (%-22s) so items and numbers align in clean columns
        System.out.printf("%-22s $%.2f%n", itemName, basePrice);
        System.out.printf("%-22s $%.2f%n", "Reduction", reductionAmount);
        System.out.printf("%-22s $%.2f%n", "Taxes", taxAmount);
        
        System.out.println("---------------------------------");
        System.out.printf("%-22s $%.2f%n", "Total", finalTotal);
        
        
        input.close(); //close the Scanner I created       
	}	
}
