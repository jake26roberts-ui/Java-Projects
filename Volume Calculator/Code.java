import java.util.Scanner;
public class VolumeCalculator {

	/* 
	*Name: Jacob Roberts
	* Class: CS1150 (T/Thu)
	* Due: Oct 15, 2026
	* Description: Assignment #7
	* Write a program that allows the user to compute the volume of 4 different types of shapes - a cube,
	* sphere, cylinder, or rectangular prism using these formulas:
	* Cube volume = s^3 where s = length of a side
	* Sphere volume = 4 π r^3 where r = radius^3
	* Cylinder volume = π r^2 h where r = radius, h = height
	* Rectangular prism = lwh where l = length, w = width, h = height
	*/	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("*************************************");
		System.out.println("  Welcome to the Volume Calculator");
		System.out.println("*************************************");
		
		
		int selection = getShapeOption(input);

		while (selection != 0) {		
			if (selection == 1 || selection == 2 || selection == 3 || selection == 4) {
				if (selection == 1) {
					System.out.println("You have selected 1. Volume of a Cube.");
					System.out.print("Please enter the side length of the cube: ");
					double side = input.nextDouble();
				
					System.out.printf("Your Volume is: %5.2f\n\n", cube(side));
				}//	End if statement
				else if (selection == 2) {
					System.out.println("You have selected 2. Volume of a Sphere.");
					System.out.print("Please enter the radius of the sphere: ");
					double radius = input.nextDouble();
				
					System.out.printf("Your volume is: %5.2f\n\n", sphere(radius));
				
				}// End else if statement
				else if (selection == 3) {
					System.out.println("You have selected 3. Volume of a Cylinder.");
					System.out.print("Please enter the radius of the Cylinder: ");
					double radius = input.nextDouble();
					System.out.print("Please enter the height of the Cylinder: ");
					double height = input.nextDouble();
				
					System.out.printf("Your volume is: %5.2f\n\n", cylinder(radius, height));
				
				}	// End else if statement
				else {
					System.out.println("You have selected 4. Volume of a Rectangular Prism");
					System.out.print("Please enter the length of the Prism: ");
					double length = input.nextDouble();
					System.out.print("Please enter the width of the Prism: ");
					double width = input.nextDouble();
					System.out.print("Please enter the height of the Prism: ");
					double height = input.nextDouble();
				
					System.out.printf("Your volume is: %5.2f\n\n", rectangularPrism(length, width, height));
		
				}// ends else
				
				
					
			}//ends inner if statement
			
			else {
				System.out.println("Invalid input, Here are the options again:\n\n");
			}// end else statement
			//run selection again to avoid a loop 
			selection = getShapeOption(input);
			
		}//ends outer while loop
		if (selection == 0) { //Closes the program.
			System.out.println("\nHappy Mathing :)");
		}// end if statement
		
		input.close();
	
	}

	public static int getShapeOption(Scanner input) {
		int selection;
		do { //My first attempt at a do while loop
	        System.out.println("Which calculation would you like to complete today?");
	        System.out.println("1. Volume of a Cube");
	        System.out.println("2. Volume of a Sphere");
	        System.out.println("3. Volume of a Cylinder");
	        System.out.println("4. Volume of a Rectangular Prism");
	        System.out.println("0. To Quit");

	        System.out.print("Please enter a number 1 - 4 or 0 to quit: ");
	        selection = input.nextInt();

	        if (selection < 0 || selection > 4) {
	            System.out.println(selection + " is not a valid entry - try again\n");
	        }//end if

	    } while (selection < 0 || selection > 4);

	    return selection; // end of do while
	}//end of getShapeOption
	
	
	public static double cube (double s) {
		double volume = Math.pow(s, 3);
		return volume;
	}// end cube
	
	public static double sphere (double r) {
		double volume = (4.0/3.0)*Math.PI*Math.pow(r, 3);
		return volume;
	}// end sphere
	
	public static double cylinder (double r, double h) {
		double volume = Math.PI*Math.pow(r, 2)*h;
		return volume;
	}// end cylinder
	
	public static double rectangularPrism (double l, double w, double h) {
		double volume = l*w*h;
		return volume;
	}// end rectangularPrism
	
	
	

}
