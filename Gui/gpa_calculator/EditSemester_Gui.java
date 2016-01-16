package gpa_calculator;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
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
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;

public class EditSemester_Gui extends JPanel {

	public EditSemester_Gui() {

		super(new GridLayout(1, 1));
		Font f = new Font("serif", Font.PLAIN, 24);
		JTabbedPane tabbedPane = new JTabbedPane();

		JComponent pnlSemester1 = new JPanel();
		JButton btn = new JButton("Button");
		pnlSemester1.add(btn);
		tabbedPane.addTab("Semester #1", pnlSemester1);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		tabbedPane.setFont(f);

		JComponent pnlSemester2 = new JPanel();
		tabbedPane.addTab("Settings", pnlSemester2);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		// Add the tabbed pane to this panel.
		add(tabbedPane);

		// The following line enables to use scrolling tabs.
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Edit Semester");

		// Initialize MenuBar
		JMenuBar menuBar;

		// Initialize Menus
		JMenu menuFile;
		JMenu menuEdit;
		JMenu menuEditSemester;

		// Initialize MenuItems
		JMenuItem menuItemQuit;
		JMenuItem menuItemNewStudent;
		JMenuItem menuItemEditSemester1;
		JMenuItem menuItemEditSemester2;
		JMenuItem menuItemEditSemester3;
		JMenuItem menuItemEditSemester4;
		JMenuItem menuItemEditSemester5;
		JMenuItem menuItemEditSemester6;
		JMenuItem menuItemEditSemester7;
		JMenuItem menuItemEditSemester8;

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = frame.getContentPane();
		// adjust to need.
		Dimension d = new Dimension(1500, 800);
		c.setPreferredSize(d);
		// Add content to the window.
		frame.add(new EditSemester_Gui(), BorderLayout.NORTH);

		Font fmenu = new Font("sans-serif", Font.PLAIN, 20);
		UIManager.put("Menu.font", fmenu);
		UIManager.put("MenuItem.font", fmenu);
		menuBar = new JMenuBar();
		// Build the File menu.
		menuFile = new JMenu("File");
		menuFile.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menuFile);
		// Build the Edit menu.
		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);

		// a group of JMenuItems
		menuItemQuit = new JMenuItem("Quit", KeyEvent.VK_T);
		menuItemQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		menuItemQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				System.exit(0);
			}
		});

		menuItemNewStudent = new JMenuItem("New Student", KeyEvent.VK_2);
		menuItemNewStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		menuItemNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

			}
		});

		menuEditSemester = new JMenu("Edit Semester");

		menuItemEditSemester1 = new JMenuItem("Semester 1");
		menuItemEditSemester2 = new JMenuItem("Semester 2");
		menuItemEditSemester3 = new JMenuItem("Semester 3");
		menuItemEditSemester4 = new JMenuItem("Semester 4");
		menuItemEditSemester5 = new JMenuItem("Semester 5");
		menuItemEditSemester6 = new JMenuItem("Semester 6");
		menuItemEditSemester7 = new JMenuItem("Semester 7");
		menuItemEditSemester8 = new JMenuItem("Semester 8");

		menuEditSemester.add(menuItemEditSemester1);
		menuEditSemester.add(menuItemEditSemester2);
		menuEditSemester.add(menuItemEditSemester3);
		menuEditSemester.add(menuItemEditSemester4);
		menuEditSemester.add(menuItemEditSemester5);
		menuEditSemester.add(menuItemEditSemester6);
		menuEditSemester.add(menuItemEditSemester7);
		menuEditSemester.add(menuItemEditSemester8);
		// Add Exit Item to File Menu.
		menuFile.add(menuItemNewStudent);
		menuFile.add(menuItemQuit);
		menuEdit.add(menuEditSemester);
		frame.setJMenuBar(menuBar);
		// Add Panel to Frame
		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}
}
