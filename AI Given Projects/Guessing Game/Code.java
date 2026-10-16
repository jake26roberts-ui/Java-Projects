package aiProjects;
import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int balance = 100;
		System.out.println("Welcome to the Guessing Game!");
		
		System.out.println("Each player will begin the game with $100.");
		
		System.out.print("Each round, the computer will choose a number between 1 and 100. \n");

		
		while (balance > 0) {
			int userGuess = userEntry(input);
			if (userGuess >= 1 && userGuess <= 100) {
			
				int computerEntry = (int)((Math.random() * 100) + 1);
			
				System.out.println("Computer's Guess: " + computerEntry);
				if (userGuess == computerEntry) {
					System.out.println("Congratulations, you have bested the computer.");
					System.out.println("You have won $30.");
					balance = win(balance, 30);
					System.out.println("Your Current Balance: " + balance);
				
				}	//end if
				else {
					System.out.println("Tough luck!");
					balance = lose(balance, 10);
					System.out.println("Your current balance: " + balance + "\n\n");

				}	//end else
			}	//end if
		
			else {
				System.out.println("Invalid input.");
				System.out.println("Please enter a whole number from 1 to 100.");
			}	//end else
		}	//end while
		
		if (balance <= 0) {
			System.out.println("Well thats too bad... you're out of money :(");
			System.out.println("Have a nice drive home :)");
			}	// end else if
		
		}//end if
		//end method
	
	public static int win(int bal, int s) {
		int totalWinnings = bal + s;
		return totalWinnings;
	}	//end method
	
	public static int lose(int bal, int s) {
		int balance = bal - s;
		return balance;
	}	//end method
	
	public static int userEntry(Scanner input) {
		System.out.print("Please enter your guess now: ");
		if (input.hasNextInt()) {
			return input.nextInt();	
		}	//end if
		else {
			input.next();
			return -1;
		}	//end else
		
	}	//end method

}	//end class

