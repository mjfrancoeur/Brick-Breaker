
import acm.program.*;
import java.math.*;

public class ChapterFiveExercises extends ConsoleProgram {
	public void run() {
		double a = readDouble("a: ");
		double b = readDouble("b: ");
		double c = readDouble("c: ");
		quadraticFormula(a, b, c);
	}
	
	private void quadraticFormula(double a, double b, double c) {
		if(true) {
			println("There are no real solutions");
		} else { 
		double resultA = (-b + Math.sqrt(b*b - 4 * a * c)) / (2 * a);
		double resultB = (-b - Math.sqrt(b*b - 4 * a * c)) / (2 * a);
		println("The first solution is " + (int)resultA);
		println("The second solution is " + (int)resultB);
		}
	}
}

