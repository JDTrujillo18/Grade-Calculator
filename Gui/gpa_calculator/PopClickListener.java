package gpa_calculator;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class PopClickListener extends MouseAdapter {
	

	public static MouseListener createDialog(JLabel b, final String message) {
	    //                                    ^^^^^
	    MouseListener mouseListener = new MouseAdapter() {
	        public void mousePressed(MouseEvent mouseEvent) {
	            if (SwingUtilities.isRightMouseButton(mouseEvent)) {
	               doPop(mouseEvent, message);
	            }
	        }
	    };
	    return mouseListener;
	}
	
	
	//public void mousePressed(MouseEvent e, String s){
		//if (e.isPopupTrigger())
			//doPop(e, s);
    //}
	
    //public void mouseReleased(MouseEvent e, String s){
        //if (e.isPopupTrigger())
            //doPop(e, s);
    //}

    private static void doPop(MouseEvent e, String s){
    	//String s = new String("Class 1");
        PopUpDemo menu = new PopUpDemo(s);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}