package gpa_calculator.gpa_gui;

//import statements
import javax.swing.JPanel;

import gpa_calculator.ButtonTapComponents.ButtonTabComponent;

import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

//Initialize class GPA_Gui

/** 
 * The GPA_Gui Class creates the main welcome frame of the application.
 * Displays the Student View frame.
 */
@SuppressWarnings("serial")
public class GPA_Gui extends JPanel {
	
	//Initialize frame
	private static JFrame frame;
	
	//Initialize tabbed frame
	//private static JTabbedPane tabbedPane;
	
	private static MainPanels_GPA_Gui tabbedPane;
	
	/** 
	 * The GPA_Gui Method places a tabbed pane onto the frame.
	 * Calls the methods initTabComponent(int i) and makeTextPanel(String text).
	 */
	public GPA_Gui() {
		
		//Define Layout of frame
		super(new GridLayout(1, 1));
		
		tabbedPane = new MainPanels_GPA_Gui();
		
		//For loop formatting each tab created and adding an exit button to each tab
		//For semester 1 thru 8
		for (int i = 0; i < 8; i++) {
			//Call initTabComponent to format tab
			initTabComponent(i);
		}
		
		// Add the tabbed pane to this panel.
		add(tabbedPane);
	}

	/** 
	 * The initTabComponent Method formats the tabs on the tabbed pane of Class GPA_Gui.
	 * Implements Class ButtonTabComponent.
	 */
	private static void initTabComponent(int i) {
		//Set tab component of specified tab to the ButtonTabComponent class
		tabbedPane.setTabComponentAt(i, new ButtonTabComponent(tabbedPane));
	}

	/** 
	 * The makeTextPanel Method adds the components that will be placed inside of each tab of the tabbed pane.
	 * The Panel is implements with BoxLayouts.
	 */
	protected static JComponent makeTextPanel(String text) {
		makeTextPanel_GPA_Gui makeTextPanel_GPA_Gui = new makeTextPanel_GPA_Gui(text);
		return makeTextPanel_GPA_Gui;
	}

	/** 
	 * The createAndShowGUI Method creates and adds the menubar, menus, and menuitems to be added to the frame.
	 * Adds event handlers to the menuitems.
	 */
	public static void createAndShowGUI() {
		// Create and set up the window.
		frame = new JFrame("GPA Calculator");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = frame.getContentPane();
		// adjust to need.
		Dimension d = new Dimension(1500, 800);
		c.setPreferredSize(d);
		// Add content to the window.
		frame.add(new GPA_Gui(), BorderLayout.NORTH);
		
		frame.setJMenuBar(new Menu_GPA_Gui());
		// Add Panel to Frame
		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	/** 
	 * The resize Method resizes images given an image and a desired width and a desired height.
	 */
	public static BufferedImage resize(BufferedImage img, int newW, int newH) {  
	    int w = img.getWidth();  
	    int h = img.getHeight();  
	    BufferedImage dimg = new BufferedImage(newW, newH, img.getType());  
	    Graphics2D g = dimg.createGraphics();  
	    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	    RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
	    g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);  
	    g.dispose();  
	    return dimg;  
	}  
	
	/** 
	 * The makeVisible Method makes the frame visible.
	 */
	public static void makeVisible(){
		frame.setVisible(true);
	}
	
	/** 
	 * The makeInvisible Method makes the frame hidden.
	 */
	public static void makeInvisible(){
		frame.setVisible(false);
	}

	/** 
	 * The addSemester Method adds a uniform tab to the tabbed pane, using initTabComponent(int i).
	 * Calls makeTextPanel(String text) in order to add necessary components.
	 * Uses semesterNumber and stringSemesterNumber in order to add correct text to new tab.
	 */
	public final static void addSemester(int semesterNumber) {
		String stringSemesterNumber = "Semester " + Integer.toString(semesterNumber);

		Font f = new Font("serif", Font.PLAIN, 24);
		JComponent pnlSemester = makeTextPanel(stringSemesterNumber);
		tabbedPane.addTab(stringSemesterNumber, pnlSemester);
		tabbedPane.setFont(f);
		initTabComponent(tabbedPane.getTabCount() - 1);
	}

}