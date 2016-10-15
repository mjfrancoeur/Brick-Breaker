
import acm.program.*;
import acm.util.*;
import java.math.*;

public class ch6q3 extends ConsoleProgram {
	public void run() {
		int x = 0;
		int y = 0;
		int hit = 0;
		int miss  = 0;
		for(int i = 0; i <= 10000; i++) {
			x = rgen.nextInt(-1, 1);
			y = rgen.nextInt(-1, 1);
			if(x*x + y*y < 1) {
				hit++;
			} else {
				miss++;
			}
		}
		double pi = ((double)hit / miss) * 4;
		println(pi);
		println(hit);
		println(miss);
		
	}
	
	RandomGenerator rgen = new RandomGenerator();
	
}
