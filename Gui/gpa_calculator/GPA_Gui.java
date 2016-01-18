package gpa_calculator;

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
//Start commenting next week
public class GPA_Gui extends JPanel {
	private static JTabbedPane tabbedPane;
	public GPA_Gui() {
		super(new GridLayout(1, 1));
		Font f = new Font("serif", Font.PLAIN, 24);
		
		tabbedPane = new JTabbedPane();

		JComponent pnlSemester1 = makeTextPanel("Semester 1");
		tabbedPane.addTab("Semester 1", pnlSemester1);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		tabbedPane.setFont(f);

		JComponent pnlSemester2 = makeTextPanel("Semester 2");
		tabbedPane.addTab("Semester 2", pnlSemester2);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		JComponent pnlSemester3 = makeTextPanel("Semester 3");
		tabbedPane.addTab("Semester 3", pnlSemester3);
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		JComponent pnlSemester4 = makeTextPanel("Semester 4");
		tabbedPane.addTab("Semester 4", pnlSemester4);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		JComponent pnlSemester5 = makeTextPanel("Semester 5");
		tabbedPane.addTab("Semester 5", pnlSemester5);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_5);

		JComponent pnlSemester6 = makeTextPanel("Semester 6");
		tabbedPane.addTab("Semester 6", pnlSemester6);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_6);

		JComponent pnlSemester7 = makeTextPanel("Semester 7");
		tabbedPane.addTab("Semester 7", pnlSemester7);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_7);

		JComponent pnlSemester8 = makeTextPanel("Semester 8");
		tabbedPane.addTab("Semester 8", pnlSemester8);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_8);

		for (int i = 0; i < 8; i++) {
			initTabComponent(i);
		}

		// Add the tabbed pane to this panel.
		add(tabbedPane);
		// The following line enables to use scrolling tabs.
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	private static void initTabComponent(int i) {
		tabbedPane.setTabComponentAt(i, new ButtonTabComponent(tabbedPane));
	}

	protected static JComponent makeTextPanel(String text) {
		Font f1 = new Font("serif", Font.PLAIN, 36);
		Font f2 = new Font("serif", Font.PLAIN, 24);
		Border paddingBorder1 = BorderFactory.createEmptyBorder(10, 40, 10, 40);
		Border paddingBorder2 = BorderFactory.createEmptyBorder(10, 600, 10, 40);
		Border paddingBorder3 = BorderFactory.createEmptyBorder(10, 0, 10, 1435);

		Border paddingBorder5 = BorderFactory.createEmptyBorder(10, 0, 10, 10);
		Border paddingBorder6 = BorderFactory.createEmptyBorder(10, 1260, 10, 0);

		JPanel panel = new JPanel(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel semester = new JPanel();
		
		JPanel empty = new JPanel();

		JPanel class1 = new JPanel();
		class1.setLayout(new BoxLayout(class1, BoxLayout.X_AXIS));

		JPanel class2 = new JPanel();
		class2.setLayout(new BoxLayout(class2, BoxLayout.X_AXIS));

		JPanel class3 = new JPanel();
		class3.setLayout(new BoxLayout(class3, BoxLayout.X_AXIS));

		JPanel class4 = new JPanel();
		class4.setLayout(new BoxLayout(class4, BoxLayout.X_AXIS));

		JPanel class5 = new JPanel();
		class5.setLayout(new BoxLayout(class5, BoxLayout.X_AXIS));

		JPanel class6 = new JPanel();
		class6.setLayout(new BoxLayout(class6, BoxLayout.X_AXIS));

		JPanel class7 = new JPanel();
		class7.setLayout(new BoxLayout(class7, BoxLayout.X_AXIS));

		JPanel class8 = new JPanel();
		class8.setLayout(new BoxLayout(class8, BoxLayout.X_AXIS));

		JPanel addClass = new JPanel();
		addClass.setLayout(new BoxLayout(addClass, BoxLayout.X_AXIS));

		JPanel gpaSemester = new JPanel();
		gpaSemester.setLayout(new BoxLayout(gpaSemester, BoxLayout.X_AXIS));
		
		JPanel gpaTotal = new JPanel();
		gpaTotal.setLayout(new BoxLayout(gpaTotal, BoxLayout.X_AXIS));
		
		BufferedImage buttonIcon = null;
		try {
			buttonIcon = ImageIO.read(new File(GPA_Gui.class.getResource("/images/minus.png").toURI()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		BufferedImage buttonIcon2 = resize(buttonIcon, 20, 20);
		
		BufferedImage buttonIcon3 = null;
		try {
			buttonIcon3 = ImageIO.read(new File(GPA_Gui.class.getResource("/images/plus.png").toURI()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedImage buttonIcon4 = resize(buttonIcon3, 20, 20);

		JButton btnDeleteClass1 = new JButton(new ImageIcon(buttonIcon2));
		btnDeleteClass1.setBorder(paddingBorder5);
		btnDeleteClass1.setContentAreaFilled(false);
		class1.add(btnDeleteClass1);
		
		JLabel fillerClass1 = new JLabel("Class 1");
		fillerClass1.setFont(f2);
		fillerClass1.addMouseListener(PopClickListener.createDialog(fillerClass1, text + ": Class 1"));
		class1.add(fillerClass1);

		JLabel class1Grade = new JLabel("Grade: 0");
		class1Grade.setFont(f2);
		class1Grade.setBorder(paddingBorder2);
		class1.add(class1Grade);

		JLabel class1LetterGrade = new JLabel("Letter Grade: F");
		class1LetterGrade.setFont(f2);
		class1LetterGrade.setBorder(paddingBorder1);
		class1.add(class1LetterGrade);

		JLabel class1Hours = new JLabel("Hours: 0");
		class1Hours.setFont(f2);
		class1Hours.setBorder(paddingBorder1);
		class1.add(class1Hours);

		JLabel class1QualityPoints = new JLabel("Quality Points: 0");
		class1QualityPoints.setFont(f2);
		class1QualityPoints.setBorder(paddingBorder1);
		class1.add(class1QualityPoints);

		
		JButton btnDeleteClass2 = new JButton(new ImageIcon(buttonIcon2));
		btnDeleteClass2.setBorder(paddingBorder5);
		btnDeleteClass2.setContentAreaFilled(false);
		class2.add(btnDeleteClass2);
		
		JLabel fillerClass2 = new JLabel("Class 2");
		fillerClass2.setFont(f2);
		fillerClass2.addMouseListener(PopClickListener.createDialog(fillerClass1,  text + ": Class 2"));
		class2.add(fillerClass2);

		JLabel class2Grade = new JLabel("Grade: 0");
		class2Grade.setFont(f2);
		class2Grade.setBorder(paddingBorder2);
		class2.add(class2Grade);

		JLabel class2LetterGrade = new JLabel("Letter Grade: F");
		class2LetterGrade.setFont(f2);
		class2LetterGrade.setBorder(paddingBorder1);
		class2.add(class2LetterGrade);

		JLabel class2Hours = new JLabel("Hours: 0");
		class2Hours.setFont(f2);
		class2Hours.setBorder(paddingBorder1);
		class2.add(class2Hours);

		JLabel class2QualityPoints = new JLabel("Quality Points: 0");
		class2QualityPoints.setFont(f2);
		class2QualityPoints.setBorder(paddingBorder1);
		class2.add(class2QualityPoints);

		
		JButton btnDeleteClass3 = new JButton(new ImageIcon(buttonIcon2));
		btnDeleteClass3.setBorder(paddingBorder5);
		btnDeleteClass3.setContentAreaFilled(false);
		class3.add(btnDeleteClass3);
		
		JLabel fillerClass3 = new JLabel("Class 3");
		fillerClass3.setFont(f2);
		fillerClass3.addMouseListener(PopClickListener.createDialog(fillerClass3,  text + ": Class 3"));
		class3.add(fillerClass3);

		JLabel class3Grade = new JLabel("Grade: 0");
		class3Grade.setFont(f2);
		class3Grade.setBorder(paddingBorder2);
		class3.add(class3Grade);

		JLabel class3LetterGrade = new JLabel("Letter Grade: F");
		class3LetterGrade.setFont(f2);
		class3LetterGrade.setBorder(paddingBorder1);
		class3.add(class3LetterGrade);

		JLabel class3Hours = new JLabel("Hours: 0");
		class3Hours.setFont(f2);
		class3Hours.setBorder(paddingBorder1);
		class3.add(class3Hours);

		JLabel class3QualityPoints = new JLabel("Quality Points: 0");
		class3QualityPoints.setFont(f2);
		class3QualityPoints.setBorder(paddingBorder1);
		class3.add(class3QualityPoints);

		JButton btnDeleteClass4 = new JButton(new ImageIcon(buttonIcon2));
		btnDeleteClass4.setBorder(paddingBorder5);
		btnDeleteClass4.setContentAreaFilled(false);
		class4.add(btnDeleteClass4);
		
		JLabel fillerClass4 = new JLabel("Class 4");
		fillerClass4.setFont(f2);
		fillerClass4.addMouseListener(PopClickListener.createDialog(fillerClass4,  text + ": Class 4"));
		class4.add(fillerClass4);

		JLabel class4Grade = new JLabel("Grade: 0");
		class4Grade.setFont(f2);
		class4Grade.setBorder(paddingBorder2);
		class4.add(class4Grade);

		JLabel class4LetterGrade = new JLabel("Letter Grade: F");
		class4LetterGrade.setFont(f2);
		class4LetterGrade.setBorder(paddingBorder1);
		class4.add(class4LetterGrade);

		JLabel class4Hours = new JLabel("Hours: 0");
		class4Hours.setFont(f2);
		class4Hours.setBorder(paddingBorder1);
		class4.add(class4Hours);

		JLabel class4QualityPoints = new JLabel("Quality Points: 0");
		class4QualityPoints.setFont(f2);
		class4QualityPoints.setBorder(paddingBorder1);
		class4.add(class4QualityPoints);

		JButton btnDeleteClass5 = new JButton(new ImageIcon(buttonIcon2));
		btnDeleteClass5.setBorder(paddingBorder5);
		btnDeleteClass5.setContentAreaFilled(false);
		class5.add(btnDeleteClass5);
		
		JLabel fillerClass5 = new JLabel("Class 5");
		fillerClass5.setFont(f2);
		fillerClass5.addMouseListener(PopClickListener.createDialog(fillerClass5,  text + ": Class 5"));
		class5.add(fillerClass5);
		
		JLabel class5Grade = new JLabel("Grade: 0");
		class5Grade.setFont(f2);
		class5Grade.setBorder(paddingBorder2);
		class5.add(class5Grade);

		JLabel class5LetterGrade = new JLabel("Letter Grade: F");
		class5LetterGrade.setFont(f2);
		class5LetterGrade.setBorder(paddingBorder1);
		class5.add(class5LetterGrade);

		JLabel class5Hours = new JLabel("Hours: 0");
		class5Hours.setFont(f2);
		class5Hours.setBorder(paddingBorder1);
		class5.add(class5Hours);

		JLabel class5QualityPoints = new JLabel("Quality Points: 0");
		class5QualityPoints.setFont(f2);
		class5QualityPoints.setBorder(paddingBorder1);
		class5.add(class5QualityPoints);

		JButton btnDeleteClass6 = new JButton(new ImageIcon(buttonIcon2));
		btnDeleteClass6.setBorder(paddingBorder5);
		btnDeleteClass6.setContentAreaFilled(false);
		class6.add(btnDeleteClass6);
		
		JLabel fillerClass6 = new JLabel("Class 6");
		fillerClass6.setFont(f2);
		fillerClass6.addMouseListener(PopClickListener.createDialog(fillerClass6,  text + ": Class 6"));
		class6.add(fillerClass6);
		
		JLabel class6Grade = new JLabel("Grade: 0");
		class6Grade.setFont(f2);
		class6Grade.setBorder(paddingBorder2);
		class6.add(class6Grade);

		JLabel class6LetterGrade = new JLabel("Letter Grade: F");
		class6LetterGrade.setFont(f2);
		class6LetterGrade.setBorder(paddingBorder1);
		class6.add(class6LetterGrade);

		JLabel class6Hours = new JLabel("Hours: 0");
		class6Hours.setFont(f2);
		class6Hours.setBorder(paddingBorder1);
		class6.add(class6Hours);

		JLabel class6QualityPoints = new JLabel("Quality Points: 0");
		class6QualityPoints.setFont(f2);
		class6QualityPoints.setBorder(paddingBorder1);
		class6.add(class6QualityPoints);

		JButton btnDeleteClass7 = new JButton(new ImageIcon(buttonIcon2));
		btnDeleteClass7.setBorder(paddingBorder5);
		btnDeleteClass7.setContentAreaFilled(false);
		class7.add(btnDeleteClass7);
		
		JLabel fillerClass7 = new JLabel("Class 7");
		fillerClass7.setFont(f2);
		fillerClass7.addMouseListener(PopClickListener.createDialog(fillerClass7,  text + ": Class 7"));
		class7.add(fillerClass7);

		JLabel class7Grade = new JLabel("Grade: 0");
		class7Grade.setFont(f2);
		class7Grade.setBorder(paddingBorder2);
		class7.add(class7Grade);

		JLabel class7LetterGrade = new JLabel("Letter Grade: F");
		class7LetterGrade.setFont(f2);
		class7LetterGrade.setBorder(paddingBorder1);
		class7.add(class7LetterGrade);

		JLabel class7Hours = new JLabel("Hours: 0");
		class7Hours.setFont(f2);
		class7Hours.setBorder(paddingBorder1);
		class7.add(class7Hours);

		JLabel class7QualityPoints = new JLabel("Quality Points: 0");
		class7QualityPoints.setFont(f2);
		class7QualityPoints.setBorder(paddingBorder1);
		class7.add(class7QualityPoints);

		JButton btnDeleteClass8 = new JButton(new ImageIcon(buttonIcon2));
		btnDeleteClass8.setBorder(paddingBorder5);
		btnDeleteClass8.setContentAreaFilled(false);
		class8.add(btnDeleteClass8);
		
		JLabel fillerClass8 = new JLabel("Class 8");
		fillerClass8.setFont(f2);
		fillerClass8.addMouseListener(PopClickListener.createDialog(fillerClass8,  text + ": Class 8"));
		class8.add(fillerClass8);

		JLabel class8Grade = new JLabel("Grade: 0");
		class8Grade.setFont(f2);
		class8Grade.setBorder(paddingBorder2);
		class8.add(class8Grade);

		JLabel class8LetterGrade = new JLabel("Letter Grade: F");
		class8LetterGrade.setFont(f2);
		class8LetterGrade.setBorder(paddingBorder1);
		class8.add(class8LetterGrade);

		JLabel class8Hours = new JLabel("Hours: 0");
		class8Hours.setFont(f2);
		class8Hours.setBorder(paddingBorder1);
		class8.add(class8Hours);

		JLabel class8QualityPoints = new JLabel("Quality Points: 0");
		class8QualityPoints.setFont(f2);
		class8QualityPoints.setBorder(paddingBorder1);
		class8.add(class8QualityPoints);

		JLabel fillerSemester = new JLabel(text);
		fillerSemester.setFont(f1);
		semester.add(fillerSemester);
		
		JButton btnAddClass = new JButton(new ImageIcon(buttonIcon4));
		btnAddClass.setBorder(paddingBorder3);
		btnAddClass.setContentAreaFilled(false);
		addClass.add(btnAddClass);

		JLabel semesterGPA = new JLabel("Semester GPA: 0.00");
		semesterGPA.setFont(f2);
		semesterGPA.setBorder(paddingBorder6);
		gpaSemester.add(semesterGPA);

		JLabel totalGPA = new JLabel("Total GPA: 0.00");
		totalGPA.setFont(f2);
		totalGPA.setBorder(paddingBorder6);
		gpaTotal.add(totalGPA);
		
		panel.add(semester);
		panel.add(empty);
		panel.add(class1);
		panel.add(class2);
		panel.add(class3);
		panel.add(class4);
		panel.add(class5);
		panel.add(class6);
		panel.add(class7);
		panel.add(class8);
		panel.add(addClass);
		panel.add(gpaSemester);
		panel.add(gpaTotal);

		return panel;
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 */
	private static JFrame frame;

	private static void createAndShowGUI() {
		// Create and set up the window.
		frame = new JFrame("GPA Calculator");

		// Initialize MenuBar
		JMenuBar menuBar;

		// Initialize Menus
		JMenu menuFile;
		JMenu menuNew;
		
		JMenu menuEdit;
		JMenu menuEditSemester;

		JMenu menuView;
		// Initialize MenuItems
		JMenuItem menuItemQuit;
		JMenuItem menuItemNewStudent;
		JMenuItem menuItemNewSemester;
		JMenuItem menuItemSettings;
		JMenuItem menuItemSave;
		JMenuItem menuItemSaveAs;
		JMenuItem menuItemSaveAll;
		JMenuItem menuItemEditSemester1;
		JMenuItem menuItemEditSemester2;
		JMenuItem menuItemEditSemester3;
		JMenuItem menuItemEditSemester4;
		JMenuItem menuItemEditSemester5;
		JMenuItem menuItemEditSemester6;
		JMenuItem menuItemEditSemester7;
		JMenuItem menuItemEditSemester8;
		JMenuItem menuItemStudentView;
		JMenuItem menuItemSemesterView;
		JMenuItem menuItemClassView;

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = frame.getContentPane();
		// adjust to need.
		Dimension d = new Dimension(1500, 800);
		c.setPreferredSize(d);
		// Add content to the window.
		frame.add(new GPA_Gui(), BorderLayout.NORTH);

		Font fmenu = new Font("sans-serif", Font.PLAIN, 12);
		UIManager.put("Menu.font", fmenu);
		UIManager.put("MenuItem.font", fmenu);
		menuBar = new JMenuBar();
		// Build the File menu.
		menuFile = new JMenu("File");
		menuFile.setMnemonic(KeyEvent.VK_A);
		
		menuNew = new JMenu("New");
		// Build the Edit menu.
		menuEdit = new JMenu("Edit");
		menuEditSemester = new JMenu("Edit Semester");
		
		menuView = new JMenu("View");
		
		// a group of JMenuItems
		menuItemQuit = new JMenuItem("Quit", KeyEvent.VK_T);
		menuItemQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		menuItemQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				System.exit(0);
			}
		});

		menuItemNewStudent = new JMenuItem("Student", KeyEvent.VK_2);
		menuItemNewStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		menuItemNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

			}
		});

		menuItemNewSemester = new JMenuItem("Semester", KeyEvent.VK_3);
		menuItemNewSemester.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		menuItemNewSemester.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				addSemester();
				JMenuItem menuItemNewSemesterX = new JMenuItem("Semester " + stringSemesterNumber);
				menuItemNewSemesterX.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent actionEvent) {
						EditSemester_Gui.createAndShowGUI("Semester " + stringSemesterNumber);
						frame.setVisible(false);
					}
				});
				menuEditSemester.add(menuItemNewSemesterX);
			}
		});
		
		menuItemSettings = new JMenuItem("Settings");
		menuItemSettings.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent){
				
			}
		});
		
		menuItemSave = new JMenuItem("Save");
		menuItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		menuItemSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent) {
				
			}
		});
		
		menuItemSaveAs = new JMenuItem("Save As");
		menuItemSaveAs.setAccelerator(KeyStroke.getKeyStroke("control shift S"));
		menuItemSaveAs.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent) {
				
			}
		});
		
		menuItemSaveAll = new JMenuItem("Save All");
		menuItemSaveAll.setAccelerator(KeyStroke.getKeyStroke("alt shift S"));
		menuItemSaveAll.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent) {
				
			}
		});

		menuItemEditSemester1 = new JMenuItem("Semester 1");
		menuItemEditSemester1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				EditSemester_Gui.createAndShowGUI("Semester 1");
				frame.setVisible(false);
			}
		});
		menuItemEditSemester2 = new JMenuItem("Semester 2");
		menuItemEditSemester2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				EditSemester_Gui.createAndShowGUI("Semester 2");
				frame.setVisible(false);
			}
		});
		menuItemEditSemester3 = new JMenuItem("Semester 3");
		menuItemEditSemester3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				EditSemester_Gui.createAndShowGUI("Semester 3");
				frame.setVisible(false);
			}
		});
		menuItemEditSemester4 = new JMenuItem("Semester 4");
		menuItemEditSemester4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				EditSemester_Gui.createAndShowGUI("Semester 4");
				frame.setVisible(false);
			}
		});
		menuItemEditSemester5 = new JMenuItem("Semester 5");
		menuItemEditSemester5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				EditSemester_Gui.createAndShowGUI("Semester 5");
				frame.setVisible(false);
			}
		});
		menuItemEditSemester6 = new JMenuItem("Semester 6");
		menuItemEditSemester6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				EditSemester_Gui.createAndShowGUI("Semester 6");
				frame.setVisible(false);
			}
		});
		menuItemEditSemester7 = new JMenuItem("Semester 7");
		menuItemEditSemester7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				EditSemester_Gui.createAndShowGUI("Semester7");
				frame.setVisible(false);
			}
		});
		menuItemEditSemester8 = new JMenuItem("Semester 8");
		menuItemEditSemester8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				EditSemester_Gui.createAndShowGUI("Semester 8");
				frame.setVisible(false);
			}
		});

		
		menuItemStudentView = new JMenuItem("Student View");
		menuItemStudentView.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		menuItemStudentView.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent){
				
			}
		});
		
		menuItemSemesterView = new JMenuItem("Semester View");
		menuItemSemesterView.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		menuItemSemesterView.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent){
				EditSemester_Gui.makeVisible();
				frame.setVisible(false);
			}
		});
		
		menuItemClassView = new JMenuItem("Class View");
		menuItemClassView.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		menuItemClassView.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent){
				EditClass_Gui.makeVisible();
				frame.setVisible(false);
			}
		});
		
		menuBar.add(menuFile);
		menuFile.add(menuNew);
		menuBar.add(menuEdit);
		menuBar.add(menuView);
		
		// Add Exit Item to File Menu.
		menuNew.add(menuItemNewStudent);
		menuNew.add(menuItemNewSemester);
		menuFile.addSeparator();
		menuFile.add(menuItemSave);
		menuFile.add(menuItemSaveAs);
		menuFile.add(menuItemSaveAll);
		menuFile.addSeparator();
		menuFile.add(menuItemSettings);
		menuFile.addSeparator();
		menuFile.add(menuItemQuit);
		
		menuEdit.add(menuEditSemester);
		
		menuEditSemester.add(menuItemEditSemester1);
		menuEditSemester.add(menuItemEditSemester2);
		menuEditSemester.add(menuItemEditSemester3);
		menuEditSemester.add(menuItemEditSemester4);
		menuEditSemester.add(menuItemEditSemester5);
		menuEditSemester.add(menuItemEditSemester6);
		menuEditSemester.add(menuItemEditSemester7);
		menuEditSemester.add(menuItemEditSemester8);
		
		menuView.add(menuItemStudentView);
		menuView.add(menuItemSemesterView);
		menuView.add(menuItemClassView);
		
		frame.setJMenuBar(menuBar);
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
	
	static int semesterNumber = 9;
	static String stringSemesterNumber = Integer.toString(semesterNumber);
	public final static void addSemester() {
		String stringSemesterNumber = "Semester " + Integer.toString(semesterNumber);
		// tabbedPane.add(stringSemesterNumber, new ScrollPane());

		Font f = new Font("serif", Font.PLAIN, 24);
		JComponent pnlSemester = makeTextPanel(stringSemesterNumber);
		tabbedPane.addTab(stringSemesterNumber, pnlSemester);
		tabbedPane.setFont(f);
		initTabComponent(tabbedPane.getTabCount() - 1);
		semesterNumber++;
		// frame.add(new GPA_Gui(), BorderLayout.NORTH);
	}

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