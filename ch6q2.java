
import acm.program.*;
import acm.util.*;

/** This class runs a program in which you can "flip" a coin, returning heads or tails. Once the program returns heads three times in a row
 * it will return number of flips that it took to get to that point
 * @author Michael
 *
 */

public class ch6q2 extends ConsoleProgram{
	public void run() {
		int count = 0;
		int state = 0;
		while(state < 3) {	
			String flip = coinFlip();
			println(flip);
			count++;
			if(flip.equals("Heads")) {
				state++;
			}
			else {
				state = 0;
			}
		}
		println("It took " + count + " flips to get 3 consecutive heads.");
	}	
	
	private String coinFlip() {
		String headsOrTails = rgen.nextBoolean() ? "Heads" : "Tails";
		return headsOrTails;
	}
	
	RandomGenerator rgen = new RandomGenerator();
}
