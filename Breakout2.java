import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout2 extends GraphicsProgram{
	public void run() {
		gameSetup();
	
		gameChange();
	}
	
	private void gameSetup() {
		ball = new GOval(0,0, 20, 20);
		add(ball);
		gameStart();
	}
	
	private void gameStart() {	
		while(ball.getX() < getWidth()) {
			vx = 2.0;
			vy = 0.0;
			ball.move(vx, vy);
			pause(10);
			if(ball.getX() > getWidth() / 2) {
				vy = 1.0;
				ball.move(vx, vy);
			}
			}
	}
	
	private void gameChange() {
		while(ball.getX() > getWidth() / 2) {
				vy = 1.0;
				ball.move(vx, vy);
		}
	}
	
	private GOval ball;
	private double vx;
	double vy;
}
