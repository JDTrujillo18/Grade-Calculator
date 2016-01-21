package gpa_calculator;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

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