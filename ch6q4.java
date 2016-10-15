
import acm.program.*;
import acm.util.*;

public class ch6q4 extends ConsoleProgram {
	public void run() {
		halfLife(10000);
	}
	
	private void halfLife(int n) {
		int decay = 0;
		int year = 0;
		while (n > 0) {
			decay = 0;
			for(int i = 0; i <= n; i++) {
				boolean result = rgen.nextBoolean();
				if(result == true) {
					decay++;
				} 	
		}
			year++;
			n = n - decay;
			println(decay);
			println("There are " + n + " atoms left at the end of year " + year);	
	}
	}
	
	
	RandomGenerator rgen = new RandomGenerator();
}
