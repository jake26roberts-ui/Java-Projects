import java.util.Scanner;
public class BeachSnackBar {

    public static void main(String[] args) {

        // Discount and Tax Variables
        final double TAXES = 0.075;
        final double STUDENT_DISCOUNT = 0.1;
        final double MILITARY_DISCOUNT = 0.15;

        String format = "%-40s %-25s %-30s%n";

        // Print menu
        System.out.printf(format, "Snack", "With Small Drink", "With Large Drink");
        System.out.println("-----------------------------------------------------------------");

        System.out.printf(format, "1. Sandwich / Chip / Drink", "$15.50", "$17.50");
        System.out.printf(format, "2. Sandwich / Brownie / Drink", "$14.00", "$16.00");
        System.out.printf(format, "3. Drink Only", "$5.75", "$7.75");

        Scanner input = new Scanner(System.in);

        // Snack Selection Loop
        int snackSelection;
        while (true) {
            System.out.print("\nWhat snack would you like? Select option 1, 2, or 3: ");

            if (input.hasNextInt()) {
                snackSelection = input.nextInt();
                input.nextLine();

                if (snackSelection >= 1 && snackSelection <= 3) {
                    break;
                }// end if
            }// end if 
            else {
                input.nextLine();
            }// end else

            System.out.println("Invalid selection. Please enter 1, 2, or 3.");
        }

        // Drink Selection Loop
        String drinkSelection;
        while (true) {
            System.out.print("Please choose your drink size (Small or Large): ");
            drinkSelection = input.nextLine();

            if (drinkSelection.equalsIgnoreCase("Small") || drinkSelection.equalsIgnoreCase("Large")) {
                break;
            }
            else {
            	System.out.println("Invalid drink size. Please enter Small or Large.");
            }
        }

        // Student Status Loop
        String studentStatus;
        while (true) {
            System.out.print("Are you currently a college student (y/n): ");
            studentStatus = input.nextLine();

            if (studentStatus.equalsIgnoreCase("y") || studentStatus.equalsIgnoreCase("n")) {
                break;
            }
            else {
            	System.out.println("Invalid input. Please enter y or n.");
            }
        }

        // Military Status Loop
        String militaryStatus;
        while (true) {
            System.out.print("Are you currently or have served in the military (y/n): ");
            militaryStatus = input.nextLine();

            if (militaryStatus.equalsIgnoreCase("y") || militaryStatus.equalsIgnoreCase("n")) {
                break;
            }// end if
            else {
            	System.out.println("Invalid input. Please enter y or n.");
        
            }// end else
        }  // end while  
        // Selection Calculations
        double basePrice = 0.0;
        String itemName = "";

        if (snackSelection == 1) {
            itemName = "Sandwich/Chip/Drink";

            if (drinkSelection.equalsIgnoreCase("Small")) {
                basePrice = 15.50;
            } // end if
            else {
                basePrice = 17.50;
            }//end else
        }//end if

        else if (snackSelection == 2) {
            itemName = "Sandwich/Brownie/Drink";

            if (drinkSelection.equalsIgnoreCase("Small")) {
                basePrice = 14.00;
            } //end if
            else {
                basePrice = 16.00;
            }// end else
        }//end else if

        else if (snackSelection == 3) {
            itemName = "Drink Only";

            if (drinkSelection.equalsIgnoreCase("Small")) {
                basePrice = 5.75;
            }//end if 
            else {
                basePrice = 7.75;
            }// end else
        }// end else if

        // Calculate Discounts
        double totalDiscountRate = 0.0;

        if (studentStatus.equalsIgnoreCase("y")) {
            totalDiscountRate += STUDENT_DISCOUNT;
        }// end if

        if (militaryStatus.equalsIgnoreCase("y")) {
            totalDiscountRate += MILITARY_DISCOUNT;
        }// end if

        double reductionAmount = basePrice * totalDiscountRate;
        double priceAfterDiscount = basePrice - reductionAmount;

        // Calculations for Taxes and Totals
        double taxAmount = priceAfterDiscount * TAXES;
        double finalTotal = priceAfterDiscount + taxAmount;

        // Print Receipt
        System.out.println("\nBeach Snack Receipt");
        System.out.println("---------------------------------");

        System.out.printf("%-22s $%.2f%n", itemName, basePrice);
        System.out.printf("%-22s $%.2f%n", "Reduction", reductionAmount);
        System.out.printf("%-22s $%.2f%n", "Taxes", taxAmount);

        System.out.println("---------------------------------");
        System.out.printf("%-22s $%.2f%n", "Total", finalTotal);

        input.close();
    }
}
