
import acm.program.*;

public class ch5q6 extends ConsoleProgram {
	public void run() {
		println(askYesNoQuestion());
		
		
		/*println("This program gives you the number of digits of the integer that you have input");
		String answer = readString("Enter an integer: ");
		println(isPerfectSquare(n)); */
	}
	
	private int nDigits(int n) {
		int dSum = 1;
		while(n > 9) {
			n /= 10;
			dSum++;
		}
		return(dSum);	
	}
	
	private boolean isPerfectSquare(int n) {
		int nSqrt = (int)Math.sqrt(n);
		return(nSqrt * nSqrt == n);
	}
	
	private boolean askYesNoQuestion() {
		while(true) {
			println("Would you go out with Stacey?");
			String s = readLine("Answer yes or no: ");
				if(s.equals("yes") || s.equals("no")) {
					break;
				} else {
					println("please answer with either a 'yes' or a 'no'");
				}	
		} return(true);
	}
}
