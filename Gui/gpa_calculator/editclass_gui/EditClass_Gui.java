package gpa_calculator.editclass_gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import gpa_calculator.buttontabcomponents.ButtonTabComponent2;
import gpa_calculator.buttontabcomponents.ButtonTabComponent4;
import gpa_calculator.buttontabcomponents.ButtonTabComponent5;
import gpa_calculator.editsemester_gui.EditSemester_Gui;
import gpa_calculator.gpa_gui.GPA_Gui;
import gpa_calculator.popupmenus.PopClickListener2;

public class EditClass_Gui extends JPanel {
	private static JTabbedPane tabbedPane;
	private static JComponent pnlAll;
	private static JTabbedPane tabbedPane1;
	private static JTabbedPane tabbedPane3;
	static JComponent pnlInnerSemester;
	static JComponent pnlInnerSettings;
	static JComponent pnlSemester;
	static JComponent pnlSettings;
	static JComponent pnlTreeContainer;
	static JComponent pnlTree;
	
	public EditClass_Gui(String s) {
		super(new GridLayout(2, 1));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon.png")));
		Font f = new Font("serif", Font.PLAIN, 24);
		Dimension d1 = new Dimension(400, 800);
		Dimension d2 = new Dimension(900, 800);
		Dimension d3 = new Dimension(200, 800);
		Dimension d4 = new Dimension(1500, 800);
		tabbedPane1 = new JTabbedPane();
		tabbedPane1.setPreferredSize(d1);
		tabbedPane = new JTabbedPane();
		tabbedPane.setPreferredSize(d2);
		tabbedPane3 = new JTabbedPane();
		tabbedPane3.setPreferredSize(d3);
		// The following line enables to use scrolling tabs.
		tabbedPane1.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
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
		pnlSemester.add(tabbedPane);
		
		pnlInnerSemester = makeTextPanel2(s);
		tabbedPane.addTab(s, pnlInnerSemester);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);
		tabbedPane.setFont(f);
		
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
		tabbedPane1.setTabComponentAt(i, new ButtonTabComponent5(tabbedPane1));
	}
	
	private static void initTabComponent2(int i) {
		tabbedPane.setTabComponentAt(i, new ButtonTabComponent2(tabbedPane));
	}
	
	private static void initTabComponent3(int i) {
		tabbedPane3.setTabComponentAt(i, new ButtonTabComponent4(tabbedPane3));
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
		Font f1 = new Font("serif", Font.PLAIN, 36);
		Font f2 = new Font("serif", Font.PLAIN, 24);
		Dimension d1 = new Dimension(900, 800);
		Dimension d2 = new Dimension(900, 100);
		Dimension d3 = new Dimension(900, 500);
		Dimension d4 = new Dimension(900, 100);
		Dimension d5 = new Dimension(900, 100);
		
		Border paddingBorder1 = BorderFactory.createEmptyBorder(8, 0, 20, 0);
		Border paddingBorder2 = BorderFactory.createEmptyBorder(0, 0, 20, 0);
		Border paddingBorder3 = BorderFactory.createEmptyBorder(0, 0, 20, 670);
		Border paddingBorder4 = BorderFactory.createEmptyBorder(0, 700, 0, 0);
		
		JPanel container = new JPanel(false);
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.setPreferredSize(d1);
		
		JPanel pnlClass = new JPanel();
		pnlClass.setPreferredSize(d2);
		
		JLabel lblClass = new JLabel(text);
		lblClass.setFont(f2);
		pnlClass.add(lblClass);
		
		JPanel panel = new JPanel(false);
		panel.setLayout(new GridLayout(7, 4));
		panel.setPreferredSize(d3);

		//JPanel pnlDelete = new JPanel();
		//pnlDelete.setLayout(new BoxLayout(pnlDelete, BoxLayout.Y_AXIS));
		
		//JPanel pnlGradeTypes = new JPanel();
		//pnlGradeTypes.setLayout(new BoxLayout(pnlGradeTypes, BoxLayout.Y_AXIS));
		
		JPanel pnlAdd = new JPanel();
		pnlAdd.setLayout(new BoxLayout(pnlAdd, BoxLayout.X_AXIS));
		pnlAdd.setPreferredSize(d4);
		
		JPanel pnlGPA = new JPanel();
		pnlGPA.setLayout(new BoxLayout(pnlGPA, BoxLayout.X_AXIS));
		pnlGPA.setPreferredSize(d5);
		
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

		JLabel fillerClass = new JLabel(text);
		fillerClass.setFont(f1);
		//pnlClass.add(fillerClass);
		
		JButton btnDeleteParticipation = new JButton(new ImageIcon(buttonIcon2));
		btnDeleteParticipation.setBorder(paddingBorder1);
		btnDeleteParticipation.setContentAreaFilled(false);
		//pnlDelete.add(btnDeleteParticipation);
		
		JButton btnDeleteHomework = new JButton(new ImageIcon(buttonIcon2));
		btnDeleteHomework.setBorder(paddingBorder1);
		btnDeleteHomework.setContentAreaFilled(false);
		//pnlDelete.add(btnDeleteHomework);
		
		JButton btnDeleteLabs = new JButton(new ImageIcon(buttonIcon2));
		btnDeleteLabs.setBorder(paddingBorder1);
		btnDeleteLabs.setContentAreaFilled(false);
		//pnlDelete.add(btnDeleteLabs);
		
		JButton btnDeletePapers = new JButton(new ImageIcon(buttonIcon2));
		btnDeletePapers.setBorder(paddingBorder1);
		btnDeletePapers.setContentAreaFilled(false);
		
		JButton btnDeleteQuizzes = new JButton(new ImageIcon(buttonIcon2));
		btnDeleteQuizzes.setBorder(paddingBorder1);
		btnDeleteQuizzes.setContentAreaFilled(false);
		
		JButton btnDeleteMidterms = new JButton(new ImageIcon(buttonIcon2));
		btnDeleteMidterms.setBorder(paddingBorder1);
		btnDeleteMidterms.setContentAreaFilled(false);
		
		JButton btnDeleteFinalExam = new JButton(new ImageIcon(buttonIcon2));
		btnDeleteFinalExam.setBorder(paddingBorder1);
		btnDeleteFinalExam.setContentAreaFilled(false);
		
		JLabel fillerParticipation = new JLabel("Participation:");
		fillerParticipation.setFont(f2);
		fillerParticipation.setBorder(paddingBorder2);
		fillerParticipation.addMouseListener(PopClickListener2.createDialog(fillerParticipation, text + ": Participation Grades"));
		//pnlGradeTypes.add(fillerParticipation);
		
		JLabel fillerHomework = new JLabel("Homework:");
		fillerHomework.setFont(f2);
		fillerHomework.setBorder(paddingBorder2);
		fillerHomework.addMouseListener(PopClickListener2.createDialog(fillerHomework, text + ": Homework Grades"));
		//pnlGradeTypes.add(fillerHomework);

		JLabel fillerLabs = new JLabel("Labs:");
		fillerLabs.setFont(f2);
		fillerLabs.setBorder(paddingBorder2);
		fillerLabs.addMouseListener(PopClickListener2.createDialog(fillerLabs, text + ": Lab Grades"));
		//pnlGradeTypes.add(fillerLabs);
		
		JLabel fillerPapers = new JLabel("Papers:");
		fillerPapers.setFont(f2);
		fillerPapers.setBorder(paddingBorder2);
		fillerPapers.addMouseListener(PopClickListener2.createDialog(fillerPapers, text + ": Paper Grades"));
		
		JLabel fillerQuizzes = new JLabel("Quizzes:");
		fillerQuizzes.setFont(f2);
		fillerQuizzes.setBorder(paddingBorder2);
		fillerQuizzes.addMouseListener(PopClickListener2.createDialog(fillerQuizzes, text + ": Quiz Grades"));
		
		JLabel fillerMidterms = new JLabel("Midterms:");
		fillerMidterms.setFont(f2);
		fillerMidterms.setBorder(paddingBorder2);
		fillerMidterms.addMouseListener(PopClickListener2.createDialog(fillerMidterms, text + ": Midterm Grades"));
		
		JLabel fillerFinalExam = new JLabel("Final Exam:");
		fillerFinalExam.setFont(f2);
		fillerFinalExam.setBorder(paddingBorder2);
		fillerFinalExam.addMouseListener(PopClickListener2.createDialog(fillerHomework, text + ": Final Exam Grade"));
		
		JLabel fillerParticipationGrade = new JLabel("Grade: 0");
		fillerParticipationGrade.setFont(f2);
		fillerParticipationGrade.setBorder(paddingBorder2);
		fillerParticipationGrade.addMouseListener(PopClickListener2.createDialog(fillerParticipationGrade, text + ": Participation Grades"));
		
		JLabel fillerHomeworkGrade = new JLabel("Grade: 0");
		fillerHomeworkGrade.setFont(f2);
		fillerHomeworkGrade.setBorder(paddingBorder2);
		fillerHomeworkGrade.addMouseListener(PopClickListener2.createDialog(fillerHomeworkGrade, text + ": Homework Grades"));
		
		JLabel fillerLabsGrade = new JLabel("Grade: 0");
		fillerLabsGrade.setFont(f2);
		fillerLabsGrade.setBorder(paddingBorder2);
		fillerLabsGrade.addMouseListener(PopClickListener2.createDialog(fillerLabsGrade, text + ": Lab Grades"));
		
		JLabel fillerPapersGrade = new JLabel("Grade: 0");
		fillerPapersGrade.setFont(f2);
		fillerPapersGrade.setBorder(paddingBorder2);
		fillerPapersGrade.addMouseListener(PopClickListener2.createDialog(fillerPapersGrade, text + ": Papers Grades"));
		
		JLabel fillerQuizzesGrade = new JLabel("Grade: 0");
		fillerQuizzesGrade.setFont(f2);
		fillerQuizzesGrade.setBorder(paddingBorder2);
		fillerQuizzesGrade.addMouseListener(PopClickListener2.createDialog(fillerQuizzesGrade, text + ": Quiz Grades"));
		
		JLabel fillerMidtermsGrade = new JLabel("Grade: 0");
		fillerMidtermsGrade.setFont(f2);
		fillerMidtermsGrade.setBorder(paddingBorder2);
		fillerMidtermsGrade.addMouseListener(PopClickListener2.createDialog(fillerMidtermsGrade, text + ": Midterm Grades"));
		
		JLabel fillerFinalExamGrade = new JLabel("Grade: 0");
		fillerFinalExamGrade.setFont(f2);
		fillerFinalExamGrade.setBorder(paddingBorder2);
		fillerFinalExamGrade.addMouseListener(PopClickListener2.createDialog(fillerFinalExamGrade, text + ": Final Exam Grade"));
		
		JLabel fillerParticipationWeight = new JLabel("Weight: 0%");
		fillerParticipationWeight.setFont(f2);
		fillerParticipationWeight.setBorder(paddingBorder2);
		fillerParticipationWeight.addMouseListener(PopClickListener2.createDialog(fillerParticipationWeight, text + ": Participation Weight"));
		
		JLabel fillerHomeworkWeight = new JLabel("Weight: 0%");
		fillerHomeworkWeight.setFont(f2);
		fillerHomeworkWeight.setBorder(paddingBorder2);
		fillerHomeworkWeight.addMouseListener(PopClickListener2.createDialog(fillerHomeworkWeight, text + ": Homework Weight"));
		
		JLabel fillerLabsWeight = new JLabel("Weight: 0%");
		fillerLabsWeight.setFont(f2);
		fillerLabsWeight.setBorder(paddingBorder2);
		fillerLabsWeight.addMouseListener(PopClickListener2.createDialog(fillerLabsWeight, text + ": Lab Weight"));
		
		JLabel fillerPapersWeight = new JLabel("Weight: 0%");
		fillerPapersWeight.setFont(f2);
		fillerPapersWeight.setBorder(paddingBorder2);
		fillerPapersWeight.addMouseListener(PopClickListener2.createDialog(fillerPapersWeight, text + ": Papers Weight"));
		
		JLabel fillerQuizzesWeight = new JLabel("Weight: 0%");
		fillerQuizzesWeight.setFont(f2);
		fillerQuizzesWeight.setBorder(paddingBorder2);
		fillerQuizzesWeight.addMouseListener(PopClickListener2.createDialog(fillerQuizzesWeight, text + ": Quiz Weight"));
		
		JLabel fillerMidtermsWeight = new JLabel("Weight: 0%");
		fillerMidtermsWeight.setFont(f2);
		fillerMidtermsWeight.setBorder(paddingBorder2);
		fillerMidtermsWeight.addMouseListener(PopClickListener2.createDialog(fillerMidtermsWeight, text + ": Midterm Weight"));
		
		JLabel fillerFinalExamWeight = new JLabel("Weight: 0%");
		fillerFinalExamWeight.setFont(f2);
		fillerFinalExamWeight.setBorder(paddingBorder2);
		fillerFinalExamWeight.addMouseListener(PopClickListener2.createDialog(fillerFinalExamWeight, text + ": Final Exam Weight"));
		
		JButton btnAddGrade = new JButton(new ImageIcon(buttonIcon4));
		btnAddGrade.setBorder(paddingBorder3);
		btnAddGrade.setContentAreaFilled(false);
		pnlAdd.add(btnAddGrade);
		
		JLabel totalGPA = new JLabel("Total GPA: 0.00");
		totalGPA.setBorder(paddingBorder4);
		totalGPA.setFont(f2);
		pnlGPA.add(totalGPA);
		
		//panel.add(pnlDelete);
		//panel.add(pnlGradeTypes);
		
		panel.add(btnDeleteParticipation);
		panel.add(fillerParticipation);
		panel.add(fillerParticipationGrade);
		panel.add(fillerParticipationWeight);
		
		panel.add(btnDeleteHomework);
		panel.add(fillerHomework);
		panel.add(fillerHomeworkGrade);
		panel.add(fillerHomeworkWeight);
		
		panel.add(btnDeleteLabs);
		panel.add(fillerLabs);
		panel.add(fillerLabsGrade);
		panel.add(fillerLabsWeight);
		
		panel.add(btnDeletePapers);
		panel.add(fillerPapers);
		panel.add(fillerPapersGrade);
		panel.add(fillerPapersWeight);
		
		panel.add(btnDeleteQuizzes);
		panel.add(fillerQuizzes);
		panel.add(fillerQuizzesGrade);
		panel.add(fillerQuizzesWeight);
		
		panel.add(btnDeleteMidterms);
		panel.add(fillerMidterms);
		panel.add(fillerMidtermsGrade);
		panel.add(fillerMidtermsWeight);
		
		panel.add(btnDeleteFinalExam);
		panel.add(fillerFinalExam);
		panel.add(fillerFinalExamGrade);
		panel.add(fillerFinalExamWeight);
		
		container.add(pnlClass);
		container.add(panel);
		container.add(pnlAdd);
		container.add(pnlGPA);
		
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

	private static JFrame frame;
	static String s2;
	
	public static void createAndShowGUI(String s) {
		// Create and set up the window.
		frame = new JFrame("GPA Calculator - Edit Class");
		s2 = s;
		// Initialize MenuBar
		JMenuBar menuBar;

		// Initialize Menus
		JMenu menuFile;
		JMenu menuNew;
		
		JMenu menuEdit;
		JMenu menuEditSemester;

		JMenu menuView;
		JMenu menuShowView;
		JMenu menuSemesterSettingsView;
		JMenu menuSemester1ClassSettingView;
		JMenu menuSemester2ClassSettingView;
		JMenu menuSemester3ClassSettingView;
		JMenu menuSemester4ClassSettingView;
		JMenu menuSemester5ClassSettingView;
		JMenu menuSemester6ClassSettingView;
		JMenu menuSemester7ClassSettingView;
		JMenu menuSemester8ClassSettingView;
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
		JMenuItem menuItemStudentTreeView;
		JMenuItem menuItemSemester1Class1SettingsView;
		JMenuItem menuItemSemester1Class2SettingsView;
		JMenuItem menuItemSemester1Class3SettingsView;
		JMenuItem menuItemSemester1Class4SettingsView;
		JMenuItem menuItemSemester1Class5SettingsView;
		JMenuItem menuItemSemester1Class6SettingsView;
		JMenuItem menuItemSemester1Class7SettingsView;
		JMenuItem menuItemSemester1Class8SettingsView;		
		JMenuItem menuItemSemester2Class1SettingsView;
		JMenuItem menuItemSemester2Class2SettingsView;
		JMenuItem menuItemSemester2Class3SettingsView;
		JMenuItem menuItemSemester2Class4SettingsView;
		JMenuItem menuItemSemester2Class5SettingsView;
		JMenuItem menuItemSemester2Class6SettingsView;
		JMenuItem menuItemSemester2Class7SettingsView;
		JMenuItem menuItemSemester2Class8SettingsView;		
		JMenuItem menuItemSemester3Class1SettingsView;
		JMenuItem menuItemSemester3Class2SettingsView;
		JMenuItem menuItemSemester3Class3SettingsView;
		JMenuItem menuItemSemester3Class4SettingsView;
		JMenuItem menuItemSemester3Class5SettingsView;
		JMenuItem menuItemSemester3Class6SettingsView;
		JMenuItem menuItemSemester3Class7SettingsView;
		JMenuItem menuItemSemester3Class8SettingsView;		
		JMenuItem menuItemSemester4Class1SettingsView;
		JMenuItem menuItemSemester4Class2SettingsView;
		JMenuItem menuItemSemester4Class3SettingsView;
		JMenuItem menuItemSemester4Class4SettingsView;
		JMenuItem menuItemSemester4Class5SettingsView;
		JMenuItem menuItemSemester4Class6SettingsView;
		JMenuItem menuItemSemester4Class7SettingsView;
		JMenuItem menuItemSemester4Class8SettingsView;	
		JMenuItem menuItemSemester5Class1SettingsView;
		JMenuItem menuItemSemester5Class2SettingsView;
		JMenuItem menuItemSemester5Class3SettingsView;
		JMenuItem menuItemSemester5Class4SettingsView;
		JMenuItem menuItemSemester5Class5SettingsView;
		JMenuItem menuItemSemester5Class6SettingsView;
		JMenuItem menuItemSemester5Class7SettingsView;
		JMenuItem menuItemSemester5Class8SettingsView;		
		JMenuItem menuItemSemester6Class1SettingsView;
		JMenuItem menuItemSemester6Class2SettingsView;
		JMenuItem menuItemSemester6Class3SettingsView;
		JMenuItem menuItemSemester6Class4SettingsView;
		JMenuItem menuItemSemester6Class5SettingsView;
		JMenuItem menuItemSemester6Class6SettingsView;
		JMenuItem menuItemSemester6Class7SettingsView;
		JMenuItem menuItemSemester6Class8SettingsView;		
		JMenuItem menuItemSemester7Class1SettingsView;
		JMenuItem menuItemSemester7Class2SettingsView;
		JMenuItem menuItemSemester7Class3SettingsView;
		JMenuItem menuItemSemester7Class4SettingsView;
		JMenuItem menuItemSemester7Class5SettingsView;
		JMenuItem menuItemSemester7Class6SettingsView;
		JMenuItem menuItemSemester7Class7SettingsView;
		JMenuItem menuItemSemester7Class8SettingsView;	
		JMenuItem menuItemSemester8Class1SettingsView;
		JMenuItem menuItemSemester8Class2SettingsView;
		JMenuItem menuItemSemester8Class3SettingsView;
		JMenuItem menuItemSemester8Class4SettingsView;
		JMenuItem menuItemSemester8Class5SettingsView;
		JMenuItem menuItemSemester8Class6SettingsView;
		JMenuItem menuItemSemester8Class7SettingsView;
		JMenuItem menuItemSemester8Class8SettingsView;

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = frame.getContentPane();
		// adjust to need.
		Dimension d = new Dimension(1500, 800);
		c.setPreferredSize(d);
		// Add content to the window.
		frame.add(new EditClass_Gui(s), BorderLayout.NORTH);

		Font fmenu = new Font("sans-serif", Font.PLAIN, 12);
		UIManager.put("Menu.font", fmenu);
		UIManager.put("MenuItem.font", fmenu);
		menuBar = new JMenuBar();
		
		menuFile = new JMenu("File");
		menuNew = new JMenu("New");
		menuEdit = new JMenu("Edit");
		menuView = new JMenu("View");
		menuShowView = new JMenu("Show View");
		menuSemesterSettingsView = new JMenu("Class Settings View");
		menuSemester1ClassSettingView = new JMenu("Semester 1");
		menuSemester2ClassSettingView = new JMenu("Semester 2");
		menuSemester3ClassSettingView = new JMenu("Semester 3");
		menuSemester4ClassSettingView = new JMenu("Semester 4");
		menuSemester5ClassSettingView = new JMenu("Semester 5");
		menuSemester6ClassSettingView = new JMenu("Semester 6");
		menuSemester7ClassSettingView = new JMenu("Semester 7");
		menuSemester8ClassSettingView = new JMenu("Semester 8");
		
		menuItemStudentView = new JMenuItem("Student View");
		menuItemStudentView.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		menuItemStudentView.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent){
				GPA_Gui.makeVisible();
				makeInvisible();
			}
		});
		
		menuItemSemesterView = new JMenuItem("Semester View");
		menuItemSemesterView.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		menuItemSemesterView.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent){
				EditSemester_Gui.makeVisible();
				makeInvisible();
			}
		});
		
		menuItemClassView = new JMenuItem("Class View");
		menuItemClassView.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		menuItemClassView.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent){
				
			}
		});
		
		menuItemStudentTreeView = new JMenuItem("Student Tree View");
		menuItemStudentTreeView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent){
				
			}
		});
		
		menuItemSemester1Class1SettingsView = new JMenuItem("Class 1 Settings");
		menuItemSemester1Class1SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings1 = makeTextPanel1("Semester 1 Class 1 Settings");
				tabbedPane1.addTab("Semester 1 Class 1 Settings", pnlSettings1);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester1Class2SettingsView = new JMenuItem("Class 2 Settings");
		menuItemSemester1Class2SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings2 = makeTextPanel1("Semester 1 Class 2 Settings");
				tabbedPane1.addTab("Semester 1 Class 2 Settings", pnlSettings2);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester1Class3SettingsView = new JMenuItem("Class 3 Settings");
		menuItemSemester1Class3SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings3 = makeTextPanel1("Semester 1 Class 3 Settings");
				tabbedPane1.addTab("Semester 1 Class 3 Settings", pnlSettings3);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester1Class4SettingsView = new JMenuItem("Class 4 Settings");
		menuItemSemester1Class4SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings4 = makeTextPanel1("Semester 1 Class 4 Settings");
				tabbedPane1.addTab("Semester 1 Class 4 Settings", pnlSettings4);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester1Class5SettingsView = new JMenuItem("Class 5 Settings");
		menuItemSemester1Class5SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings5 = makeTextPanel1("Semester 1 Class 5 Settings");
				tabbedPane1.addTab("Semester 1 Class 5 Settings", pnlSettings5);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester1Class6SettingsView = new JMenuItem("Class 6 Settings");
		menuItemSemester1Class6SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings6 = makeTextPanel1("Semester 1 Class 6 Settings");
				tabbedPane1.addTab("Semester 1 Class 6 Settings", pnlSettings6);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester1Class7SettingsView = new JMenuItem("Class 7 Settings");
		menuItemSemester1Class7SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings7 = makeTextPanel1("Semester 1 Class 7 Settings");
				tabbedPane1.addTab("Semester 1 Class 7 Settings", pnlSettings7);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester1Class8SettingsView = new JMenuItem("Class 8 Settings");
		menuItemSemester1Class8SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings8 = makeTextPanel1("Semester 1 Class 8 Settings");
				tabbedPane1.addTab("Semester 1 Class 8 Settings", pnlSettings8);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester2Class1SettingsView = new JMenuItem("Class 1 Settings");
		menuItemSemester2Class1SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings1 = makeTextPanel1("Semester 2 Class 1 Settings");
				tabbedPane1.addTab("Semester 2 Class 1 Settings", pnlSettings1);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester2Class2SettingsView = new JMenuItem("Class 2 Settings");
		menuItemSemester2Class2SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings2 = makeTextPanel1("Semester 2 Class 2 Settings");
				tabbedPane1.addTab("Semester 2 Class 2 Settings", pnlSettings2);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester2Class3SettingsView = new JMenuItem("Class 3 Settings");
		menuItemSemester2Class3SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings3 = makeTextPanel1("Semester 2 Class 3 Settings");
				tabbedPane1.addTab("Semester 2 Class 3 Settings", pnlSettings3);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester2Class4SettingsView = new JMenuItem("Class 4 Settings");
		menuItemSemester2Class4SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings4 = makeTextPanel1("Semester 2 Class 4 Settings");
				tabbedPane1.addTab("Semester 2 Class 4 Settings", pnlSettings4);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester2Class5SettingsView = new JMenuItem("Class 5 Settings");
		menuItemSemester2Class5SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings5 = makeTextPanel1("Semester 2 Class 5 Settings");
				tabbedPane1.addTab("Semester 2 Class 5 Settings", pnlSettings5);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester2Class6SettingsView = new JMenuItem("Class 6 Settings");
		menuItemSemester2Class6SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings6 = makeTextPanel1("Semester 2 Class 6 Settings");
				tabbedPane1.addTab("Semester 2 Class 6 Settings", pnlSettings6);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester2Class7SettingsView = new JMenuItem("Class 7 Settings");
		menuItemSemester2Class7SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings7 = makeTextPanel1("Semester 2 Class 7 Settings");
				tabbedPane1.addTab("Semester 2 Class 7 Settings", pnlSettings7);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester2Class8SettingsView = new JMenuItem("Class 8 Settings");
		menuItemSemester2Class8SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings8 = makeTextPanel1("Semester 2 Class 8 Settings");
				tabbedPane1.addTab("Semester 2 Class 8 Settings", pnlSettings8);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester3Class1SettingsView = new JMenuItem("Class 1 Settings");
		menuItemSemester3Class1SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings1 = makeTextPanel1("Semester 3 Class 1 Settings");
				tabbedPane1.addTab("Semester 3 Class 1 Settings", pnlSettings1);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester3Class2SettingsView = new JMenuItem("Class 2 Settings");
		menuItemSemester3Class2SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings2 = makeTextPanel1("Semester 3 Class 2 Settings");
				tabbedPane1.addTab("Semester 3 Class 2 Settings", pnlSettings2);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester3Class3SettingsView = new JMenuItem("Class 3 Settings");
		menuItemSemester3Class3SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings3 = makeTextPanel1("Semester 3 Class 3 Settings");
				tabbedPane1.addTab("Semester 3 Class 3 Settings", pnlSettings3);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester3Class4SettingsView = new JMenuItem("Class 4 Settings");
		menuItemSemester3Class4SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings4 = makeTextPanel1("Semester 3 Class 4 Settings");
				tabbedPane1.addTab("Semester 3 Class 4 Settings", pnlSettings4);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester3Class5SettingsView = new JMenuItem("Class 5 Settings");
		menuItemSemester3Class5SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings5 = makeTextPanel1("Semester 3 Class 5 Settings");
				tabbedPane1.addTab("Semester 3 Class 5 Settings", pnlSettings5);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester3Class6SettingsView = new JMenuItem("Class 6 Settings");
		menuItemSemester3Class6SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings6 = makeTextPanel1("Semester 3 Class 6 Settings");
				tabbedPane1.addTab("Semester 3 Class 6 Settings", pnlSettings6);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester3Class7SettingsView = new JMenuItem("Class 7 Settings");
		menuItemSemester3Class7SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings7 = makeTextPanel1("Semester 3 Class 7 Settings");
				tabbedPane1.addTab("Semester 3 Class 7 Settings", pnlSettings7);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester3Class8SettingsView = new JMenuItem("Class 8 Settings");
		menuItemSemester3Class8SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings8 = makeTextPanel1("Semester 3 Class 8 Settings");
				tabbedPane1.addTab("Semester 3 Class 8 Settings", pnlSettings8);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester4Class1SettingsView = new JMenuItem("Class 1 Settings");
		menuItemSemester4Class1SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings1 = makeTextPanel1("Semester 4 Class 1 Settings");
				tabbedPane1.addTab("Semester 4 Class 1 Settings", pnlSettings1);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester4Class2SettingsView = new JMenuItem("Class 2 Settings");
		menuItemSemester4Class2SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings2 = makeTextPanel1("Semester 4 Class 2 Settings");
				tabbedPane1.addTab("Semester 4 Class 2 Settings", pnlSettings2);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester4Class3SettingsView = new JMenuItem("Class 3 Settings");
		menuItemSemester4Class3SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings3 = makeTextPanel1("Semester 4 Class 3 Settings");
				tabbedPane1.addTab("Semester 4 Class 3 Settings", pnlSettings3);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester4Class4SettingsView = new JMenuItem("Class 4 Settings");
		menuItemSemester4Class4SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings4 = makeTextPanel1("Semester 4 Class 4 Settings");
				tabbedPane1.addTab("Semester 4 Class 4 Settings", pnlSettings4);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester4Class5SettingsView = new JMenuItem("Class 5 Settings");
		menuItemSemester4Class5SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings5 = makeTextPanel1("Semester 4 Class 5 Settings");
				tabbedPane1.addTab("Semester 4 Class 5 Settings", pnlSettings5);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester4Class6SettingsView = new JMenuItem("Class 6 Settings");
		menuItemSemester4Class6SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings6 = makeTextPanel1("Semester 4 Class 6 Settings");
				tabbedPane1.addTab("Semester 4 Class 6 Settings", pnlSettings6);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester4Class7SettingsView = new JMenuItem("Class 7 Settings");
		menuItemSemester4Class7SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings7 = makeTextPanel1("Semester 4 Class 7 Settings");
				tabbedPane1.addTab("Semester 4 Class 7 Settings", pnlSettings7);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester4Class8SettingsView = new JMenuItem("Class 8 Settings");
		menuItemSemester4Class8SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings8 = makeTextPanel1("Semester 4 Class 8 Settings");
				tabbedPane1.addTab("Semester 4 Class 8 Settings", pnlSettings8);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester5Class1SettingsView = new JMenuItem("Class 1 Settings");
		menuItemSemester5Class1SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings1 = makeTextPanel1("Semester 5 Class 1 Settings");
				tabbedPane1.addTab("Semester 5 Class 1 Settings", pnlSettings1);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester5Class2SettingsView = new JMenuItem("Class 2 Settings");
		menuItemSemester5Class2SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings2 = makeTextPanel1("Semester 5 Class 2 Settings");
				tabbedPane1.addTab("Semester 5 Class 2 Settings", pnlSettings2);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester5Class3SettingsView = new JMenuItem("Class 3 Settings");
		menuItemSemester5Class3SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings3 = makeTextPanel1("Semester 5 Class 3 Settings");
				tabbedPane1.addTab("Semester 5 Class 3 Settings", pnlSettings3);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester5Class4SettingsView = new JMenuItem("Class 4 Settings");
		menuItemSemester5Class4SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings4 = makeTextPanel1("Semester 5 Class 4 Settings");
				tabbedPane1.addTab("Semester 5 Class 4 Settings", pnlSettings4);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester5Class5SettingsView = new JMenuItem("Class 5 Settings");
		menuItemSemester5Class5SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings5 = makeTextPanel1("Semester 5 Class 5 Settings");
				tabbedPane1.addTab("Semester 5 Class 5 Settings", pnlSettings5);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester5Class6SettingsView = new JMenuItem("Class 6 Settings");
		menuItemSemester5Class6SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings6 = makeTextPanel1("Semester 5 Class 6 Settings");
				tabbedPane1.addTab("Semester 5 Class 6 Settings", pnlSettings6);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester5Class7SettingsView = new JMenuItem("Class 7 Settings");
		menuItemSemester5Class7SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings7 = makeTextPanel1("Semester 5 Class 7 Settings");
				tabbedPane1.addTab("Semester 5 Class 7 Settings", pnlSettings7);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester5Class8SettingsView = new JMenuItem("Class 8 Settings");
		menuItemSemester5Class8SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings8 = makeTextPanel1("Semester 5 Class 8 Settings");
				tabbedPane1.addTab("Semester 5 Class 8 Settings", pnlSettings8);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester6Class1SettingsView = new JMenuItem("Class 1 Settings");
		menuItemSemester6Class1SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings1 = makeTextPanel1("Semester 6 Class 1 Settings");
				tabbedPane1.addTab("Semester 6 Class 1 Settings", pnlSettings1);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester6Class2SettingsView = new JMenuItem("Class 2 Settings");
		menuItemSemester6Class2SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings2 = makeTextPanel1("Semester 6 Class 2 Settings");
				tabbedPane1.addTab("Semester 6 Class 2 Settings", pnlSettings2);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester6Class3SettingsView = new JMenuItem("Class 3 Settings");
		menuItemSemester6Class3SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings3 = makeTextPanel1("Semester 6 Class 3 Settings");
				tabbedPane1.addTab("Semester 6 Class 3 Settings", pnlSettings3);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester6Class4SettingsView = new JMenuItem("Class 4 Settings");
		menuItemSemester6Class4SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings4 = makeTextPanel1("Semester 6 Class 4 Settings");
				tabbedPane1.addTab("Semester 6 Class 4 Settings", pnlSettings4);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester6Class5SettingsView = new JMenuItem("Class 5 Settings");
		menuItemSemester6Class5SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings5 = makeTextPanel1("Semester 6 Class 5 Settings");
				tabbedPane1.addTab("Semester 6 Class 5 Settings", pnlSettings5);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester6Class6SettingsView = new JMenuItem("Class 6 Settings");
		menuItemSemester6Class6SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings6 = makeTextPanel1("Semester 6 Class 6 Settings");
				tabbedPane1.addTab("Semester 6 Class 6 Settings", pnlSettings6);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester6Class7SettingsView = new JMenuItem("Class 7 Settings");
		menuItemSemester6Class7SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings7 = makeTextPanel1("Semester 6 Class 7 Settings");
				tabbedPane1.addTab("Semester 6 Class 7 Settings", pnlSettings7);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester6Class8SettingsView = new JMenuItem("Class 8 Settings");
		menuItemSemester6Class8SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings8 = makeTextPanel1("Semester 6 Class 8 Settings");
				tabbedPane1.addTab("Semester 6 Class 8 Settings", pnlSettings8);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester7Class1SettingsView = new JMenuItem("Class 1 Settings");
		menuItemSemester7Class1SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings1 = makeTextPanel1("Semester 7 Class 1 Settings");
				tabbedPane1.addTab("Semester 7 Class 1 Settings", pnlSettings1);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester7Class2SettingsView = new JMenuItem("Class 2 Settings");
		menuItemSemester7Class2SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings2 = makeTextPanel1("Semester 7 Class 2 Settings");
				tabbedPane1.addTab("Semester 7 Class 2 Settings", pnlSettings2);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester7Class3SettingsView = new JMenuItem("Class 3 Settings");
		menuItemSemester7Class3SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings3 = makeTextPanel1("Semester 7 Class 3 Settings");
				tabbedPane1.addTab("Semester 7 Class 3 Settings", pnlSettings3);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester7Class4SettingsView = new JMenuItem("Class 4 Settings");
		menuItemSemester7Class4SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings4 = makeTextPanel1("Semester 7 Class 4 Settings");
				tabbedPane1.addTab("Semester 7 Class 4 Settings", pnlSettings4);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester7Class5SettingsView = new JMenuItem("Class 5 Settings");
		menuItemSemester7Class5SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings5 = makeTextPanel1("Semester 7 Class 5 Settings");
				tabbedPane1.addTab("Semester 7 Class 5 Settings", pnlSettings5);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester7Class6SettingsView = new JMenuItem("Class 6 Settings");
		menuItemSemester7Class6SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings6 = makeTextPanel1("Semester 7 Class 6 Settings");
				tabbedPane1.addTab("Semester 7 Class 6 Settings", pnlSettings6);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester7Class7SettingsView = new JMenuItem("Class 7 Settings");
		menuItemSemester7Class7SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings7 = makeTextPanel1("Semester 7 Class 7 Settings");
				tabbedPane1.addTab("Semester 7 Class 7 Settings", pnlSettings7);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester7Class8SettingsView = new JMenuItem("Class 8 Settings");
		menuItemSemester7Class8SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings8 = makeTextPanel1("Semester 7 Class 8 Settings");
				tabbedPane1.addTab("Semester 7 Class 8 Settings", pnlSettings8);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester8Class1SettingsView = new JMenuItem("Class 1 Settings");
		menuItemSemester8Class1SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings1 = makeTextPanel1("Semester 8 Class 1 Settings");
				tabbedPane1.addTab("Semester 8 Class 1 Settings", pnlSettings1);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester8Class2SettingsView = new JMenuItem("Class 2 Settings");
		menuItemSemester8Class2SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings2 = makeTextPanel1("Semester 8 Class 2 Settings");
				tabbedPane1.addTab("Semester 8 Class 2 Settings", pnlSettings2);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester8Class3SettingsView = new JMenuItem("Class 3 Settings");
		menuItemSemester8Class3SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings3 = makeTextPanel1("Semester 8 Class 3 Settings");
				tabbedPane1.addTab("Semester 8 Class 3 Settings", pnlSettings3);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester8Class4SettingsView = new JMenuItem("Class 4 Settings");
		menuItemSemester8Class4SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings4 = makeTextPanel1("Semester 8 Class 4 Settings");
				tabbedPane1.addTab("Semester 8 Class 4 Settings", pnlSettings4);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester8Class5SettingsView = new JMenuItem("Class 5 Settings");
		menuItemSemester8Class5SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings5 = makeTextPanel1("Semester 8 Class 5 Settings");
				tabbedPane1.addTab("Semester 8 Class 5 Settings", pnlSettings5);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester8Class6SettingsView = new JMenuItem("Class 6 Settings");
		menuItemSemester8Class6SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings6 = makeTextPanel1("Semester 8 Class 6 Settings");
				tabbedPane1.addTab("Semester 8 Class 6 Settings", pnlSettings6);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester8Class7SettingsView = new JMenuItem("Class 7 Settings");
		menuItemSemester8Class7SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings7 = makeTextPanel1("Semester 8 Class 7 Settings");
				tabbedPane1.addTab("Semester 8 Class 7 Settings", pnlSettings7);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuItemSemester8Class8SettingsView = new JMenuItem("Class 8 Settings");
		menuItemSemester8Class8SettingsView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Font f = new Font("serif", Font.PLAIN, 24);
				JComponent pnlSettings8 = makeTextPanel1("Semester 8 Class 8 Settings");
				tabbedPane1.addTab("Semester 8 Class 8 Settings", pnlSettings8);
				tabbedPane1.setFont(f);
				initTabComponent(tabbedPane1.getTabCount() - 1);
			}
		});
		
		menuBar.add(menuFile);
		menuFile.add(menuNew);
		menuBar.add(menuEdit);
		menuBar.add(menuView);
		
		menuView.add(menuItemStudentView);
		menuView.add(menuItemSemesterView);
		menuView.add(menuItemClassView);
		menuView.addSeparator();
		menuView.add(menuShowView);
		
		menuShowView.add(menuItemStudentTreeView);
		menuShowView.add(menuSemesterSettingsView);
		
		menuSemesterSettingsView.add(menuSemester1ClassSettingView);
		menuSemesterSettingsView.add(menuSemester2ClassSettingView);
		menuSemesterSettingsView.add(menuSemester3ClassSettingView);
		menuSemesterSettingsView.add(menuSemester4ClassSettingView);
		menuSemesterSettingsView.add(menuSemester5ClassSettingView);
		menuSemesterSettingsView.add(menuSemester6ClassSettingView);
		menuSemesterSettingsView.add(menuSemester7ClassSettingView);
		menuSemesterSettingsView.add(menuSemester8ClassSettingView);
		
		menuSemester1ClassSettingView.add(menuItemSemester1Class1SettingsView);
		menuSemester1ClassSettingView.add(menuItemSemester1Class2SettingsView);
		menuSemester1ClassSettingView.add(menuItemSemester1Class3SettingsView);
		menuSemester1ClassSettingView.add(menuItemSemester1Class4SettingsView);
		menuSemester1ClassSettingView.add(menuItemSemester1Class5SettingsView);
		menuSemester1ClassSettingView.add(menuItemSemester1Class6SettingsView);
		menuSemester1ClassSettingView.add(menuItemSemester1Class7SettingsView);
		menuSemester1ClassSettingView.add(menuItemSemester1Class8SettingsView);
		
		menuSemester2ClassSettingView.add(menuItemSemester2Class1SettingsView);
		menuSemester2ClassSettingView.add(menuItemSemester2Class2SettingsView);
		menuSemester2ClassSettingView.add(menuItemSemester2Class3SettingsView);
		menuSemester2ClassSettingView.add(menuItemSemester2Class4SettingsView);
		menuSemester2ClassSettingView.add(menuItemSemester2Class5SettingsView);
		menuSemester2ClassSettingView.add(menuItemSemester2Class6SettingsView);
		menuSemester2ClassSettingView.add(menuItemSemester2Class7SettingsView);
		menuSemester2ClassSettingView.add(menuItemSemester2Class8SettingsView);
		
		menuSemester3ClassSettingView.add(menuItemSemester3Class1SettingsView);
		menuSemester3ClassSettingView.add(menuItemSemester3Class2SettingsView);
		menuSemester3ClassSettingView.add(menuItemSemester3Class3SettingsView);
		menuSemester3ClassSettingView.add(menuItemSemester3Class4SettingsView);
		menuSemester3ClassSettingView.add(menuItemSemester3Class5SettingsView);
		menuSemester3ClassSettingView.add(menuItemSemester3Class6SettingsView);
		menuSemester3ClassSettingView.add(menuItemSemester3Class7SettingsView);
		menuSemester3ClassSettingView.add(menuItemSemester3Class8SettingsView);

		menuSemester4ClassSettingView.add(menuItemSemester4Class1SettingsView);
		menuSemester4ClassSettingView.add(menuItemSemester4Class2SettingsView);
		menuSemester4ClassSettingView.add(menuItemSemester4Class3SettingsView);
		menuSemester4ClassSettingView.add(menuItemSemester4Class4SettingsView);
		menuSemester4ClassSettingView.add(menuItemSemester4Class5SettingsView);
		menuSemester4ClassSettingView.add(menuItemSemester4Class6SettingsView);
		menuSemester4ClassSettingView.add(menuItemSemester4Class7SettingsView);
		menuSemester4ClassSettingView.add(menuItemSemester4Class8SettingsView);
		
		menuSemester5ClassSettingView.add(menuItemSemester5Class1SettingsView);
		menuSemester5ClassSettingView.add(menuItemSemester5Class2SettingsView);
		menuSemester5ClassSettingView.add(menuItemSemester5Class3SettingsView);
		menuSemester5ClassSettingView.add(menuItemSemester5Class4SettingsView);
		menuSemester5ClassSettingView.add(menuItemSemester5Class5SettingsView);
		menuSemester5ClassSettingView.add(menuItemSemester5Class6SettingsView);
		menuSemester5ClassSettingView.add(menuItemSemester5Class7SettingsView);
		menuSemester5ClassSettingView.add(menuItemSemester5Class8SettingsView);
		
		menuSemester6ClassSettingView.add(menuItemSemester6Class1SettingsView);
		menuSemester6ClassSettingView.add(menuItemSemester6Class2SettingsView);
		menuSemester6ClassSettingView.add(menuItemSemester6Class3SettingsView);
		menuSemester6ClassSettingView.add(menuItemSemester6Class4SettingsView);
		menuSemester6ClassSettingView.add(menuItemSemester6Class5SettingsView);
		menuSemester6ClassSettingView.add(menuItemSemester6Class6SettingsView);
		menuSemester6ClassSettingView.add(menuItemSemester6Class7SettingsView);
		menuSemester6ClassSettingView.add(menuItemSemester6Class8SettingsView);
		
		menuSemester7ClassSettingView.add(menuItemSemester7Class1SettingsView);
		menuSemester7ClassSettingView.add(menuItemSemester7Class2SettingsView);
		menuSemester7ClassSettingView.add(menuItemSemester7Class3SettingsView);
		menuSemester7ClassSettingView.add(menuItemSemester7Class4SettingsView);
		menuSemester7ClassSettingView.add(menuItemSemester7Class5SettingsView);
		menuSemester7ClassSettingView.add(menuItemSemester7Class6SettingsView);
		menuSemester7ClassSettingView.add(menuItemSemester7Class7SettingsView);
		menuSemester7ClassSettingView.add(menuItemSemester7Class8SettingsView);
	
		menuSemester8ClassSettingView.add(menuItemSemester8Class1SettingsView);
		menuSemester8ClassSettingView.add(menuItemSemester8Class2SettingsView);
		menuSemester8ClassSettingView.add(menuItemSemester8Class3SettingsView);
		menuSemester8ClassSettingView.add(menuItemSemester8Class4SettingsView);
		menuSemester8ClassSettingView.add(menuItemSemester8Class5SettingsView);
		menuSemester8ClassSettingView.add(menuItemSemester8Class6SettingsView);
		menuSemester8ClassSettingView.add(menuItemSemester8Class7SettingsView);
		menuSemester8ClassSettingView.add(menuItemSemester8Class8SettingsView);
	
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
	
	static int semesterNumber = 9;
	static String stringSemesterNumber = Integer.toString(semesterNumber);
	
	public final static void addSemester() {
		String stringSemesterNumber = "Semester #" + Integer.toString(semesterNumber);
		// tabbedPane.add(stringSemesterNumber, new ScrollPane());

		Font f = new Font("serif", Font.PLAIN, 24);
		JComponent pnlSemester = makeTextPanel2(stringSemesterNumber);
		tabbedPane.addTab(stringSemesterNumber, pnlSemester);
		tabbedPane.setFont(f);
		initTabComponent(tabbedPane.getTabCount() - 1);
		semesterNumber++;
		// frame.add(new GPA_Gui(), BorderLayout.NORTH);
	}
	
	public static void makeVisible(){
		frame.setVisible(true);
	}
	
	public static void makeInvisible(){
		frame.setVisible(false);
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