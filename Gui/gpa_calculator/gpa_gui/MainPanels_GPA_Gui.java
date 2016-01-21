package gpa_calculator.gpa_gui;
	
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;

public class MainPanels_GPA_Gui extends JTabbedPane {
	//private static JTabbedPane tabbedPane;
	
	public MainPanels_GPA_Gui() {
		//Define Layout of frame
		//super(new GridLayout(1, 1));
				
		//Initialize fonts
		Font f = new Font("serif", Font.PLAIN, 24);
				
		//Initialize tabbed pane
		//tabbedPane = new JTabbedPane();
				
		// The following line enables to use scrolling tabs.
		this.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
				
		//Set tabbed pane font
		this.setFont(f);
				//Initialize panels, add panels and set panel fonts
		//Initialize panel that the Semester 1 tab will hold
		//Call makeTextPanel for this panel
		JComponent pnlSemester1 = new makeTextPanel_GPA_Gui("Semester 1");
		//Add tab with panel
		this.addTab("Semester 1", pnlSemester1);
		//Set tab mnemonic
		this.setMnemonicAt(0, KeyEvent.VK_1);

		//Initialize panel that the Semester 2 tab will hold
		//Call makeTextPanel for this panel
		JComponent pnlSemester2 = new makeTextPanel_GPA_Gui("Semester 2");
		//Add tab with panel
		this.addTab("Semester 2", pnlSemester2);
		//Set tab mnemonic
		this.setMnemonicAt(1, KeyEvent.VK_2);

		//Initialize panel that the Semester 3 tab will hold
		//Call makeTextPanel for this panel
		JComponent pnlSemester3 = new makeTextPanel_GPA_Gui("Semester 3");
		//Add tab with panel
		this.addTab("Semester 3", pnlSemester3);
		//Set tab mnemonic
		this.setMnemonicAt(2, KeyEvent.VK_3);

		//Initialize panel that the Semester 4 tab will hold
		//Call makeTextPanel for this panel
		JComponent pnlSemester4 = new makeTextPanel_GPA_Gui("Semester 4");
		//Add tab with panel
		this.addTab("Semester 4", pnlSemester4);
		//Set tab mnemonic
		this.setMnemonicAt(3, KeyEvent.VK_4);

		//Initialize panel that the Semester 5 tab will hold
		//Call makeTextPanel for this panel
		JComponent pnlSemester5 = new makeTextPanel_GPA_Gui("Semester 5");
		//Add tab with panel
		this.addTab("Semester 5", pnlSemester5);
		//Set tab mnemonic
		this.setMnemonicAt(3, KeyEvent.VK_5);

		//Initialize panel that the Semester 6 tab will hold
		//Call makeTextPanel for this panel
		JComponent pnlSemester6 = new makeTextPanel_GPA_Gui("Semester 6");
		//Add tab with panel
		this.addTab("Semester 6", pnlSemester6);
		//Set tab mnemonic
		this.setMnemonicAt(3, KeyEvent.VK_6);

		//Initialize panel that the Semester 7 tab will hold
		//Call makeTextPanel for this panel
		JComponent pnlSemester7 = new makeTextPanel_GPA_Gui("Semester 7");
		//Add tab with panel
		this.addTab("Semester 7", pnlSemester7);
		//Set tab mnemonic
		this.setMnemonicAt(3, KeyEvent.VK_7);

		//Initialize panel that the Semester 8 tab will hold
		//Call makeTextPanel for this panel
		JComponent pnlSemester8 = new makeTextPanel_GPA_Gui("Semester 8");
		//Add tab with panel
		this.addTab("Semester 8", pnlSemester8);
		//Set tab mnemonic
		this.setMnemonicAt(3, KeyEvent.VK_8);
	}
}