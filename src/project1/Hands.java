package project1;

import java.util.LinkedList;
import java.util.Queue; 
/**
 * Hands Class uses creates 2 queues of cards for the user and cpu hand
 * @author Cristian Lopez
 *
 */
public class Hands {
    private Queue<Card> HandCPU = new LinkedList<>(); 
    private Queue<Card> HandUSER = new LinkedList<>(); 
	private Deck deck = new Deck();
    public Hands() {
    }
					
	public void printCPUHand(){
		for(int i =0; i <HandCPU.size() ; i++) {
			System.out.println(HandCPU.peek());
		}
	}
	/**
	 * CreateUserHand creates a hand of 26 cards for the user, with suit and value.
	 */
	public void CreateUserHand() {
		
		for (int i = 1; i <= 26; i++) {
			HandUSER.add(deck.getCard(0));
		}
	}
	/**
	 * CreateCpuHand creates a hand of 26 cards for the user, with suit and value.
	 */
	public void CreateCpuHand() {
		
		for (int i = 1; i <= 26; i++) {
			HandCPU.add(deck.getCard(0));
		}
	}
	/**
	 * getCPUhand takes the class already created and returns to the user
	 * @return returns the hands to the main to be used
	 */
	public Queue<Card> getCPUhand() {
		
		return  HandCPU;
	}
	/**
	 * getUSERhand takes the class already created and returns to the user
	 * @return returns the hands to the main to be used
	 */
	public Queue<Card> getUSERhand() {
		
		return  HandUSER;
	}
	
}
