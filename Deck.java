//*******************************
//* Name: Safal Bhandari
//* Project: Jutpatti
//* Date:10/21/2018
//*******************************

package CardGame;
public class Deck extends Common
{


	// ****************************
	// Function Name: Deck
	// Purpose: Constructor to create an instance of deck of cards
	// Parameters: none
	// Return value: none
	// Assistance Received: none
	// ****************************
	public Deck()
	{
		String faces[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		String suits[] = { "C", "D", "H", "S" };
		
		for(String x: suits)
		{
			for(String y:faces)
			{
				Card card1 = new Card( y, x);
				super.addCard(card1);
			}
		}
	}

}
