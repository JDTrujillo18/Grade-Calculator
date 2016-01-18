package gpa_calculator;

import java.awt.Font;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

class PopUpDemo2 extends JPopupMenu {
    JMenuItem anItem;
    public PopUpDemo2(String s){
    	Font f = new Font("serif", Font.PLAIN, 16);
        anItem = new JMenuItem("Edit " + s);
        anItem.setFont(f);
        add(anItem);
    }
}