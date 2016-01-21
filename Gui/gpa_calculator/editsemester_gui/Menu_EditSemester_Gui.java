package gpa_calculator.editsemester_gui;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import gpa_calculator.editclass_gui.EditClass_Gui;
import gpa_calculator.gpa_gui.GPA_Gui;

 
public class Menu_EditSemester_Gui extends JMenuBar {
	// Initialize Menus
	JMenu menuFile;
	JMenu menuNew;
	
	JMenu menuEdit;
	JMenu menuEditSemester;

	JMenu menuView;
	JMenu menuShowView;
	JMenu menuSemesterSettingsView;
	// Initialize MenuItems
	JMenuItem menuItemQuit;
	JMenuItem menuItemNewStudent;
	JMenuItem menuItemNewClass;
	JMenuItem menuItemSave;
	JMenuItem menuItemSaveAs;
	JMenuItem menuItemSaveAll;
	JMenuItem menuItemSettings;
	JMenuItem menuItemSemesterSettings;
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
	JMenuItem menuItemSemester1SettingView;
	JMenuItem menuItemSemester2SettingView;
	JMenuItem menuItemSemester3SettingView;
	JMenuItem menuItemSemester4SettingView;
	JMenuItem menuItemSemester5SettingView;
	JMenuItem menuItemSemester6SettingView;
	JMenuItem menuItemSemester7SettingView;
	JMenuItem menuItemSemester8SettingView;
	
