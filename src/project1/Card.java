package project1;
/**
 * creates cards to be used by the deck and tester
 * @author Cristian Lopez
 */
public class Card {
	String suit;
	int value;
	/**
	 * Default constructor creates a card with suit and value
	 */
	public Card(){
	}
	 
	/**
	 * @return returns the suit of the card
	 */
	public String getSuit() {
		return suit;
	}
	/**
	 * 
	 * @param suit modifies the suit of a card
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}
	/**
	 * 
	 * @return returns the value of a card
	 */
	public int getValue() {
		return value;
	}
	/**
	 * 
	 * @param value changes the value of a card
	 */
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * Card toSting method prints the value and suit of the card
	 */
	public String toString() {
		return (value + " of " + suit );
		
	}
	
}
