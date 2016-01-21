package gpa_calculator.main;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import gpa_calculator.editclass_gui.EditClass_Gui;
import gpa_calculator.editsemester_gui.EditSemester_Gui;
import gpa_calculator.gpa_gui.GPA_Gui;

public class Main {
	/** 
	 * The main Method initializes the frame and creates all frames necessary for the application.
	 * Makes GPA_Gui frame visible and hides other frames.
	 */	public static void main(String[] args){
		EditSemester_Gui.createAndShowGUI("Semester 1");
		EditSemester_Gui.makeInvisible();
		EditClass_Gui.createAndShowGUI("Semester 1: Class 1");
		EditClass_Gui.makeInvisible();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				GPA_Gui.createAndShowGUI();
			}
		});
	}
}