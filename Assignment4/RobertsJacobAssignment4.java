import java.util.Scanner;
public class RobertsJacobAssignment4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Constant values to use for later
		final int MIN_POWERBALL = 1;
		final int MAX_POWERBALL = 10;
		
		final int MIN_LETTER = 65;//ASCII value for 'A'
		
		//Formatting the initial Interface
		System.out.println("Welcome to the powerball!");
		System.out.println("-----------------------------------------\n");
		System.out.println("Match 2 Letters and Powerball Number: Win the Jackpot");
		System.out.println("Match only 2 Letters: Win $100.00");
		System.out.println("Match only 1 Letter: Win $40.00");
		System.out.println("Match Only Powerball Number: Win $20.00");
		System.out.println("-----------------------------------------\n");
		
		System.out.print("Enter 2 letters between A and Z with no space between them: ");
		String userTicketLetters = input.nextLine();
		//Validate the user's input before we keep going
		//Utilized ChatGPT to help me with my logic. It wasn't working originally because I had everything in it's own if/else statement.
		//Helped me move things to the right order within the nested if Statements and it stopped giving me errors.
		//I also had it to where after every input, the code ended because I was kicking myself out of my code midway through because I had the invalid statements in the same if statement.
		userTicketLetters.length();
			if (userTicketLetters.length() == 2) {
				
				//Converts any letter inputed into a capital letter, allowing for any letter input
				char firstLetter = Character.toUpperCase(userTicketLetters.charAt(0));
				char secondLetter = Character.toUpperCase(userTicketLetters.charAt(1));
				
				//This if statement verifies that both letters are between A and Z
				if (firstLetter >= 'A' && secondLetter <= 'Z' && secondLetter >= 'A' && firstLetter <= 'Z') {
					
					// Beginning of the Number verification Area because the Letters have been verified as Valid for the ticket
					System.out.print("Enter the number on your ticket (1-10): ");
					int playerPowerballNumber = input.nextInt();
					
					//Now to verify if the number falls within the acceptable range
					if (playerPowerballNumber >= MIN_POWERBALL && playerPowerballNumber <= MAX_POWERBALL) {
						String playerTicket = firstLetter + " " + secondLetter + " " + playerPowerballNumber;
						
						//This is where I am going to place my Generation of the random Powerball Values
						char firstGeneratedLetter = (char)(MIN_LETTER + (int)(Math.random() * 26));
						char secondGeneratedLetter = (char)(MIN_LETTER + (int)(Math.random() * 26));
						
						int generatedPowerballNumber = 1 + (int)(Math.random() * 10);
						
						String randomizedTicket = firstGeneratedLetter + " " + secondGeneratedLetter + " " + generatedPowerballNumber;
						
						//Displaying both tickets:
						System.out.println("\nCustomer Lottery Ticket:");
						System.out.println(playerTicket);
						
						System.out.println("\nPowerball Winning Ticket");
						System.out.println(randomizedTicket);
						
						//Comparison between generated and user tickets:
						boolean letter1Matches = firstLetter == firstGeneratedLetter;
						boolean letter2Matches = secondLetter == secondGeneratedLetter;
						boolean numberMatches = playerPowerballNumber == generatedPowerballNumber;
						
						//If statements that determine if anything was won by the user
						if (letter1Matches && letter2Matches && numberMatches) {
							System.out.println("Congratulations! You won the Jackpot!");
						}
						else if (letter1Matches && letter2Matches) {
							System.out.println("Congrats! Your ticket matched 2 letters -- you won $100.00");
						}
						else if ((letter1Matches || letter2Matches) && !numberMatches) { //the Debugger helped me fix my logic for lines 74-77 (I had my != in the wrong spot)
							System.out.println("Player ticket matched 1 letter -- you won $40.00");
						}
						else if (numberMatches && !letter1Matches && !letter2Matches) {
							System.out.println("Player ticket matched only the powerball number -- you won $20.00");
						}
						else {
							System.out.println("Your Powerball ticket did not win.");
						}
						
					}//end of Third if statement
					
					else {
						System.out.println("Invalid entry - need number between 1 and 10 for this ticket to be valid");
					}
					
				}//end of second if statement
				
				
				else {
					System.out.println("Invalid entry - need 2 letters between A and Z for a Valid Powerball ticket");
				}//end of second else statement
				
			}//End of first if statement
			else {
				System.out.println("Invalid Entry - need 2 letters between A and Z for this Powerball Drawing");
			}//end of first else statement
		
		input.close();
	}

}
