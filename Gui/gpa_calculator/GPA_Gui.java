package gpa_calculator;

//import statements
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

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
	private static JTabbedPane tabbedPane;
	
	/** 
	 * The GPA_Gui Method places a tabbed pane onto the frame.
	 * Calls the methods initTabComponent(int i) and makeTextPanel(String text).
	 */
	public GPA_Gui() {
		
		//Define Layout of frame
		super(new GridLayout(1, 1));
		
		//Initialize fonts
		Font f = new Font("serif", Font.PLAIN, 24);
		
		//Initialize tabbed pane
		tabbedPane = new JTabbedPane();
		
		// The following line enables to use scrolling tabs.
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		//Set tabbed pane font
		tabbedPane.setFont(f);
		
		//Initialize panels, add panels and set panel fonts
		//Initialize panel that the Semester 1 tab will hold
		//Call makeTextPanel for this panel
		JComponent pnlSemester1 = makeTextPanel("Semester 1");
		//Add tab with panel
		tabbedPane.addTab("Semester 1", pnlSemester1);
		//Set tab mnemonic
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		//Initialize panel that the Semester 2 tab will hold
		//Call makeTextPanel for this panel
		JComponent pnlSemester2 = makeTextPanel("Semester 2");
		//Add tab with panel
		tabbedPane.addTab("Semester 2", pnlSemester2);
		//Set tab mnemonic
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		//Initialize panel that the Semester 3 tab will hold
		//Call makeTextPanel for this panel
		JComponent pnlSemester3 = makeTextPanel("Semester 3");
		//Add tab with panel
		tabbedPane.addTab("Semester 3", pnlSemester3);
		//Set tab mnemonic
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		//Initialize panel that the Semester 4 tab will hold
		//Call makeTextPanel for this panel
		JComponent pnlSemester4 = makeTextPanel("Semester 4");
		//Add tab with panel
		tabbedPane.addTab("Semester 4", pnlSemester4);
		//Set tab mnemonic
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		//Initialize panel that the Semester 5 tab will hold
		//Call makeTextPanel for this panel
		JComponent pnlSemester5 = makeTextPanel("Semester 5");
		//Add tab with panel
		tabbedPane.addTab("Semester 5", pnlSemester5);
		//Set tab mnemonic
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_5);

		//Initialize panel that the Semester 6 tab will hold
		//Call makeTextPanel for this panel
		JComponent pnlSemester6 = makeTextPanel("Semester 6");
		//Add tab with panel
		tabbedPane.addTab("Semester 6", pnlSemester6);
		//Set tab mnemonic
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_6);

		//Initialize panel that the Semester 7 tab will hold
		//Call makeTextPanel for this panel
		JComponent pnlSemester7 = makeTextPanel("Semester 7");
		//Add tab with panel
		tabbedPane.addTab("Semester 7", pnlSemester7);
		//Set tab mnemonic
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_7);

		//Initialize panel that the Semester 8 tab will hold
		//Call makeTextPanel for this panel
		JComponent pnlSemester8 = makeTextPanel("Semester 8");
		//Add tab with panel
		tabbedPane.addTab("Semester 8", pnlSemester8);
		//Set tab mnemonic
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_8);

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
	private static void createAndShowGUI() {
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

	/** 
	 * The main Method initializes the frame and creates all frames necessary for the application.
	 * Makes GPA_Gui frame visible and hides other frames.
	 */
	public static void main(String[] args) {
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		EditSemester_Gui.createAndShowGUI("Semester 1");
		EditSemester_Gui.makeInvisible();
		EditClass_Gui.createAndShowGUI("Semester 1: Class 1");
		EditClass_Gui.makeInvisible();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
		
	}
}