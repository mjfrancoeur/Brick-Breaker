
import acm.program.*;
import acm.util.*;

public class ch6q5 extends ConsoleProgram {
	public void run() {
		questionGenerator();
	}
	
	private void questionGenerator() {
		int x = 0;
		int y = 0;
		int answer = 0;
		int count = 0;
		String operator = "null";
		for(int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
				x = rgen.nextInt(0, 20);
				y = rgen.nextInt(0, 20);
				int a = rgen.nextInt(0,1); //picks a random int to determing subtraction or addition
				switch(a) {
				case 0:
					operator = " + ";
					answer = x + y;
						while(answer > 20) {
							x = rgen.nextInt(0, 20);
							y = rgen.nextInt(0, 20);						
						}
						answer = x + y;
					break;
				case 1:
					operator = " - ";
					answer = x - y;
						while(y > x) {
							x = rgen.nextInt(0, 20);
							y = rgen.nextInt(0, 20);
						}
						answer = x - y;
					break;
				}
				while(true) {
					int userAnswer = readInt("what is " + x + operator + y + " : ");
					if(userAnswer == answer) {
						println("That's the answer");
						break;
					} else {
						if(count < 3) {
						println("Try again!");
						count++;
						}	else if(count >= 3) {
							println("Nope. The answer was: " + answer + " On to the next question.");
							break;
						}
					}
				}
		}
	}
	
	private static final int NUMBER_OF_QUESTIONS = 5;
	RandomGenerator rgen = new RandomGenerator();
}
		
