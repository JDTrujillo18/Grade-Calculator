package gpa_calculator;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTree;
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
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class EditSemester_Gui extends JPanel {
	private static JComponent pnlAll;
	private static JTabbedPane tabbedPane1;
	private static JTabbedPane tabbedPane2;
	private static JTabbedPane tabbedPane3;
	static JComponent pnlInnerSemester;
	static JComponent pnlInnerSettings;
	static JComponent pnlSemester;
	static JComponent pnlSettings;
	static JComponent pnlTreeContainer;
	static JComponent pnlTree;
	static String s2;
	
	public EditSemester_Gui(String s) {

		super(new GridLayout(2, 1));
		Font f = new Font("serif", Font.PLAIN, 24);
		Dimension d1 = new Dimension(400, 800);
		Dimension d2 = new Dimension(900, 800);
		Dimension d3 = new Dimension(200, 800);
		Dimension d4 = new Dimension(1500, 800);
		tabbedPane1 = new JTabbedPane();
		tabbedPane1.setPreferredSize(d1);
		tabbedPane2 = new JTabbedPane();
		tabbedPane2.setPreferredSize(d2);
		tabbedPane3 = new JTabbedPane();
		tabbedPane3.setPreferredSize(d3);
		// The following line enables to use scrolling tabs.
		tabbedPane1.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane2.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane3.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		pnlAll = new JPanel();
		pnlAll.setPreferredSize(d4);
		pnlAll.setLayout(new BoxLayout(pnlAll, BoxLayout.X_AXIS));
		
		pnlTreeContainer = new JPanel();
		pnlTreeContainer.setPreferredSize(d3);
		pnlTreeContainer.add(tabbedPane3);
		
		pnlTree = makeTextPanel3("Student Tree View");
		tabbedPane3.addTab("Student Tree View", pnlTree);
		tabbedPane3.setMnemonicAt(0, KeyEvent.VK_3);
		tabbedPane3.setFont(f);
		
		pnlSettings = new JPanel();
		pnlSettings.setPreferredSize(d1);
		pnlSettings.add(tabbedPane1);
		
		pnlInnerSettings = makeTextPanel1(s + " Settings");
		tabbedPane1.addTab(s + " Settings", pnlInnerSettings);
		tabbedPane1.setMnemonicAt(0, KeyEvent.VK_1);
		tabbedPane1.setFont(f);
		

		pnlSemester = new JPanel();
		pnlSemester.setPreferredSize(d2);
		pnlSemester.add(tabbedPane2);
		
		pnlInnerSemester = makeTextPanel2(s);
		tabbedPane2.addTab(s, pnlInnerSemester);
		tabbedPane2.setMnemonicAt(0, KeyEvent.VK_2);
		tabbedPane2.setFont(f);
		
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
	
	private static void createNodes1(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode category = null ;
        DefaultMutableTreeNode subcategory = null;
        DefaultMutableTreeNode subsubcategory = null;
        category = new DefaultMutableTreeNode("General");
        top.add(category);
        
        subcategory = new DefaultMutableTreeNode("Appearance");
        category.add(subcategory);
        
        subsubcategory = new DefaultMutableTreeNode("Fonts and Colors");
        subcategory.add(subsubcategory);
        
        subsubcategory = new DefaultMutableTreeNode("Themes");
        subcategory.add(subsubcategory);
        
        subcategory = new DefaultMutableTreeNode("Semester");
        category.add(subcategory);
        
        subsubcategory = new DefaultMutableTreeNode("Semester Title");
        subcategory.add(subsubcategory);
        
        subcategory = new DefaultMutableTreeNode("Classes");
        category.add(subcategory);
        
        subsubcategory = new DefaultMutableTreeNode("Number of Classes");
        subcategory.add(subsubcategory);
        
        subcategory = new DefaultMutableTreeNode("Other");
        category.add(subcategory);
        
        subsubcategory = new DefaultMutableTreeNode("Grading Criteria");
        subcategory.add(subsubcategory);
        
    }
 
	private static void createNodes2(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode category = null ;
        DefaultMutableTreeNode subcategory = null;
        DefaultMutableTreeNode subsubcategory = null;
        category = new DefaultMutableTreeNode("Student");
        top.add(category);
        
        subcategory = new DefaultMutableTreeNode("Semester 1");
        category.add(subcategory);
        
        subsubcategory = new DefaultMutableTreeNode("Class 1");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 2");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 3");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 4");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 5");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 6");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 7");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 8");
        subcategory.add(subsubcategory);
        
        subcategory = new DefaultMutableTreeNode("Semester 2");
        category.add(subcategory);
        
        subsubcategory = new DefaultMutableTreeNode("Class 1");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 2");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 3");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 4");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 5");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 6");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 7");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 8");
        subcategory.add(subsubcategory);
        
        subcategory = new DefaultMutableTreeNode("Semester 3");
        category.add(subcategory);
        
        subsubcategory = new DefaultMutableTreeNode("Class 1");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 2");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 3");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 4");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 5");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 6");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 7");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 8");
        subcategory.add(subsubcategory);
        
        subcategory = new DefaultMutableTreeNode("Semester 4");
        category.add(subcategory);
        
        subsubcategory = new DefaultMutableTreeNode("Class 1");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 2");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 3");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 4");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 5");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 6");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 7");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 8");
        subcategory.add(subsubcategory);
        
        subcategory = new DefaultMutableTreeNode("Semester 5");
        category.add(subcategory);
        
        subsubcategory = new DefaultMutableTreeNode("Class 1");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 2");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 3");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 4");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 5");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 6");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 7");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 8");
        subcategory.add(subsubcategory);
        
        subcategory = new DefaultMutableTreeNode("Semester 6");
        category.add(subcategory);
        
        subsubcategory = new DefaultMutableTreeNode("Class 1");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 2");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 3");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 4");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 5");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 6");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 7");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 8");
        subcategory.add(subsubcategory);
        
        subcategory = new DefaultMutableTreeNode("Semester 7");
        category.add(subcategory);
        
        subsubcategory = new DefaultMutableTreeNode("Class 1");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 2");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 3");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 4");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 5");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 6");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 7");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 8");
        subcategory.add(subsubcategory);
        
        subcategory = new DefaultMutableTreeNode("Semester 8");
        category.add(subcategory);
        
        subsubcategory = new DefaultMutableTreeNode("Class 1");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 2");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 3");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 4");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 5");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 6");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 7");
        subcategory.add(subsubcategory);
        subsubcategory = new DefaultMutableTreeNode("Class 8");
        subcategory.add(subsubcategory);

        
    }

	protected static JComponent makeTextPanel1(String text) {
		//Font f1 = new Font("serif", Font.PLAIN, 36);
		//Font f2 = new Font("serif", Font.PLAIN, 24);
		//Border paddingBorder1 = BorderFactory.createEmptyBorder(10, 40, 10, 40);
		//Border paddingBorder2 = BorderFactory.createEmptyBorder(10, 600, 10, 40);
		//Border paddingBorder3 = BorderFactory.createEmptyBorder(10, 0, 10, 1435);

		//Border paddingBorder5 = BorderFactory.createEmptyBorder(10, 0, 10, 10);
		//Border paddingBorder6 = BorderFactory.createEmptyBorder(10, 1260, 10, 0);

		JPanel panel = new JPanel(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		//Create the nodes.
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(text);
        createNodes1(top);
 
        //Create a tree that allows one selection at a time.
        JTree tree = new JTree(top);
        tree.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);
 
        //Create the scroll pane and add the tree to it. 
        JScrollPane treeView = new JScrollPane(tree);
		panel.add(treeView);
		return panel;
	}

	protected static JComponent makeTextPanel2(String text) {
		//Font f1 = new Font("serif", Font.PLAIN, 36);
		//Font f2 = new Font("serif", Font.PLAIN, 24);
		//Border paddingBorder1 = BorderFactory.createEmptyBorder(10, 40, 10, 40);
		//Border paddingBorder2 = BorderFactory.createEmptyBorder(10, 600, 10, 40);
		//Border paddingBorder3 = BorderFactory.createEmptyBorder(10, 0, 10, 1435);

		//Border paddingBorder5 = BorderFactory.createEmptyBorder(10, 0, 10, 10);
		//Border paddingBorder6 = BorderFactory.createEmptyBorder(10, 1260, 10, 0);
		Font f1 = new Font("serif", Font.PLAIN, 36);
		Font f2 = new Font("serif", Font.PLAIN, 24);
		Border paddingBorder1 = BorderFactory.createEmptyBorder(10, 10, 10, 40);
		Border paddingBorder2 = BorderFactory.createEmptyBorder(10, 10, 10, 40);
		Border paddingBorder3 = BorderFactory.createEmptyBorder(10, 0, 10, 755);

		Border paddingBorder5 = BorderFactory.createEmptyBorder(10, 0, 10, 10);
		Border paddingBorder6 = BorderFactory.createEmptyBorder(10, 450, 10, 0);
		Dimension d1 = new Dimension(900, 800);
		Dimension d2 = new Dimension(900, 100);
		Dimension d3 = new Dimension(900, 600);
		Dimension d4 = new Dimension(900, 50);
		//change_1 = false;
		//change_2 = false;
		//change_3 = false;
		//change_4 = false;
		//change_5 = false;
		//change_6 = false;
		//change_7 = false;
		//change_8 = false;
		//change_9 = false;
		//change_10 = false;
		//change_11 = false;
		//change_12 = false;
		//change_13 = false;
		//change_14 = false;
		//change_15 = false;
		//change_16 = false;
		JPanel container = new JPanel(false);
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.setPreferredSize(d1);
		
		JPanel panel = new JPanel(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setPreferredSize(d3);
		
		JPanel semester = new JPanel();
		container.setPreferredSize(d2);
		
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
		gpaSemester.setPreferredSize(d4);
		
		JPanel gpaTotal = new JPanel();
		gpaTotal.setLayout(new BoxLayout(gpaTotal, BoxLayout.X_AXIS));
		gpaSemester.setPreferredSize(d4);
		
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
		fillerClass1.addMouseListener(PopClickListener.createDialog(fillerClass1, "Class 1"));
		class1.add(fillerClass1);

		//fillerClass1.addFocusListener(new FocusAdapter() {
			//public void focusGained(FocusEvent fEvt) {
				//JTextField tField = (JTextField) fEvt.getSource();
				//tField.selectAll();
			//}
		//});

		//fillerClass1.getDocument().addDocumentListener(new DocumentListener() {
			//public void changedUpdate(DocumentEvent e) {
				//change_1 = true;
			//}

			//public void removeUpdate(DocumentEvent e) {
				//change_1 = true;
			//}

			//public void insertUpdate(DocumentEvent e) {
				//change_1 = true;
			//}
		//});
		
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

		//class1Hours.addFocusListener(new FocusAdapter() {
			//public void focusGained(FocusEvent fEvt) {
				//JTextField tField = (JTextField) fEvt.getSource();
				//tField.selectAll();
			//}
		//});

		//class1Hours.getDocument().addDocumentListener(new DocumentListener() {
			//public void changedUpdate(DocumentEvent e) {
				//change_9 = true;
			//}

			//public void removeUpdate(DocumentEvent e) {
				//change_9 = true;
			//}

			//public void insertUpdate(DocumentEvent e) {
				//change_9 = true;
			//}
		//});
		
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
		fillerClass2.addMouseListener(PopClickListener.createDialog(fillerClass2, "Class 2"));
		class2.add(fillerClass2);

		//fillerClass2.addFocusListener(new FocusAdapter() {
			//public void focusGained(FocusEvent fEvt) {
				//JTextField tField = (JTextField) fEvt.getSource();
				//tField.selectAll();
			//}
		//});

		//fillerClass2.getDocument().addDocumentListener(new DocumentListener() {
			//public void changedUpdate(DocumentEvent e) {
			//	change_2 = true;
			//}

			//public void removeUpdate(DocumentEvent e) {
				//change_2 = true;
			//}

			//public void insertUpdate(DocumentEvent e) {
				//change_2 = true;
			//}
		//});
		
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

		//class2Hours.addFocusListener(new FocusAdapter() {
			//public void focusGained(FocusEvent fEvt) {
			//	JTextField tField = (JTextField) fEvt.getSource();
			//	tField.selectAll();
			//}
		//});

		//class2Hours.getDocument().addDocumentListener(new DocumentListener() {
			//public void changedUpdate(DocumentEvent e) {
			//	change_10 = true;
			//}

			//public void removeUpdate(DocumentEvent e) {
			//	change_10 = true;
			//}

			//public void insertUpdate(DocumentEvent e) {
			//	change_10 = true;
			//}
		//});
		
		
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
		fillerClass3.addMouseListener(PopClickListener.createDialog(fillerClass3, "Class 3"));
		class3.add(fillerClass3);

		//fillerClass3.addFocusListener(new FocusAdapter() {
			//public void focusGained(FocusEvent fEvt) {
			//	JTextField tField = (JTextField) fEvt.getSource();
			//	tField.selectAll();
			//}
		//});

		//fillerClass3.getDocument().addDocumentListener(new DocumentListener() {
			//public void changedUpdate(DocumentEvent e) {
			//	change_3 = true;
			//}

			//public void removeUpdate(DocumentEvent e) {
			//	change_3 = true;
			//}

			//public void insertUpdate(DocumentEvent e) {
			//	change_3 = true;
			//}
		//});
		
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

		//class3Hours.addFocusListener(new FocusAdapter() {
		//	public void focusGained(FocusEvent fEvt) {
		//		JTextField tField = (JTextField) fEvt.getSource();
		//		tField.selectAll();
		//	}
		//});

		//class3Hours.getDocument().addDocumentListener(new DocumentListener() {
		//	public void changedUpdate(DocumentEvent e) {
			//	change_11 = true;
			//}

			//public void removeUpdate(DocumentEvent e) {
			//	change_11 = true;
			//}

			//public void insertUpdate(DocumentEvent e) {
			//	change_11 = true;
			//}
		//});
		
		
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
		fillerClass4.addMouseListener(PopClickListener.createDialog(fillerClass4, "Class 4"));
		class4.add(fillerClass4);

		//fillerClass4.addFocusListener(new FocusAdapter() {
			//public void focusGained(FocusEvent fEvt) {
				//JTextField tField = (JTextField) fEvt.getSource();
				//tField.selectAll();
			//}
		//});

		//fillerClass4.getDocument().addDocumentListener(new DocumentListener() {
			//public void changedUpdate(DocumentEvent e) {
			//	change_4 = true;
			//}

			//public void removeUpdate(DocumentEvent e) {
			//	change_4 = true;
			//}

			//public void insertUpdate(DocumentEvent e) {
			//	change_4 = true;
			//}
		//});
		
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

		//class4Hours.addFocusListener(new FocusAdapter() {
			//public void focusGained(FocusEvent fEvt) {
			//	JTextField tField = (JTextField) fEvt.getSource();
			//	tField.selectAll();
			//}
		//});

		//class4Hours.getDocument().addDocumentListener(new DocumentListener() {
			//public void changedUpdate(DocumentEvent e) {
			//	change_12 = true;
			//}

			//public void removeUpdate(DocumentEvent e) {
			//	change_12 = true;
			//}

			//public void insertUpdate(DocumentEvent e) {
			//	change_12 = true;
			//}
		//});
		
		
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
		fillerClass5.addMouseListener(PopClickListener.createDialog(fillerClass5, "Class 5"));
		class5.add(fillerClass5);
		
		//fillerClass5.addFocusListener(new FocusAdapter() {
		//	public void focusGained(FocusEvent fEvt) {
			//	JTextField tField = (JTextField) fEvt.getSource();
			//	tField.selectAll();
			//}
		//});

		//fillerClass5.getDocument().addDocumentListener(new DocumentListener() {
		//	public void changedUpdate(DocumentEvent e) {
			//	change_5 = true;
			//}

			//public void removeUpdate(DocumentEvent e) {
			//	change_5 = true;
			//}

			//public void insertUpdate(DocumentEvent e) {
			//	change_5 = true;
			//}
		//});
		
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

		//class5Hours.addFocusListener(new FocusAdapter() {
			//public void focusGained(FocusEvent fEvt) {
			//	JTextField tField = (JTextField) fEvt.getSource();
			//	tField.selectAll();
			//}
		//});

		//class5Hours.getDocument().addDocumentListener(new DocumentListener() {
			//public void changedUpdate(DocumentEvent e) {
			//	change_13 = true;
			//}

			//public void removeUpdate(DocumentEvent e) {
			//	change_13 = true;
			//}

			//public void insertUpdate(DocumentEvent e) {
			//	change_13 = true;
			//}
		//});
		
		
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
		fillerClass6.addMouseListener(PopClickListener.createDialog(fillerClass6, "Class 6"));
		class6.add(fillerClass6);
		
		//fillerClass6.addFocusListener(new FocusAdapter() {
			//public void focusGained(FocusEvent fEvt) {
			//	JTextField tField = (JTextField) fEvt.getSource();
			//	tField.selectAll();
			//}
		//});

		//fillerClass6.getDocument().addDocumentListener(new DocumentListener() {
			//public void changedUpdate(DocumentEvent e) {
			//	change_6 = true;
			//}

			//public void removeUpdate(DocumentEvent e) {
			//	change_6 = true;
			//}

			//public void insertUpdate(DocumentEvent e) {
			//	change_6 = true;
			//}
		//});
		
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

		//class6Hours.addFocusListener(new FocusAdapter() {
		//	public void focusGained(FocusEvent fEvt) {
		//		JTextField tField = (JTextField) fEvt.getSource();
		//		tField.selectAll();
		//	}
		//});

		//class6Hours.getDocument().addDocumentListener(new DocumentListener() {
		//	public void changedUpdate(DocumentEvent e) {
		//		change_14 = true;
		//	}

		//	public void removeUpdate(DocumentEvent e) {
		//		change_14 = true;
		//	}

		//	public void insertUpdate(DocumentEvent e) {
		//		change_14 = true;
		//	}
		//});
		
		
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
		fillerClass7.addMouseListener(PopClickListener.createDialog(fillerClass7, "Class 7"));
		class7.add(fillerClass7);

		//fillerClass7.addFocusListener(new FocusAdapter() {
		//	public void focusGained(FocusEvent fEvt) {
			//	JTextField tField = (JTextField) fEvt.getSource();
		//		tField.selectAll();
		//	}
		//});

		//fillerClass7.getDocument().addDocumentListener(new DocumentListener() {
			//public void changedUpdate(DocumentEvent e) {
			//	change_7 = true;
			//}

			//public void removeUpdate(DocumentEvent e) {
			//	change_7 = true;
			//}

			//public void insertUpdate(DocumentEvent e) {
			//	change_7 = true;
			//}
		//});
		
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

		//class7Hours.addFocusListener(new FocusAdapter() {
			//public void focusGained(FocusEvent fEvt) {
				//JTextField tField = (JTextField) fEvt.getSource();
				//tField.selectAll();
			//}
		//});

		//class7Hours.getDocument().addDocumentListener(new DocumentListener() {
			//public void changedUpdate(DocumentEvent e) {
			//	change_15 = true;
			//}

			//public void removeUpdate(DocumentEvent e) {
			//	change_15 = true;
			//}

			//public void insertUpdate(DocumentEvent e) {
			//	change_15 = true;
			//}
		//});
		
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
		fillerClass8.addMouseListener(PopClickListener.createDialog(fillerClass8, "Class 8"));
		class8.add(fillerClass8);

		//fillerClass8.addFocusListener(new FocusAdapter() {
		//	public void focusGained(FocusEvent fEvt) {
		//		JTextField tField = (JTextField) fEvt.getSource();
		//		tField.selectAll();
		//	}
		//});

		//fillerClass8.getDocument().addDocumentListener(new DocumentListener() {
		//	public void changedUpdate(DocumentEvent e) {
		//		change_8 = true;
		//	}

		//	public void removeUpdate(DocumentEvent e) {
		//		change_8 = true;
		//	}

		//	public void insertUpdate(DocumentEvent e) {
		//		change_8 = true;
		//	}
		//});
		
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

		//class8Hours.addFocusListener(new FocusAdapter() {
		//	public void focusGained(FocusEvent fEvt) {
		//		JTextField tField = (JTextField) fEvt.getSource();
		//		tField.selectAll();
		//	}
		//});

		//class8Hours.getDocument().addDocumentListener(new DocumentListener() {
		//	public void changedUpdate(DocumentEvent e) {
		//		change_16 = true;
		//	}

		//	public void removeUpdate(DocumentEvent e) {
		//		change_16 = true;
		//	}

		//	public void insertUpdate(DocumentEvent e) {
		//		change_16 = true;
		//	}
		//});
		
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
		
		panel.add(class1);
		panel.add(class2);
		panel.add(class3);
		panel.add(class4);
		panel.add(class5);
		panel.add(class6);
		panel.add(class7);
		panel.add(class8);
		panel.add(addClass);
		
		container.add(semester);
		container.add(panel);
		container.add(gpaSemester);
		container.add(gpaTotal);

		return container;
	}
	
	protected static JComponent makeTextPanel3(String text) {
		//Font f1 = new Font("serif", Font.PLAIN, 36);
		//Font f2 = new Font("serif", Font.PLAIN, 24);
		//Border paddingBorder1 = BorderFactory.createEmptyBorder(10, 40, 10, 40);
		//Border paddingBorder2 = BorderFactory.createEmptyBorder(10, 600, 10, 40);
		//Border paddingBorder3 = BorderFactory.createEmptyBorder(10, 0, 10, 1435);

		//Border paddingBorder5 = BorderFactory.createEmptyBorder(10, 0, 10, 10);
		//Border paddingBorder6 = BorderFactory.createEmptyBorder(10, 1260, 10, 0);

		JPanel panel = new JPanel(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		//Create the nodes.
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(text);
        createNodes2(top);
 
        //Create a tree that allows one selection at a time.
        JTree tree = new JTree(top);
        tree.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);
 
        //Create the scroll pane and add the tree to it. 
        JScrollPane treeView = new JScrollPane(tree);
		panel.add(treeView);
		return panel;
	}

	private static JFrame frame;
	
	static void createAndShowGUI(String s) {
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
