package gpa_calculator.editsemester_gui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import gpa_calculator.buttontabcomponents.ButtonTabComponent2;
import gpa_calculator.buttontabcomponents.ButtonTabComponent3;
import gpa_calculator.buttontabcomponents.ButtonTabComponent4;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;


public class EditSemester_Gui extends JPanel {
	private static JComponent pnlAll;
	private static MainPanel1_EditSemester_Gui tabbedPane1;
	private static MainPanel2_EditSemester_Gui tabbedPane2;
	private static MainPanel3_EditSemester_Gui tabbedPane3;
	static JComponent pnlInnerSemester;
	static JComponent pnlInnerSettings;
	static JComponent pnlSemester;
	static JComponent pnlSettings;
	static JComponent pnlTreeContainer;
	static JComponent pnlTree;
	static String s2;
	private static JFrame frame;
	
	public EditSemester_Gui(String s) {

		super(new GridLayout(2, 1));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon.png")));
		Dimension d1 = new Dimension(400, 800);
		Dimension d2 = new Dimension(900, 800);
		Dimension d3 = new Dimension(200, 800);
		Dimension d4 = new Dimension(1500, 800);

		tabbedPane1 = new MainPanel1_EditSemester_Gui(s);
		tabbedPane2 = new MainPanel2_EditSemester_Gui(s);
		tabbedPane3 = new MainPanel3_EditSemester_Gui(s);
		
		pnlAll = new JPanel();
		pnlAll.setPreferredSize(d4);
		pnlAll.setLayout(new BoxLayout(pnlAll, BoxLayout.X_AXIS));
		
		pnlTreeContainer = new JPanel();
		pnlTreeContainer.setPreferredSize(d3);
		pnlTreeContainer.add(tabbedPane3);
		
		pnlSettings = new JPanel();
		pnlSettings.setPreferredSize(d1);
		pnlSettings.add(tabbedPane1);

		pnlSemester = new JPanel();
		pnlSemester.setPreferredSize(d2);
		pnlSemester.add(tabbedPane2);
		
		// Add the tabbed pane to this panel.
		initTabComponent(0);
		initTabComponent2(0);
		initTabComponent3(0);
		
		pnlAll.add(pnlTreeContainer);
		pnlAll.add(pnlSemester);
		pnlAll.add(pnlSettings);
		
		add(pnlAll);
	}

	private static void initTabComponent(int i) {
		tabbedPane1.setTabComponentAt(i, new ButtonTabComponent3(tabbedPane1));
	}
	
	private static void initTabComponent2(int i) {
		tabbedPane2.setTabComponentAt(i, new ButtonTabComponent2(tabbedPane2));
	}
	
	private static void initTabComponent3(int i) {
		tabbedPane3.setTabComponentAt(i, new ButtonTabComponent4(tabbedPane3));
	}

	protected static JComponent makeTextPanel1(String text) {
		makeTextPanel1_EditSemester_Gui textPanel1 = new makeTextPanel1_EditSemester_Gui(text);
		return textPanel1;
	}

	protected static JComponent makeTextPanel2(String text) {
		makeTextPanel2_EditSemester_Gui makeTextPanel2 = new makeTextPanel2_EditSemester_Gui(text);
		return makeTextPanel2;
	}
	
	protected static JComponent makeTextPanel3(String text) {
		makeTextPanel3_EditSemester_Gui textPanel3 = new makeTextPanel3_EditSemester_Gui(text);
		return textPanel3;
	}

	
	public static void createAndShowGUI(String s) {
		// Create and set up the window.
		s2 = s;
		frame = new JFrame("GPA Calculator - Edit " + s);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = frame.getContentPane();
		// adjust to need.
		Dimension d = new Dimension(1500, 800);
		c.setPreferredSize(d);
		// Add content to the window.
		frame.add(new EditSemester_Gui(s2), BorderLayout.NORTH);

		frame.setJMenuBar(new Menu_EditSemester_Gui(s));
		// Add Panel to Frame
		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}
	
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
	
	public static void makeVisible(){
		frame.setVisible(true);
	}
	
	public static void makeInvisible(){
		frame.setVisible(false);
	}
	
	public final static void addSemester(String s) {

		Font f = new Font("serif", Font.PLAIN, 24);
		JComponent pnlSemester1 = makeTextPanel2(s);
		tabbedPane2.addTab(s , pnlSemester1);
		tabbedPane2.setFont(f);
		initTabComponent2(tabbedPane2.getTabCount() - 1);

		JComponent pnlSettings1 = makeTextPanel1(s + " Settings");
		tabbedPane1.addTab(s + " Settings", pnlSettings1);
		tabbedPane1.setFont(f);
		initTabComponent(tabbedPane1.getTabCount() - 1);
		// frame.add(new GPA_Gui(), BorderLayout.NORTH);
	}
	
	public final static void addSettingView(String semester) {
		Font f = new Font("serif", Font.PLAIN, 24);
		JComponent pnlSemester = makeTextPanel1(semester);
		tabbedPane1.addTab(semester, pnlSemester);
		tabbedPane1.setFont(f);
		initTabComponent(tabbedPane1.getTabCount() - 1);
	}
	
	public static void main(String[] args) {
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI(s2);
			}
		});
	}
}
