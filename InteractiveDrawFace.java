import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class InteractiveDrawFace extends GraphicsProgram {

  // init() method is called when program starts
  public void init() {

    // Button to clear display
    add(new JButton("Clear"), SOUTH);

    // Check box to display front or back of face
    checkbox = new JCheckBox("Front");
    checkbox.setSelected(true);
    add(checkbox, SOUTH);

    initRadioButtons();

    initColorChooser();

    // must call this function to be able to get mouse events
    addMouseListeners();

    // must call this method to get button press events
    addActionListeners();

  }

// called whenever an action event occurs
  public void actionPerformed(ActionEvent e) {
    if(e.getActionCommand().equals("Clear")) {
      removeAll(); // clears the canvas
    }
  }

  public void mouseClicked(MouseEvent e) {
    GObject obj;
    double diam = getDiamSize();
    if(checkbox.isSelected()) {
      obj = new GFace(diam, diam);
    } else {
      obj = new GOval(diam, diam);
    }
    obj.setColor(getCurrentColor());
    add(obj, e.getX(), e.getY());
  }

  private double getDiamSize() {
    double size = 0;
    if(smallRB.isSelected()) {
      size = SMALL_DIAM;
    } else if(medRB.isSelected()) {
      size = MED_DIAM;
    } else if (largeRB.isSelected()) {
      size = LARGE_DIAM;
    }
    return size;
  }

  private Color getCurrentColor() {
    String name = (String)pickColor.getSelectedItem();
    if(name.equals("Blue")) {
      return Color.BLUE;
    } else if(name.equals("Green")) {
      return Color.GREEN;
    } else if(name.equals("Red")) {
      return Color.RED;
    } else return Color.BLACK;
  }


  private void initRadioButtons() {
    //Radio button group for size
    ButtonGroup sizeBG = new ButtonGroup();
    smallRB = new JRadioButton("Small");
    medRB = new JRadioButton("Med");
    largeRB = new JRadioButton("Large");

    // add buttons to button group
    sizeBG.add(smallRB);
    sizeBG.add(medRB);
    sizeBG.add(largeRB);

    // set initial radio button selection
    medRB.setSelected(true);

    // add all radio buttons
    add(smallRB, SOUTH);
    add(medRB, SOUTH);
    add(largeRB, SOUTH);
  }

  private void initColorChooser() {
    // Create combo box with color options
    pickColor = new JComboBox();
    pickColor.addItem("Black");
    pickColor.addItem("Blue");
    pickColor.addItem("Green");
    pickColor.addItem("Red");

    // Don't allow user to type in a color
    pickColor.setEditable(false);

    // Set initial color selection
    pickColor.setSelectedItem("Black");

    // Create label
    add(new JLabel("    Color:"), SOUTH);
    // Add combo box
    add(pickColor, SOUTH);

  }

/* private constants */
private static final double SMALL_DIAM = 20;
private static final double MED_DIAM = 40;
private static final double LARGE_DIAM = 60;

/* private instance variables */
// ivars are used to keep track of interactors
// whose states you need to check as your program runs

private JCheckBox checkbox;
private JRadioButton smallRB;
private JRadioButton medRB;
private JRadioButton largeRB;
private JComboBox pickColor;

}

