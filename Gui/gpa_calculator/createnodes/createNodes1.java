package gpa_calculator.createnodes;

import javax.swing.tree.DefaultMutableTreeNode;

public class createNodes1 extends DefaultMutableTreeNode {
	 public createNodes1 (String text) {
		 DefaultMutableTreeNode category = null ;
	     DefaultMutableTreeNode subcategory = null;
	     DefaultMutableTreeNode subsubcategory = null;
	     this.setUserObject(text);
	     category = new DefaultMutableTreeNode("General");
      	 this.add(category);
	        
	     subcategory = new DefaultMutableTreeNode("Appearance");
	     category.add(subcategory);
	        
	     subsubcategory = new DefaultMutableTreeNode("Fonts and Colors");
	     subcategory.add(subsubcategory);
	        
	     subsubcategory = new DefaultMutableTreeNode("Themes");
	     subcategory.add(subsubcategory);
	        
	     subcategory = new DefaultMutableTreeNode("Semester");
	     category.add(subcategory);
	        
	     subsubcategory = new DefaultMutableTreeNode("Semester Title");
	     subcategory.add(subsubcategory);
	        
	     subcategory = new DefaultMutableTreeNode("Classes");
	     category.add(subcategory);
	        
	     subsubcategory = new DefaultMutableTreeNode("Number of Classes");
	     subcategory.add(subsubcategory);
	        
	     subcategory = new DefaultMutableTreeNode("Other");
	     category.add(subcategory);
	        
	     subsubcategory = new DefaultMutableTreeNode("Grading Criteria");
	     subcategory.add(subsubcategory);
	 }
}