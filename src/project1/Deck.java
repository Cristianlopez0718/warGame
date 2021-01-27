package project1;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Deck will will use the card class to create a deck
 * It will be use in the Hand class to create cpu and user hand
 * @author Cristian Lopez
 */
public class Deck {
	ArrayList<Card> DeckOfCards = new ArrayList<Card>();
	/**
	 * Default constructor creates a deck of 52 cards
	 * it adds suit and values to the cards
	 */
	public Deck(){
		
		for(int i = 0; i <= 3; i++) { //Iterate over all the suits in a deck of cards
			
			for (int x = 1; x <= 13; x++) { //Iterate over the values in a deck of cards
				Card card = new Card();
				card.value = x;
				switch (i) {
					case 0: 
						card.suit = "Harts";
						break;
					case 1: 
						card.suit = "Diamonds";
						break;
					case 2:
						card.suit = "Spades";
						break;	
					case 3:
						card.suit = "Clubs";
						break;
					default: 
						card.suit = "Error";
						break;
				}
				
				DeckOfCards.add(card);
				
			}
		}
	Collections.shuffle(DeckOfCards); //shuffles the deck of cards
	}
	/**
	 * printdeck prints the cards made by the constructor to the user
	 */
	public void printdeck() {
		
		for(int i =0; i <DeckOfCards.size() ; i++) {
			System.out.println(DeckOfCards.get(i));
		}
	}
	public Card getCard(int card) {
		Card removedCard = DeckOfCards.get(card); //temp value to get returned later
		DeckOfCards.remove(card);
		return removedCard;
	}
	
	public String toString() {
		return "Deck [DeckOfCards=" + DeckOfCards + "]";
	}
	
}
