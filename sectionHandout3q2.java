
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;

public class sectionHandout3q2 extends GraphicsProgram {
	
	private static final int NCIRCLES = 10;
	private static final int MIN_RADIUS = 5;
	private static final int MAX_RADIUS = 50;
	
	public void run() {
		for(int i = 0; i < NCIRCLES; i++) {
			double r = rgen.nextInt(MIN_RADIUS, MAX_RADIUS);
			double x = rgen.nextDouble(0, getWidth() - 2 * r);
			double y = rgen.nextDouble(0, getHeight() - 2 * r);
			Color color = rgen.nextColor();
			GOval circle = new GOval(x, y, r*2, r*2);
			circle.setFilled(true);
			circle.setFillColor(color);
			circle.setColor(color);
			add(circle);
		}
	}
	RandomGenerator rgen = new RandomGenerator();
	
}
