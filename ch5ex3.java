
import acm.program.*;

public class ch5ex3 extends ConsoleProgram {
	
	
	public void run() {
		int n = readInt("input an integer: ");
		fibonacci(n);
	}
	
	private void fibonacci(int x) {
		int a = 0;
		int b = 1;
		int fibNum = 0;
		if(x == 0) {
			fibNum = 0;
			println(fibNum);
		} else if(x == 1) {
			fibNum = 1;
			println(fibNum);
		} else {		
			for(int i = 2; i < x; i++) {
				fibNum = a + b;
				println(fibNum);
				b = fibNum;
				a = b; 
			}
		}
	}
	
}
