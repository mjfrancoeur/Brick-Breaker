
import acm.graphics.*;

import acm.program.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

public class sectionHandout7 extends GraphicsProgram {

	public void init() {
	
		contents = new HashMap<String, GObject>();
		
		nameField = new JTextField(15);
		nameField.addActionListener(this);
		
		add(new JLabel("Name"), SOUTH);
		add(nameField, SOUTH);
		add(new JButton("Add"), SOUTH);
		add(new JButton("Remove"), SOUTH);
		add(new JButton("Clear"), SOUTH);
		
		
			
		/* add action listeners */
		addActionListeners();
		addMouseListeners();
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("Clear")) {
			removeAll(); // Clears the screen
		} else if (cmd.equals("Remove")) {
			removeBox();
		} else if (cmd.equals("Add")) {
			addBox();
		}
	}
	
	public void mousePressed(MouseEvent e) {
		lastX = e.getX();
		lastY = e.getY();
		gobj = getElementAt(lastX, lastY);
	}
	
	public void mouseDragged(MouseEvent e) {
		if(gobj != null) {
			gobj.move(e.getX() - lastX, e.getY() - lastY);
			lastX = e.getX();
			lastY = e.getY();
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		if(gobj != null) {
			gobj.sendToFront();
		}
	}
	
	
	private void addBox() {
		
		compound = new GCompound();
		GRect box = new GRect(BOX_WIDTH, BOX_HEIGHT);
		
		GLabel label = new GLabel(nameField.getText());
		
		compound.add(box, 0,0); 
		compound.add(label, (BOX_WIDTH - label.getWidth()) / 2, (BOX_HEIGHT - label.getAscent()) / 2);
		add(compound, getWidth() / 2, getHeight()/ 2);
		contents.put(nameField.getText(), compound);
		
	}
	
	private void removeBox() {
		GObject obj = contents.get(nameField.getText());
		if(obj != null) {
			remove(obj);
		}
	}
	
	
	/* instance variables */
	JTextField nameField;
	
	private HashMap<String, GObject> contents;
	private GCompound compound;
	private GObject gobj; /* object being dragged */
	private double lastX; /* The last mouse X coordinate */
	private double lastY; /* The last mouse Y coordinate */
	
	
	
	/* Constants */
	private static final double BOX_WIDTH = 120;
	private static final double BOX_HEIGHT = 50;

	
}

