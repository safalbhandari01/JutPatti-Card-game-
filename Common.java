//*******************************
//* Name: Safal Bhandari
//* Project: Jutpatti
//* Date:10/21/2018
//*******************************

package CardGame;

import java.util.*;

public class Common {
	
	//Array list to hold the cards of each player 
	private ArrayList<Card> common = new ArrayList<Card>(); 
	
	
	// ****************************************************************
	// Function Name: print()
	// Purpose: prints the cards on the hand of the player
	// Parameters: none
	// Return value: none
	// Assistance Received: none
	// ****************************************************************
	public void print() {
		for(int i = 0; i<common.size();i++) {
			if(i==common.size()-1) {
				System.out.print( common.get(i).faceSuit() + ".");
			}
			else
			{
			System.out.print( common.get(i).faceSuit() + ", ");	
			}
		}
			System.out.print("\n" + "\n");
			
	}
	
	
	// ****************************************************************
	// Function Name: addCard
	// Purpose: to add card on the hand of the player
	// Parameters: none
	// Return value: none
	// Assistance Received: none
	// ****************************************************************
	public void addCard(Card e) {
		common.add(e);
		
	}
	
	
	// ****************************************************************
	// Function Name: addAtBeginning(argument 1, argument 2)
	// Purpose: to add card at the beginning on the hand of the player
	// Parameters: integer index, Card element
	// Return value: none
	// Assistance Received: none
	// ****************************************************************
	public void addAtBeginning(int index, Card e) {
		common.add(index, e);
	}
	
	
	// ****************************************************************
	// Function Name:getSize 
	// Purpose: return the size of the cards on player's hand
	// Parameters: none
	// Return value: size of the cards on player's hand	
	// Assistance Received: none
	// ****************************************************************
	public int getSize() {
		return common.size();
	}

	
	// ****************************************************************
	// Function Name: elementAt(arg1)
	// Purpose:returns card element at i position from the players hand
	// Parameters: integer index i
	// Return value: Card element at i position
	// Assistance Received: none
	// ****************************************************************
	public Card elementAt(int i) {
		return common.get(i);
	}

	
	// ****************************************************************
	// Function Name: popElementAt(arg1)
	// Purpose: return the element at i and removes it from the player hand
	// Parameters: integer index i 
	// Return value: Card element at i position
	// Assistance Received: none
	// ****************************************************************
	public Card popElementAt(int i) {
		Card element = common.get(i);
		common.remove(i);
		
		return element;
	}
	

	// ****************************************************************
	// Function Name: shuffleArrayList()
	// Purpose: shuffles the deck of 52 cards
	// Parameters: none
	// Return value: none
	// Assistance Received: none
	// ****************************************************************
	public void shuffleArrayList()								
	{
		Collections.shuffle(common);		
	}

	
}
