package gpa_calculator;

import java.awt.Font;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

class PopUpDemo extends JPopupMenu {
    JMenuItem anItem;
    public PopUpDemo(){
    	Font f = new Font("serif", Font.PLAIN, 16);
        anItem = new JMenuItem("Edit Semester");
        anItem.setFont(f);
        add(anItem);
    }
}