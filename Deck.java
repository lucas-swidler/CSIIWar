/*Name: Lucas Swidler
 * Date: October 8, 2020
 * Description: Contains the deck constructor and related methods for use in the game War
 * Sources Cited: Slides from Week 5, video lecture from September 29, and PDF with assignment details
 */
package cardGame;

import java.util.Random;

public class Deck {
	private Card[] deck = new Card[52];
	private int top = 0;
	
	public Deck() {
		int count = 0;						//used to count how many cards have been inputed
		char listSuit;						//used to input the suit
		for (int i = 2; i <= 14; i++) {		//goes through each rank
			for (int j = 1; j <= 4; j++) {	//goes through each suit
				if (j == 1) {
					listSuit = 'H';						
					deck[count] = new Card(i, listSuit);	//sets heart cards
				} else if (j == 2) {
					listSuit = 'C';
					deck[count] = new Card(i, listSuit);	//sets club cards
				} else if (j == 3) {
					listSuit = 'S';
					deck[count] = new Card(i, listSuit);	//sets spade cards
				} else {	
					listSuit = 'D';
					deck[count] = new Card(i, listSuit);	//sets diamond cards
				}	
				count++;					//makes sure that it runs enough for 52 cards
			}
		} // end of for loops
		
	} // end of Deck constructor
	
	public void shuffle() {
		Random toFiftyTwo = new Random();
		int randPlacement;							//Using a variable here isn't necessary, but it helps me think about it
		for (int i = 0; i < 51; i++) {
			randPlacement = toFiftyTwo.nextInt(52);	//Gets the next random integer
			swap(i, randPlacement);					//Swaps each card with a random one selected from the 52 available
			
		}
	}
	
	public Card draw() {
		Card topCard;
		if (deck[top] == null) {
			while (deck[top] == null) {
				top++;
			}
		} 	
		topCard = deck[top];					//Makes a copy of the card information - that way, i can set the cards to null so that
		deck[top] = null;						//the program actually goes through the whole deck instead of using the first 2 forever
		return topCard;
	}
	
	public boolean isEmpty() {
		for (int i = 0; i < 51; i++) {
			if (deck[i] != null) {		//if any cards are in the deck, return false
				return false;
			}
		}
		return true;					//if it reaches here, then no cards exist so it must be empty
	}
	
	private void swap(int i, int j) {	//Swaps the cards at indexes i and j in Deck
		Card temp;
		temp = deck[i];
		deck[i] = deck[j];
		deck[j] = temp;
	}
	
}