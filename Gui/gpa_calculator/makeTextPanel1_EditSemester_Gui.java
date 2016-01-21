package gpa_calculator;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.TreeSelectionModel;

public class makeTextPanel1_EditSemester_Gui extends JPanel {
	
	public makeTextPanel1_EditSemester_Gui(String text) {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//Create the nodes.
        createNodes1 createNodes1 = new createNodes1(text);
 
        //Create a tree that allows one selection at a time.
        JTree tree = new JTree(createNodes1);
        tree.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);
 
        //Create the scroll pane and add the tree to it. 
        JScrollPane treeView = new JScrollPane(tree);
		this.add(treeView);
	}
}