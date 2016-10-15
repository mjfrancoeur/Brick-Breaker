
import acm.program.*;
import acm.util.*;

/**
 * when called, it will generate a random card
 * @result rank the rank of the card (Ace through King) 
 * @result suit The suit of the card, a string
 * @author Michael
 *
 */

public class Card extends ConsoleProgram{

	public Card() {
		rank = randomRank();
		suit = randomSuit();	
	}

	/**
	 * Returns the current state of the rank of the card.
	 * @return the rank of the Card (Ace through King)
	 */
	
	public int getRank() {
		return rank;
	}
	
	
	
	public String getSuit() {
		return suit;
	}
	
	private int randomRank() {
		int a = rgen.nextInt(0,13);
		return a;
	}
	
	private String randomSuit() {
	int a = rgen.nextInt(0,3);
	switch(a) {
	case 0: return CLUBS;
	case 1: return DIAMONDS;
	case 2: return SPADES;
	case 3: return HEARTS;
	}
	}
	
	
	private int rank;
	private String suit;
	RandomGenerator rgen = RandomGenerator();
	
	/* private constants
	 * 
	 */
	
	private static final String CLUBS = "Clubs";
	private static final String DIAMONDS = "Diamonds";
	private static final String SPADES = "Spades";
	private static final String HEARTS = "Hearts";
	private static final int ACE = 1;
	private static final int JACK = 11;
	private static final int QUEEN = 12;
	private static final int KING = 13;
}
