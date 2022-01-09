/*Name: Lucas Swidler
 * Date: October 8, 2020
 * Description: Utilizing the Card and Deck classes, runs a program that simulates the card game War. To use the program, the enter key
 * must be used to start the game and enter following rounds.
 * Sources Cited: Slides from Week 5, video lecture from September 29, and PDF with assignment details
 */
package cardGame;

import java.io.IOException;

public class War {

	public static void main(String[] args) {
		//Variable definitions - used for score and keeping track of what cards each player draws
			int userTotalCards = 0;	//used for scoring
			int compTotalCards = 0;	//used for scoring
			Card userDraw;			//used for rounds before a war
			Card compDraw;			//used for rounds before a war
			Card firstUserDraw; 	//used when a war occurs
			Card firstCompDraw;		//used when a war occurs
			Card secondUserDraw;	//used when a war occurs
			Card secondCompDraw;	//used when a war occurs
			
		//Has the user press enter before starting
			System.out.print("To start the game of War, press Enter!");
			promptEnterKey();
			
		//Shuffles the deck and lets the user know
			Deck d = new Deck();
			d.shuffle();
			System.out.println("The deck has been created and shuffled.\n");
		
		//Running the game
			while(d.isEmpty() == false) { //each iteration of this loop is one "round"
				
				//The round begins
				userDraw = d.draw();
				compDraw = d.draw();
				System.out.println("The user has drawn a "+userDraw.getRank()+" of "+userDraw.getSuit()+", while the computer has drawn a "
						+compDraw.getRank()+ " of "+compDraw.getSuit()+".");
				
				//Checks if the user wins the round
				if (userDraw.getRank() > compDraw.getRank()) {
					userTotalCards += 2;
					System.out.println("The user drew a card with a higher rank, so the user wins.");
					
				//Checks if the computer wins the round
				} else if (compDraw.getRank() > userDraw.getRank()) {
					compTotalCards += 2;
					System.out.println("The computer drew a card with a higher rank, so the computer wins.");
				} else {	
			//The game has entered a state of war - draws 2 cards for each player and then compares
					
					System.out.println("The ranks were equal, so a war has started!");
					firstUserDraw = d.draw();
					firstCompDraw = d.draw();
					
					//Checks if the user wins the war on round 1
					if (firstUserDraw.getRank() > firstCompDraw.getRank()) {				
						userTotalCards += 3;
						System.out.println("The user drew a "+firstUserDraw.getRank()+" of "+firstUserDraw.getSuit()+", and the computer drew a " 
								+firstCompDraw.getRank()+" of "+firstCompDraw.getSuit()+ ", so the user wins the war.");
					
					//Checks if the computer wins the war on round 1
					} else if (firstCompDraw.getRank() > firstUserDraw.getRank()) {			
						compTotalCards += 2;
						System.out.println("The User drew a "+firstUserDraw.getRank()+" of "+firstUserDraw.getSuit()+", and the Computer drew a " 
								+firstCompDraw.getRank()+" of "+firstCompDraw.getSuit()+ ", so the Computer wins the war.");
					} else {
			//The first round of extra cards were of equal rank, so now we must compare the second cards drawn
						
						System.out.println("The ranks were equal again, so the war continues!");
						secondUserDraw = d.draw();
						secondCompDraw = d.draw();
						
						//Checks if the user wins the war on round 2
						if (secondUserDraw.getRank() > secondCompDraw.getRank()) {			
							userTotalCards += 3;
							System.out.println("The User drew a "+secondUserDraw.getRank()+" of "+secondUserDraw.getSuit()+", and the Computer drew a " 
									+secondCompDraw.getRank()+" of "+secondCompDraw.getSuit()+ ", so the User wins the war.");
							
						//Checks if the computer wins the war on round 2	
						} else if (secondCompDraw.getRank() > secondUserDraw.getRank()) {	
							compTotalCards += 3;
							System.out.println("The User drew a "+secondUserDraw.getRank()+" of "+secondUserDraw.getSuit()+", and the Computer drew a " 
									+secondCompDraw.getRank()+" of "+secondCompDraw.getSuit()+ ", so the Computer wins the war.");
						} else {
			//Still no winner of the cards drawn, so the war ends in a draw. The next round begins after this
					
							System.out.println("The User drew a "+secondUserDraw.getRank()+" of "+secondUserDraw.getSuit()+", and the Computer drew a " 
									+secondCompDraw.getRank()+" of "+secondCompDraw.getSuit()+", so the war has ended in a draw. No player gets any cards.");
						}
					}
			}
			//Have the user start the next round
				System.out.println("To start the next round, hit Enter");
				promptEnterKey();
			//Sets used cards to null so that the game does not endlessly loop
				userDraw = null;
				compDraw = null;
				firstUserDraw = null;
				firstCompDraw = null;
				secondUserDraw = null;
				secondCompDraw = null;
	}
		//determines the winner once no more rounds are possible
		//This is outside the while loop so it only runs once, when no more rounds are possible!
			if (userTotalCards > compTotalCards) {
				System.out.println("The user wins! They obtained "+userTotalCards+" cards.");
			} else if (compTotalCards > userTotalCards) {
				System.out.println("The computer wins! They obtained "+compTotalCards+" cards.");
			} else {
				System.out.println("The game ends with a tie! They both obtained "+userTotalCards+" cards.");
			}
				
	}
	//found in the PDF of the assignment
	//this method definition has to be outside of the main method for it to work
	public static void promptEnterKey() {
		try {
			System.in.read(new byte[2]);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
