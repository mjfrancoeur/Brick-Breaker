
import acm.program.*;
import java.math.*;

public class isPrime extends ConsoleProgram{
	public void run() {
		println(isPrimeOne(91));
	}
	
	private boolean isPrimeOne(int n) {
		boolean isItPrime = false;
		for(int i = n-1; i > 0; i--) {
			int answer = n % i;
			if(i == 1) {
				isItPrime = true;
				break;
			} else if(answer == 0) {
				isItPrime = false;
				break;
			}
			
			 
		}
		return(isItPrime);
	}
}
