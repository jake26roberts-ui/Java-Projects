import java.util.Scanner;
public class RobertsJacobAssignment6 {
	public static void main(String[] args) {
	   Scanner input = new Scanner(System.in);

     	// 	Constants for snack prices
        final double POP_TARTS_PRICE = 0.90;
        final double PRETZELS_PRICE = 0.70;
        final double FUNYUNS_PRICE = 1.50;

	    // 	Variables for running totals across all customers
        int totalPopTarts = 0;
        int totalPretzels = 0;
        int totalFunyuns = 0;
        int totalSnacksSold = 0;
        double totalSales = 0.0;

        boolean inService = true;

        while (inService) {
	    //	Display menu
            System.out.println("*******************************************");
            System.out.println("             Snack Machine");
            System.out.println("*******************************************");
            System.out.println("Pop Tarts      Pop Tarts     Pop Tarts");
            System.out.println("1A  $0.90      1B  $0.90     1C  $0.90");
            System.out.println("--------------------------------------------");
            System.out.println("Pretzels       Pretzels      Pretzels");
            System.out.println("2A  $0.70      2B  $0.70     2C  $0.70");
            System.out.println("--------------------------------------------");
            System.out.println("Funyuns        Funyuns       Funyuns");
            System.out.println("3A  $1.50      3B  $1.50     3C  $1.50");
            System.out.println("--------------------------------------------");
	        
            
            //	Prompt for number of snacks
            System.out.print("How many snacks would you like? Limit is 3: ");
            int numSnacks = input.nextInt();
            input.nextLine();
            
            while (numSnacks != 1 && numSnacks != 2 && numSnacks != 3 && numSnacks != 999) {
            	System.out.println("Invalid entry. Enter a number between 1 and 3: ");
            	numSnacks = input.nextInt();
            }

            if (numSnacks == 999) {
	        	System.out.print("Enter shutdown password: ");
	        	String password = input.next();
	        	
	        	if (password.equals("COOKIES")) {
	        		inService = false;
	        		System.out.println("");
	        	}//		End if statement
	        
	        	
            }//		end if statement
        	else {
                // Customer mode: process items using a for loop
                for (int i = 0; i < numSnacks; i++) {
                    System.out.print("Enter snack selection: ");
                    String selection = input.next().toUpperCase();
                    
                    while (!selection.equals("1A") && !selection.equals("1B") && !selection.equals("1C") && !selection.equals("2A") && !selection.equals("2B") && !selection.equals("2C") && !selection.equals("3A") && !selection.equals("3B") && !selection.equals("3C")) {
                    	System.out.println("Invalid entry. Enter 1A-1C, 2A-2C or 3A-3C: ");
                    	selection = input.next().toUpperCase();
                    	input.next();
                    }//		end sub-while loop
                    
                    String snackName = "";
                    double snackPrice = 0.0;
                    
	                if (selection.equals("1A") || selection.equals("1B") || selection.equals("1C")) {
	                	snackName = "Pop Tarts";
	                	snackPrice = POP_TARTS_PRICE;
	                	totalPopTarts++;
	                }// 	end if statement
	                
	                else if(selection.equals("2A") ||selection.equals("2B") || selection.equals("2C")) {
	                	snackName = "Pretzels";
	                	snackPrice = PRETZELS_PRICE;
	                	totalPretzels++;
	                }//		end else if statement
	                
	                else if(selection.equals("3A") || selection.equals("3B") || selection.equals("3C")) {
	                	snackName = "Funyuns";
	                	snackPrice = FUNYUNS_PRICE;
	                	totalFunyuns++;
	                }//		end else if statement
	                
	                System.out.println("");
	                System.out.println("---------------------------------------------");
	                System.out.println("-----------------Selection " + selection + "--------------");
	                System.out.println("----------------------------------------------------------");
	                System.out.println("Snack Item:   " + snackName);
	                System.out.printf("Snack Price:   %.2f\n", snackPrice);
	                
                }//		end for loop
                System.out.println("-------------------------------------");
                System.out.println("Thank you for your business!");
                System.out.println("-------------------------------------\n\n\n");
            }//		end else statement
	        
        }// 	End while loop
        
        totalSales = (totalPopTarts * POP_TARTS_PRICE) + (totalPretzels * PRETZELS_PRICE) + (totalFunyuns * FUNYUNS_PRICE);
        totalSnacksSold = totalPopTarts + totalPretzels + totalFunyuns;

		System.out.println("Overall totals from all customers: ");
        System.out.println("Total Pop Tarts: " + totalPopTarts);
        System.out.println("Total Pretzels: " + totalPretzels);
        System.out.println("Total Funyuns: " + totalFunyuns);
        System.out.println("Total snacks sold: " + totalSnacksSold);
        System.out.println("Total overall Sales: " + totalSales);
        
        
        
        input.close();
    }// end method
}// end class
