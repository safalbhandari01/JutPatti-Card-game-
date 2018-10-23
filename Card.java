//*******************************
//* Name: Safal Bhandari
//* Project: Jutpatti
//* Date:10/21/2018
//*******************************

package CardGame;

public class Card {
	
	//Holds face value of the card
	private String face;
	
	//Holds suit value of the card
	private String suit;
	
	// ****************************
	// Function Name: Card
	// Purpose: serves as a default constructor
	// Parameters: none
	// Return value: none
	// Assistance Received: none
	// ****************************
	public Card() {
		
	}
	
	
	// ****************************
	// Function Name: Card
	// Purpose: Overloading constructor to create a card instance 
	// Parameters: 
	// suit, a string to hold the suit value of the card
	// face, a string to hold the value of the face card
	// Return value: none
	// Assistance Received: none
	// ****************************
	public Card(String inputFace, String inputSuit) {
		face = inputFace;
		suit = inputSuit;
	}
	
	
	//****************************
	//Function Name: Card
	//Purpose: return the face value of the card
	//Parameters: none
	//Return value: face of the card
	//Assistance Received: none
	//****************************
	public String getFace() {
		return face;
	}
	
	
	//****************************
	//Function Name:getSuit
	//Purpose: return the suit value of the card
	//Parameters: none
	//Return value: suit of the card
	//Assistance Received: none
	//****************************
	public String getSuit() {
		return suit;
	}
	
	
	//****************************
	//Function Name: FaceSuit
	//Purpose: returns the faceSuit value of the card
	//Parameters: none
	//Return value: the string representation of the card
	//Assistance Received: none
	//****************************
	public String faceSuit() {
		return getFace() + getSuit();
	}
	
	
}
