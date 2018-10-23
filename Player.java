//*******************************
//* Name: Safal Bhandari
//* Project: Jutpatti
//* Date:10/21/2018
//*******************************

package CardGame;

public class Player extends Common {
	
	//Holds the name of the player
	String name;	
	

	// ****************************
	// Function Name: Player
	// Purpose: Constructor to create an instance of deck of cards
	// Parameters: name, a string to hold the name of the player
	// Return value: none
	// Assistance Received: none
	// ****************************
	public Player(String nameOfPlayer) 	
	{
		name = nameOfPlayer;
		
	}
	
	
	// ****************************
	// Function Name: getname()
	// Purpose: returns the name of the player
	// Parameters: none
	// Return value: name, a string to hold the name of the player
	// Assistance Received: none
	// ****************************
	public String getname() 
	{
		return name;
	}
	
	
	// ****************************
	// Function Name: setname(argument 1)
	// Purpose: sets the name of the player
	// Parameters: nameChange, a string that holds the changed name of the player
	// Return value: none
	// Assistance Received: none
	// ****************************
	public void setname(String nameChange)
	{
		name = nameChange;
	}
	
	
	// ****************************
	// Function Name: displayCards
	// Purpose: print the display statement
	// Parameters: none
	// Return value: none
	// Assistance Received: none
	// ****************************
	public void displayCards() 												
	{
		System.out.println(name + ", The set of cards you have are: ");
			
	}
	
	
	// ****************************
	// Function Name: win
	// Purpose: Displays congratulation message
	// Parameters: none
	// Return value: none
	// Assistance Received: none
	// ****************************
	public void win()														
	{
		System.out.println("Congratulations " + name + ". You won!!");
 	}
	
	
	//
	// ****************************
	// Function Name: throwCard
	// Purpose:Prompt user to throw a card and ask for input to throw which card
	// Parameters: none 
	// Return value: none
	// Assistance Received: none
	// ****************************
	public void throwCard() 												
	{
		System.out.println("Please throw a card, "+ name+ ".");
		System.out.println("Which card do you want to throw? Please input index:");
		
	}
	
	
	// ****************************
	// Function Name: cardFromDeckORTable
	// Purpose: Asks user to pick card from table or deck
	// Parameters:none
	// Return value: none
	// Assistance Received: none
	// ****************************
	public void cardFromDeckORTable()
	{
		System.out.println("Do you want to take the card thrown on TABLE or pick one from DECK?");	
		System.out.println("Enter deck for DECK, and Table for Table");
	}
	
	
}