	 public Menu_EditSemester_Gui(String s) {
		 Font fmenu = new Font("sans-serif", Font.PLAIN, 12);
			UIManager.put("Menu.font", fmenu);
			UIManager.put("MenuItem.font", fmenu);
			// Build the File menu.
			menuFile = new JMenu("File");
			menuFile.setMnemonic(KeyEvent.VK_A);
			
			menuNew = new JMenu("New");
			// Build the Edit menu.
			menuEdit = new JMenu("Edit");

			menuView = new JMenu("View");
			menuShowView = new JMenu("Show View");
			menuSemesterSettingsView = new JMenu ("Semester Settings View");
			// a group of JMenuItems

			menuItemNewStudent = new JMenuItem("Student", KeyEvent.VK_2);
			menuItemNewStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
			menuItemNewStudent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {

				}
			});

			menuItemNewClass = new JMenuItem("Class", KeyEvent.VK_3);
			menuItemNewClass.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
			menuItemNewClass.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					//addClass();
				}
			});
			
			menuItemSettings = new JMenuItem("Settings");
			menuItemSettings.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent actionEvent){
					
				}
			});
			
			menuItemSemesterSettings = new JMenuItem(s + " Settings");
			menuItemSemesterSettings.addActionListener(new ActionListener(){
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
			
			menuItemQuit = new JMenuItem("Quit", KeyEvent.VK_T);
			menuItemQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
			menuItemQuit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					System.exit(0);
				}
			});
			
			menuEditSemester = new JMenu("Edit Semester");
			
			menuItemEditSemester1 = new JMenuItem("Semester 1");
			menuItemEditSemester1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					EditSemester_Gui.addSemester("Semester 1");
				}
			});
			menuItemEditSemester2 = new JMenuItem("Semester 2");
			menuItemEditSemester2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					EditSemester_Gui.addSemester("Semester 2");
				}
			});
			menuItemEditSemester3 = new JMenuItem("Semester 3");
			menuItemEditSemester3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					EditSemester_Gui.addSemester("Semester 3");
				}
			});
			menuItemEditSemester4 = new JMenuItem("Semester 4");
			menuItemEditSemester4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					EditSemester_Gui.addSemester("Semester 4");
					
				}
			});
			menuItemEditSemester5 = new JMenuItem("Semester 5");
			menuItemEditSemester5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					EditSemester_Gui.addSemester("Semester 5");
				}
			});
			menuItemEditSemester6 = new JMenuItem("Semester 6");
			menuItemEditSemester6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					EditSemester_Gui.addSemester("Semester 6");
				}
			});
			menuItemEditSemester7 = new JMenuItem("Semester 7");
			menuItemEditSemester7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					EditSemester_Gui.addSemester("Semester 7");
				}
			});
			menuItemEditSemester8 = new JMenuItem("Semester 8");
			menuItemEditSemester8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					EditSemester_Gui.addSemester("Semester 8");
				}
			});
			
			menuItemStudentView = new JMenuItem("Student View");
			menuItemStudentView.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
			menuItemStudentView.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent actionEvent){
					GPA_Gui.makeVisible();
					EditSemester_Gui.makeInvisible();
				}
			});
			
			menuItemSemesterView = new JMenuItem("Semester View");
			menuItemSemesterView.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
			menuItemSemesterView.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent actionEvent){
					
				}
			});
			
			menuItemClassView = new JMenuItem("Class View");
			menuItemClassView.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
			menuItemClassView.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent actionEvent){
					EditClass_Gui.makeVisible();
					EditSemester_Gui.makeInvisible();
				}
			});
			
			menuItemStudentTreeView = new JMenuItem("Student Tree View");
			menuItemStudentTreeView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent){
					
				}
			});
			
			menuItemSemester1SettingView = new JMenuItem("Semester 1 Settings");
			menuItemSemester1SettingView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					EditSemester_Gui.addSettingView("Semester 1 Settings");
				}
			});
			
			menuItemSemester2SettingView = new JMenuItem("Semester 2 Settings");
			menuItemSemester2SettingView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					EditSemester_Gui.addSettingView("Semester 2 Settings");
				}
			});
			
			menuItemSemester3SettingView = new JMenuItem("Semester 3 Settings");
			menuItemSemester3SettingView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					EditSemester_Gui.addSettingView("Semester 3 Settings");
				}
			});
			
			menuItemSemester4SettingView = new JMenuItem("Semester 4 Settings");
			menuItemSemester4SettingView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					EditSemester_Gui.addSettingView("Semester 4 Settings");
				}
			});
			
			menuItemSemester5SettingView = new JMenuItem("Semester 5 Settings");
			menuItemSemester5SettingView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					EditSemester_Gui.addSettingView("Semester 5 Settings");
				}
			});
			
			menuItemSemester6SettingView = new JMenuItem("Semester 6 Settings");
			menuItemSemester6SettingView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					EditSemester_Gui.addSettingView("Semester 6 Settings");
				}
			});
			
			menuItemSemester7SettingView = new JMenuItem("Semester 7 Settings");
			menuItemSemester7SettingView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					EditSemester_Gui.addSettingView("Semester 7 Settings");
				}
			});
			
			menuItemSemester8SettingView = new JMenuItem("Semester 8 Settings");
			menuItemSemester8SettingView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					EditSemester_Gui.addSettingView("Semester 8 Settings");
				}
			});
			
			// Add Exit Item to File Menu.
			this.add(menuFile);
			menuFile.add(menuNew);
			this.add(menuEdit);
			this.add(menuView);
			
			// Add Exit Item to File Menu.
			menuNew.add(menuItemNewStudent);
			menuNew.add(menuItemNewClass);
			menuFile.addSeparator();
			menuFile.add(menuItemSave);
			menuFile.add(menuItemSaveAs);
			menuFile.add(menuItemSaveAll);
			menuFile.addSeparator();
			menuFile.add(menuItemSemesterSettings);
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
			menuView.addSeparator();
			menuView.add(menuShowView);
			
			menuShowView.add(menuItemStudentTreeView);
			menuShowView.add(menuSemesterSettingsView);
			
			menuSemesterSettingsView.add(menuItemSemester1SettingView);
			menuSemesterSettingsView.add(menuItemSemester2SettingView);
			menuSemesterSettingsView.add(menuItemSemester3SettingView);
			menuSemesterSettingsView.add(menuItemSemester4SettingView);
			menuSemesterSettingsView.add(menuItemSemester5SettingView);
			menuSemesterSettingsView.add(menuItemSemester6SettingView);
			menuSemesterSettingsView.add(menuItemSemester7SettingView);
			menuSemesterSettingsView.add(menuItemSemester8SettingView);
			
	 }
}