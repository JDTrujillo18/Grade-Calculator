package gpa_calculator.editsemester_gui;
	
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JTabbedPane;

public class MainPanel3_EditSemester_Gui extends JTabbedPane {
	//private static JTabbedPane tabbedPane;
	
	public MainPanel3_EditSemester_Gui(String s) {
		Font f = new Font("serif", Font.PLAIN, 24);
		Dimension d1 = new Dimension(200, 800);
		this.setPreferredSize(d1);
		this.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		makeTextPanel3_EditSemester_Gui pnlTree = new makeTextPanel3_EditSemester_Gui("Student Tree View");
		this.addTab("Student Tree View", pnlTree);
		this.setMnemonicAt(0, KeyEvent.VK_3);
		this.setFont(f);
	}
}