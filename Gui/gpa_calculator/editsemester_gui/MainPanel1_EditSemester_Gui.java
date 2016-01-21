package gpa_calculator.editsemester_gui;
	
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JTabbedPane;

public class MainPanel1_EditSemester_Gui extends JTabbedPane {
	//private static JTabbedPane tabbedPane;
	
	public MainPanel1_EditSemester_Gui(String s) {
		Font f = new Font("serif", Font.PLAIN, 24);
		Dimension d1 = new Dimension(400, 800);
		this.setPreferredSize(d1);
		this.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		
		makeTextPanel1_EditSemester_Gui pnlInnerSettings = new makeTextPanel1_EditSemester_Gui(s + " Settings");
		this.addTab(s + " Settings", pnlInnerSettings);
		this.setMnemonicAt(0, KeyEvent.VK_1);
		this.setFont(f);
	}
}