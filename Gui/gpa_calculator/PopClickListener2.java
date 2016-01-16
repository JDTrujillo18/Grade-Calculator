package gpa_calculator;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class PopClickListener2 extends MouseAdapter {
    public void mousePressed(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
    }

    public void mouseReleased(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
    }

    private void doPop(MouseEvent e){
        PopUpDemo2 menu = new PopUpDemo2();
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}