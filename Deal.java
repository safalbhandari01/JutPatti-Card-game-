//*******************************
//* Name: Safal Bhandari
//* Project: Jutpatti
//* Date:10/21/2018
//*******************************

package CardGame;

//import java.util.Scanner;

public class Deal {
	
	//Creating object of deck class to distribute the deck of cards among the players
	Deck deckObject = new Deck();
	
	//Holds the number of players in the game
	int numPlayers;
	
	//Holds the number of cards to be dealt to each player before starting the game
	int numCards;
	
	
	// ****************************************************************
	// Function Name: Deal()
	// Purpose: serves as a default constructor for the class.
	// Purpose: sets the numPlayer, numCards to default values.
	// Parameters: none
	// Return value: none
	// Assistance Received: none
	// ****************************************************************
	Deal()
	{
		numPlayers = 2;
		numCards = 7;
		deckObject.shuffleArrayList();
	}
	
	
	// ****************************************************************
	// Function Name: Deal(argument1, argument2)
	// Purpose: serves as an overloading constructor for the class
	// Parameters: numberOfPlayers, numberOfCards
	// Return value: none
	// Assistance Received: none
	// ****************************************************************
	
	Deal(int numberOfPlayers, int numberOfCards){
		numPlayers = numberOfPlayers;
		numCards = numberOfCards;
		deckObject.shuffleArrayList();
	}
	
	
	
	// ****************************************************************
	// Function Name: cardsForHand(argument1, argument2)
	// Purpose: deals a set of cards for each player before starting the game using 
	//			player object from player class
	// Parameters: playerObject, player name
	// Return value: none
	// Assistance Received: none
	// ****************************************************************
	public void cardsForHand(Player playerObject, String name) {
		
		System.out.println(name +", The starting set of cards assigned for you are:" );
		for(int j = 0; j<numCards; j++)
		{
			Card element = deckObject.popElementAt(0);
			playerObject.addCard(element);
		}
		playerObject.print();
	}
	
	
	//Function that gets the next card from the deck
	// ****************************************************************
	// Function Name: getNext()
	// Purpose: returns the next card from the deck and remove it from the deck
	// Parameters: none
	// Return value: none
	// Assistance Received: none
	// ****************************************************************
	public Card getNext() {
		
		Card element = deckObject.popElementAt(0);
		return element;
	}
	
	
	
	
}
