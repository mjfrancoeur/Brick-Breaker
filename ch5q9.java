
import acm.graphics.*;
import acm.program.*;
import java.math.*;

public class ch5q9 extends GraphicsProgram {
	public void run() {
		myRun(8);
	}
	
	private int combinations(int n, int k) {
		return factorial(n) / (factorial(k) * factorial(n - k));
	}
	
	private GLabel createLabel(String str) {
		return(new GLabel(str));
	}
	
	private int factorial(int n) {
		int fSum = 1;
		for(int i = 1; i < n; i++) {
			fSum *= i;
		}
		return fSum;
	}

	private void myRun(int numRows) {
		int n = 0;
		int k = 0;
		double cx = 0;
		double cy = 0;
		for(int i = 0; i < numRows; i++) {
			n = 0;
				for(int j = 0; j <= n; j++) {
					int combo = combinations(n, k);
					String str = Integer.toString(combo);
					GLabel label = createLabel(str);
					cx += label.getWidth() * j;
					cy += label.getAscent() * i; 
					add(label, cx, cy);
					k++;
				}
			n++;
		}
	}
}