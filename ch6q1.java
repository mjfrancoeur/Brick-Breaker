
import acm.program.*;
import acm.util.*;

public class ch6q1 extends ConsoleProgram{
	public void run() {
		rGen.setSeed(1);
		int x = 0;
		int y = 0;
		println("This program randomly selects a card.");
		while(true) {
			if(readInt("Enter a one to go :") == 1){
				x = rGen.nextInt(0, 12);
				println(x);
				y = rGen.nextInt(0, 3);
				println(y);
				suit = randomSuit(y);
				rank = randomRank(x);
			println(rank + " of " + suit);
			} else {
				break;
			}
		}
		}
	
	
	private String randomSuit(int a) {
		switch(a) {
		case 0: return(suit = "Clubs");
			
		case 1: return(suit = "Diamonds");
			
		case 2: return(suit = "Hearts");
			
		case 3: return(suit = "Spades");
		
		default: return null;
		
		}
	}
	
	private String randomRank(int b) {
		switch(b) {
		case 0: rank = "Ace";
		break;
		case 1: rank = "2";
		break;
		case 2: rank = "3";
		break;
		case 3: rank = "4";
		break;
		case 4: rank = "5";
		break;
		case 5: rank = "6";
		break;
		case 6: rank = "7";
		break;
		case 7: rank = "8";
		break;
		case 8: rank = "9";
		break;
		case 9: rank = "10";
		break;
		case 10: rank = "Jack";
		break;
		case 11: rank = "Queen";
		break;
		case 12: rank = "King";
		break;
		}
		return rank;
	}
	
	private RandomGenerator rGen = new RandomGenerator();
	private String rank;
	private String suit;
}
