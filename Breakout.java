/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

/** Initial X location of brick rows */
	private static final double X_BRICK_START = (APPLICATION_WIDTH - (BRICK_WIDTH * NBRICKS_PER_ROW + BRICK_SEP * (NBRICKS_PER_ROW - 1))) / 2.0;
	
/** Initial X and Y location of the paddle */
	private static final int X_PADDLE_START = 0;
	private static final int Y_PADDLE_START = APPLICATION_HEIGHT - PADDLE_Y_OFFSET;

/** Initial X and Y location of the ball */
	private static final int X_BALL_START = (APPLICATION_WIDTH - BALL_RADIUS * 2) / 2;
	private static final int Y_BALL_START = (APPLICATION_HEIGHT - BALL_RADIUS*2) / 2;
	
/** Initial X and Y velocity for ball */
	private double vx;
	private double vy;
	
 /** Animation delay or pause time between ball moves */
	 private static final int DELAY = 20; 

/** initalizes paddle and ball*/
	private GRect paddle;
	private GOval ball;
	
/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		gameSetup();
		gameStart();
	}
	
	// Draws and sets all game elements on the canvas
	private void gameSetup() {
		brickSetup();
		paddleSetup();
		ballSetup();
	}
	
	private void gameStart() {
		ballMove();
		pause(DELAY);
	}
	
	
	/** creates NBRICK_ROWS of GRects (bricks), with a space of BRICK_SEP between bricks */
	private void brickSetup() {
		for(int i = 0; i < NBRICK_ROWS; i++) {
			double y = BRICK_Y_OFFSET + i * (BRICK_HEIGHT + BRICK_SEP);
				for(int j = 0; j < NBRICKS_PER_ROW; j++) {
					double x = X_BRICK_START + j * (BRICK_WIDTH + BRICK_SEP);
					brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
					brick.setFilled(true);
					brick.setColor(setBrickColor(i));
					add(brick);
				}
		}
	}
	
	/**
	 * @param x use the row number as the parameter
	 * @return the color for the brick
	 */
	private Color setBrickColor(int x) {
		switch(x) {
		case 0:
		case 1: return Color.RED;		
		case 2:
		case 3: return Color.ORANGE;		
		case 4:
		case 5: return Color.YELLOW;		
		case 6:
		case 7: return Color.GREEN;		
		case 8:
		case 9: return Color.CYAN;		
		default: return Color.BLACK;
		}
	}
	
	private void paddleSetup() {
		paddle = new GRect(X_PADDLE_START, Y_PADDLE_START, PADDLE_WIDTH, PADDLE_HEIGHT); 
		add(paddle);
		addMouseListeners();
	}
	
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		if(mouseX < 0) {
			mouseX = 0;
		} else if (mouseX > (APPLICATION_WIDTH - PADDLE_WIDTH)) {
			mouseX = (APPLICATION_WIDTH - PADDLE_WIDTH);
		}
		paddle.setLocation(mouseX, Y_PADDLE_START);
		
	}

	private void ballSetup() {
		ball = new GOval(X_BALL_START, Y_BALL_START, BALL_RADIUS * 2, BALL_RADIUS * 2);
		ball.setFilled(true);
		ball.setColor(Color.BLACK);
		add(ball);
		}
	
	private void ballMove() {
		vx = setVX();
		vy = 3.0;
		while(true) {
			ball.move(vx, vy);
			pause(DELAY);
			checkForFloor();
			checkForCeiling();
			checkForObjects();
			checkForWalls();
		}
	}
	
	private double setVX() {
		vx = rgen.nextDouble(1.0, 3.0);
		if (rgen.nextBoolean(0.5)) {
			vx = -vx;
		}
		return vx;
	}
	
	// Checks if ball is colliding with the paddle or a brick
	private void checkForObjects() {
		GObject collObject = getObject();
		if(collObject == paddle) {
			// Checks to see if ball is inside the play-area
			if (ballInPlay()) {
				vy = -vy;
			} 
		} 
		// if collObject is not equal to paddle or null, it is a brick object
		else if (collObject != null) {
			remove(collObject);
			vy = -vy;
		}
	}
	
	// Checks to see if ball remains in play (is above the paddle)
	private boolean ballInPlay() {
		if (ball.getY() + BALL_RADIUS * 2 < (APPLICATION_HEIGHT - PADDLE_Y_OFFSET + PADDLE_HEIGHT)) { 
			return true; 
		}
		return false;
	}
	
	// If the ball is touching another object, will return that object. Otherwise, returns null.
	private GObject getObject() {
	
		if ((getElementAt(ball.getX(), ball.getY())) != null) {
	        return getElementAt(ball.getX(), ball.getY());
	    } else if (getElementAt(ball.getX(), ball.getY() + BALL_RADIUS * 2) != null) {
	        return getElementAt(ball.getX(), ball.getY() + BALL_RADIUS * 2);
	    } else if (getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY()) != null) {
	    	return getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY());
	    } else if (getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY() + BALL_RADIUS * 2) != null) {
	    	return getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY() + BALL_RADIUS * 2);
		} 
		return null;
	}
	
	private void checkForFloor() {
		/* IF BALL GOES BELOW WINDOW */
		if(ball.getY() > APPLICATION_HEIGHT) {
			turnsCounter++;
			// Resets ball to starting location
			if (turnsCounter < NTURNS) {
				ball.setLocation(X_BALL_START, Y_BALL_START);
				ball.move(setVX(), vy);
			} else {
				GLabel gameOver = new GLabel("GAME OVER");
				add(gameOver, (APPLICATION_WIDTH - gameOver.getWidth()) / 2, (APPLICATION_HEIGHT - gameOver.getAscent()) / 2.0); 
			}
		}
	}
		
	private void checkForCeiling() {
		/* IF BALL HITS CEILING */
		if(ball.getY() <= 0) {
			vy = -vy;
		}
	}
	
	private void checkForWalls() {
		/* IF BALL HITS WALLS */
		if (ball.getX() <= 0) {
			vx = -vx;
		} else if (ball.getX() >= (APPLICATION_WIDTH - (BALL_RADIUS * 2.0))) {
			vx = -vx;
		}
	}
	
	/** initializes an instance of the RandomGenerator */
	RandomGenerator rgen = new RandomGenerator();
	
	/** initializes the variable for the X-Coordinate of the mouse */
	private double mouseX;
	private double ballX;
	private double ballY;
	private double turnsCounter = 0;
	private GObject gobj;
	private GPoint last;
	private GRect brick;
}
	
	
