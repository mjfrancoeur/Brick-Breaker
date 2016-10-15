import acm.program.*;
import acm.graphics.*;

public class ch5ex4 extends GraphicsProgram {

	static final double PI = 3.14;
	static final int RECT_WIDTH = 100;
	static final int RECT_HEIGHT = 10;
	
	public void run() {
		makeTable(4);
	}	
	private int raiseIntToPower(int n, int k) {
		int total = (int)Math.pow(n, k);
		return total;
	}
	
	private void myRun() {
		for(int i = 0; i <= 10; i++) {
			println(raiseIntToPower(2, i));
		}
	}
	
	private double raiseRealToPower(double x, int k) {
		if(k >= 0) {
			double result = Math.pow(x, k);
			return result;
		} else {
			double result = (1.0 / Math.pow(x, k));
			return result;
		} 
	}
	
	private void makeTable(int x) {
		for(int i = 0; i < x; i++) {
			int xc = 0;
			int yc = RECT_HEIGHT * i;
			add(new GRect(xc, yc, RECT_WIDTH, RECT_HEIGHT));
			println(raiseRealToPower(PI, 4));
			
		}		
	}
	
	private void questionSix() {
		println("This program gives you the number of digits of the integer that you have input");
		int n = readInt("Enter an integer: ");
		println(nDigits(n));
	}
		
		
		private int nDigits(int n) {
			int digitSum = 0;
			while(n > 0) {
				n /= 10;
				digitSum++;
			}
			return(digitSum);
			
	}
	
}