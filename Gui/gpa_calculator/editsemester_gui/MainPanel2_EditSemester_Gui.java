package gpa_calculator.editsemester_gui;
	
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JTabbedPane;

public class MainPanel2_EditSemester_Gui extends JTabbedPane {
	//private static JTabbedPane tabbedPane;
	
	public MainPanel2_EditSemester_Gui(String s) {
		Font f = new Font("serif", Font.PLAIN, 24);
		Dimension d1 = new Dimension(900, 800);
		this.setPreferredSize(d1);
		this.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		makeTextPanel2_EditSemester_Gui pnlInnerSemester = new makeTextPanel2_EditSemester_Gui(s);
		this.addTab(s, pnlInnerSemester);
		this.setMnemonicAt(0, KeyEvent.VK_2);
		this.setFont(f);
	}
	
}