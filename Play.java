//*******************************
//* Name: Safal Bhandari
//* Project: Jutpatti
//* Date:10/21/2018
//*******************************

package CardGame;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Play {
	
	//Creating an object of Scanner to take input from the user
	Scanner input = new Scanner(System.in);	
	
	//An array of Player object to store the n number of players 
	Player[] arr = new Player[5];
	
	// ****************************************************************
	// Function Name: Play()
	// Purpose: Serves as a default constructor for the class.
	// Purpose: Starts the Game
	// Parameters: none
	// Return value: none
	// Assistance Received: none
	// ****************************************************************
	Play()
	{	
		startGame();
	}
	
	
	// ****************************************************************
	// Function Name: startGame()
	// Purpose: Holds the logic part of the game
	// Parameters: none
	// Return value: none
	// Assistance Received: none
	// ****************************************************************
	public void startGame()
	{
		//Welcome Message
		System.out.println("Welcome to JutPatti ");
		//takes input on how many players are playing the game
		System.out.println("How many Players (1, 2, 0r 3)?");
		int numPlayers = input.nextInt();
		
		
		
		//takes an input on how many cards to deal for each player before starting the game
		System.out.println("How many cards do you wanna deal at first per player (5 or 7)?");
		int numCards = input.nextInt();
		
		//skip the next line to take string input next time the scanner object is used
		input.nextLine();
		
		//Creating a deal object which creates a deck of 52 cards
		Deal dealObject = new Deal(numPlayers, numCards);
		
		//For Loop
		//Takes name of the user as a parameter to create a Player Object.
		//Player Object stores name as the member variable, extends Common Class,
		//and holds all the display statements required in the game.
		//Calls cardsForHand function from deal class which deals numCards to each player(numPlayers)
		//Stores playerObject(Each Player in the game in the array of Player Object )
		int playerCount = 1;
		for(int i=0; i<numPlayers; i++) 
		{
			System.out.print(playerCount + "st Player,");
			String name = getUserName();
			Player playerObject = new Player(name);
			dealObject.cardsForHand(playerObject, name);
			arr[i] = playerObject;
			playerCount++;
			
		} //end of for loop
		
		
		//countDeck holds the size of the deck after distributing the first hands to the players
		int countDeck = dealObject.deckObject.getSize();
		
		//this variable stores the result if the player has won the game or not
		String checkResult = null;
		
		
		//FIRST PLAY OF THE GAME STARTS********************************************************************
		//Dealing first card from the deck to the first player and adding it to the arrayList of the player
		
		Card element = dealObject.deckObject.popElementAt(0);
		arr[0].addCard(element);
		
		System.out.println("GAME BEGINS"+ "\n");
		
		System.out.println("This is " + arr[0].getname() + "'s turn to play");
		System.out.println(arr[0].getname() + ", A card was just added to your hand from the deck");
		System.out.println("After adding, Cards on hand are ");
		arr[0].print();
		
		//Check if the player won the game
		checkResult = checkPairs(arr[0]);
		if(checkResult.equals("win"))
		{
			arr[0].win();
			System.exit(0);
			
		}	//end of if statement
	
		//holds the card index that the user wants to throw
		//Prompts user to throw a card and asks which index user wants to throws
		int index;	
		do
		{
			arr[0].throwCard();
			index = input.nextInt();
		}while(!(index>=0&& index<arr[0].getSize())); //end of do while loop
		
		//holds the card that the player threw after taking the card from the deck
		Card cardOnTable; 
     	//Storing the CARD on TABLE in as a card object
		cardOnTable = arr[0].elementAt(index);
		//holds the faceSuit of card on a string variable for later displaying purposes
		String cardOnTableFaceSuit = (String)arr[0].elementAt(index).faceSuit(); 
		//remove the element from the player hand that user wants to throw
		arr[0].popElementAt(index); 
				
		//FIRST PLAY OF THE GAME ENDS*************************************************************************************
		
		
		//SECOND PLAYER'S TURN AND EVERY TURN AFTER THAT HANDLED BY THE WHILE LOOP****************************************

		//Variable to change the turn of the players
		int i = 0; 
		
		//Creating a playerObject for COMPUTER PLAYER if the game is played between a SINGLE PLAYER and COMPUTER
		Player playerObject = new Player("Computer");	
		//For dealing a hand of card for computer player just once inside while loop
		boolean computer = true;
		
		while(!(checkResult.equals("win")))
		{
			//While Game is between Computer and Single Player
			if(numPlayers == 1)
			{	
				//Computer Player turn STARTS-----------------------------------------------------------------------------
				System.out.println("The card thrown by " + arr[numPlayers-1].getname() + " is: " + cardOnTableFaceSuit);
				//Printing Computers hand
				if(computer == true)
				{
				//Dealing Cards on Hand for Computer Player before beginning Computer's turn
				dealObject.cardsForHand(playerObject, "Computer Player");	
				}
				computer = false;
				
				System.out.println("\n");
				System.out.println("Computer's Turn");

				//Calling computer's turn function that processes the computer's turn
				//and returns the card to be thrown on the table
				cardOnTable = computerTurn( playerObject, dealObject, cardOnTable, numCards);
				
				//holds the faceSuit of card on a string variable for later displaying purposes
				cardOnTableFaceSuit = (String)playerObject.elementAt(playerObject.getSize()-1).faceSuit(); 
				
				//remove the last element from the computer's hand and printing computer's hand
				playerObject.popElementAt(playerObject.getSize()-1); 
				
				//Computer Player turn ENDS---------------------------------------------------------------------------
			}
			
			//While Game is Multiplayer, Next Player's turn STARTS*****************************************************
			//IF Game is between Computer & Single Player, next turn of Single Player STARTS***************************
			i++;										//Incrementing I to Change the player's turn						
			int nextPlayer = i%numPlayers;				//nextPlayer contains the index of next player to play
			String deckOrTable;							//String To get input from user on picking card from deck or table
			
			if(nextPlayer == 0) {
				String name = (i%2 != 0)? playerObject.getname()/*Computer*/: arr[numPlayers-1].getname()/*Player*/;
				System.out.println("The card thrown by " + name + " is: " + cardOnTableFaceSuit);	
			}
			else
			{
				System.out.println("The card thrown by " + arr[nextPlayer-1].getname() + " is: " + cardOnTableFaceSuit);
			}
				
				//Points the turn to next player and prints card on hand
				System.out.println("\n");
				System.out.println("This is " + arr[nextPlayer].getname() +"'s turn to play!");
				System.out.println(arr[nextPlayer].getname() + ", Cards on Hand are:");
				arr[nextPlayer].print();	
				
				//Taking input on where the player wants to get the next card from: Deck or Table?
				arr[nextPlayer].cardFromDeckORTable();
				deckOrTable = input.next();
				
				//changing input to lower case for later comparison
				deckOrTable = deckOrTable.toLowerCase();
				
				//Getting card from deck or table and adding it to player's hand
				if(deckOrTable.equals("deck"))
				{	
					element = dealObject.deckObject.popElementAt(0);
					arr[nextPlayer].addCard(element);	
				}
				else
				{
					arr[nextPlayer].addCard(cardOnTable);
					
				}
				
				//Checking if there are a pair of each card on player's hand or not
				//If the player has a pair foreach card on his hand, Game is won
				checkResult = checkPairs(arr[nextPlayer]);										
				System.out.println(arr[nextPlayer].getname()+", After picking, Cards on hand are:");
				arr[nextPlayer].print();
				
				//Checking if the player won the game or not
				if(checkResult.equals("win"))
					{
					arr[nextPlayer].win();
						System.exit(0);
					}		
				
				//Prompting user to throw a card and asks which index user wants to throws
				do
				{
					arr[nextPlayer].throwCard();
					index = input.nextInt();
				}while(!(index>=0 && index<arr[nextPlayer].getSize()));
				
				
				//Printing the element that the player is removing
				//System.out.println("The card that" + arr[nextPlayer].getname() + " is removing is" + arr[nextPlayer].elementAt(index).faceSuit());

				//Storing the CARD on TABLE in cardOnTable variable
				cardOnTable = arr[nextPlayer].elementAt(index);  
				//holding the faceSuit of card on a string variable for later displaying purposes
				cardOnTableFaceSuit = (String)arr[nextPlayer].elementAt(index).faceSuit();
				//Removing the element from the Player's hand 
				arr[nextPlayer].popElementAt(index);	
				
		}//end of while loop
		 //SECOND PLAYER'S TURN AND EVERY TURN AFTER THAT ENDS**************************************************************
		
	}	 //end of start game
	
	
	// ****************************************************************
	// Function Name: getUserName()
	// Purpose: get the name of the player
	// Parameters: none
	// Return value: name of the player
	// Assistance Received: none
	// ****************************************************************
	public String getUserName()
	{
		System.out.println("Please enter your name");
		String name = input.nextLine();
			
		return name;
	}
		
	// ****************************************************************
	// Function Name: computerTurn(argument1,argument2,argument3,argument4)
	// Purpose: add card on computer's hand from Deck or Table
	// and return the card that is thrown by computer as a Card variable
	// Parameters: playerObject, dealObject, cardOnTable, numberofcards
	// Return value: Card datatype, Card that is thrown on table
	// Assistance Received: none
	// ************************************************************
	public Card computerTurn(Player playerObject, Deal dealObject, Card cardOnTable, int numCards) 
	{	
		//Variable to store the result
		String checkResult;
		
		//Checks if there is a matching pair on computer's hand with the card on table and adds if there exists one
		for(int i =0; i<playerObject.getSize();i++) 
		{
			if(playerObject.elementAt(i).getFace()==cardOnTable.getFace()) {
				playerObject.addCard(cardOnTable);
				break;
			}
		}
		if(playerObject.getSize()%2 == 1) {									//Means has not picked from the table
			playerObject.addCard(dealObject.deckObject.popElementAt(0));	//Picking a card from deck
		}
		
		//Compare the elements in the computer array and store the one to be thrown in the last index
		checkResult = checkPairsComputer(playerObject,numCards);
		
		if(checkResult.equals("win"))
		{
		playerObject.win();
			System.exit(0);
		}
		
		//Storing the CARD on TABLE in cardOnTable
		cardOnTable = playerObject.elementAt(playerObject.getSize()-1); 	
		
		return cardOnTable;
	}
	
	
	
	// ****************************************************************
	// Function Name: checkPairs()
	// Purpose: Checks if all the cards on player's hand has a pair or not
	// Parameters: playerObject
	// Return value: String that holds a value GAME WON OR PROCEED GAME
	// Assistance Received: none
	// ****************************************************************
	public  String checkPairs(Player playerObject) 
	{	
		//Creating a localVector to hold the face value of cards of the playerObject
		Vector localVector = new Vector();
		String checkResult; 
		
		for(int i=0; i<playerObject.getSize();i++) {
			String local = (String)playerObject.elementAt(i).getFace();	
			localVector.add(local);	
		}
		//Sorting the vector in ascending order for checking the pair purpose
		Collections.sort(localVector);

		//Checking if the cards are in pair or not for Multi player Case*************
		int counter = 0; //holds the count of pair
		for(int i = 0; i<localVector.size(); i++) {
			if(localVector.get(i)==localVector.get(i+1))
			{
				counter++;
			}
			i++;
		}
		//***************************************************************************
		
		//If all element on the hand are in pair then counter value is half of the vector size
		//If counter value is half, the player has won the game
		if(counter == (localVector.size()/2))
		{
			checkResult = "win";
			return checkResult;
		}
		else
		{
			checkResult = "proceed game";
			return checkResult;
		}
		
	}
	
	
	// ****************************************************************
	// Function Name: checkPairsComputer()
	// Purpose: Checks if all the cards on computer's hand has a pair or not
	// Parameters: playerObject, numCards
	// Return value: String that holds a value GAME WON OR PROCEED GAME
	// Assistance Received: none
	// ****************************************************************
	public String checkPairsComputer(Player playerObject, int numCards)
	{
		//Creating a localVector to hold the face value of cards of the playerObject
		Vector localVector = new Vector();
		
		//Holds the string variable to be returned
		String checkResult; 
		
		//adding the face value of the hand on the vector 
		for(int i=0; i<playerObject.getSize();i++) {
			String local = (String)playerObject.elementAt(i).getFace();	
			localVector.add(local);	
		}
		
		int count = 0, winCount =0;
		for(int i=0; i<playerObject.getSize(); i++) 
		{
			for(int j = 0; j<playerObject.getSize();j++) 
			{
				if(localVector.get(i)==localVector.get(j)) 
				{
					count++;
					if(count ==2)
					{
						winCount++;
					}
				}
			}
			if(count !=2)
			{
				Card element = playerObject.popElementAt(i);
				playerObject.addCard(element);
				break;
			}
			count = 0;
		}
		//Printing the computer's hand after adding card that does not have a pair
		// or has more than 2 cards with same face to the end of the hand 
		//The last card on hand is later thrown by the computer
		System.out.println("After adding, Card's on Computer's hand are:");
		playerObject.print();
		
		
		//returning checkResult
		if(winCount == numCards+1) 
		{
			checkResult = "win";
			return checkResult;
		}
		else
		{
			checkResult = "Proceed Game";
			return checkResult;
		}
	}
	
}
