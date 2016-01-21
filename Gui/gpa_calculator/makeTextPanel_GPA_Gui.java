package gpa_calculator;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class makeTextPanel_GPA_Gui extends JPanel {
	
	public makeTextPanel_GPA_Gui(String text) {
		//Initialize fonts
				Font f1 = new Font("serif", Font.PLAIN, 36);
				Font f2 = new Font("serif", Font.PLAIN, 24);
				
				//Initialize borders
				Border paddingBorder1 = BorderFactory.createEmptyBorder(10, 40, 10, 40);
				Border paddingBorder2 = BorderFactory.createEmptyBorder(10, 600, 10, 40);
				Border paddingBorder3 = BorderFactory.createEmptyBorder(10, 0, 10, 1435);
				Border paddingBorder5 = BorderFactory.createEmptyBorder(10, 0, 10, 10);
				Border paddingBorder6 = BorderFactory.createEmptyBorder(10, 1260, 10, 0);

				//Set Layout to a BoxLayout along the Y-Axis(vertical)
				this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

				//Initialize the panel that will hold the semester header
				JPanel semester = new JPanel();
				
				//Initialize empty panel that will be used for spacing
				JPanel empty = new JPanel();

				//Initialize panel that will hold all class 1 components
				JPanel class1 = new JPanel();
				//Set panel layout to BoxLayout along the X-Axis(horizontal)
				class1.setLayout(new BoxLayout(class1, BoxLayout.X_AXIS));

				//Initialize panel that will hold all class 2 components
				JPanel class2 = new JPanel();
				//Set panel layout to BoxLayout along the X-Axis(horizontal)
				class2.setLayout(new BoxLayout(class2, BoxLayout.X_AXIS));
				
				//Initialize panel that will hold all class 3 components
				JPanel class3 = new JPanel();
				//Set panel layout to BoxLayout along the X-Axis(horizontal)
				class3.setLayout(new BoxLayout(class3, BoxLayout.X_AXIS));

				//Initialize panel that will hold all class 4 components
				JPanel class4 = new JPanel();
				//Set panel layout to BoxLayout along the X-Axis(horizontal)
				class4.setLayout(new BoxLayout(class4, BoxLayout.X_AXIS));

				//Initialize panel that will hold all class 5 components
				JPanel class5 = new JPanel();
				//Set panel layout to BoxLayout along the X-Axis(horizontal)
				class5.setLayout(new BoxLayout(class5, BoxLayout.X_AXIS));

				//Initialize panel that will hold all class 6 components
				JPanel class6 = new JPanel();
				//Set panel layout to BoxLayout along the X-Axis(horizontal)
				class6.setLayout(new BoxLayout(class6, BoxLayout.X_AXIS));

				//Initialize panel that will hold all class 7 components
				JPanel class7 = new JPanel();
				//Set panel layout to BoxLayout along the X-Axis(horizontal)
				class7.setLayout(new BoxLayout(class7, BoxLayout.X_AXIS));

				//Initialize panel that will hold all class 8 components
				JPanel class8 = new JPanel();
				//Set panel layout to BoxLayout along the X-Axis(horizontal)
				class8.setLayout(new BoxLayout(class8, BoxLayout.X_AXIS));

				//Initialize panel that will hold the add class button
				JPanel addClass = new JPanel();
				//Set panel layout to BoxLayout along the X-Axis(horizontal)
				addClass.setLayout(new BoxLayout(addClass, BoxLayout.X_AXIS));

				//Initialize panel that will hold the Semester GPA
				JPanel gpaSemester = new JPanel();
				//Set panel layout to BoxLayout along the X-Axis(horizontal)
				gpaSemester.setLayout(new BoxLayout(gpaSemester, BoxLayout.X_AXIS));
				
				//Initialize panel that will hold the Total GPA
				JPanel gpaTotal = new JPanel();
				//Set panel layout to BoxLayout along the X-Axis(horizontal)
				gpaTotal.setLayout(new BoxLayout(gpaTotal, BoxLayout.X_AXIS));
				
				BufferedImage buttonIcon = null;
				try {
					buttonIcon = ImageIO.read(new File(GPA_Gui.class.getResource("/images/minus.png").toURI()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				BufferedImage buttonIcon2 = GPA_Gui.resize(buttonIcon, 20, 20);
				
				BufferedImage buttonIcon3 = null;
				try {
					buttonIcon3 = ImageIO.read(new File(GPA_Gui.class.getResource("/images/plus.png").toURI()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				BufferedImage buttonIcon4 = GPA_Gui.resize(buttonIcon3, 20, 20);

				JButton btnDeleteClass1 = new JButton(new ImageIcon(buttonIcon2));
				btnDeleteClass1.setBorder(paddingBorder5);
				btnDeleteClass1.setContentAreaFilled(false);
				class1.add(btnDeleteClass1);
				
				JLabel fillerClass1 = new JLabel("Class 1");
				fillerClass1.setFont(f2);
				fillerClass1.addMouseListener(PopClickListener.createDialog(fillerClass1, text + ": Class 1"));
				class1.add(fillerClass1);

				JLabel class1Grade = new JLabel("Grade: 0");
				class1Grade.setFont(f2);
				class1Grade.setBorder(paddingBorder2);
				class1.add(class1Grade);

				JLabel class1LetterGrade = new JLabel("Letter Grade: F");
				class1LetterGrade.setFont(f2);
				class1LetterGrade.setBorder(paddingBorder1);
				class1.add(class1LetterGrade);

				JLabel class1Hours = new JLabel("Hours: 0");
				class1Hours.setFont(f2);
				class1Hours.setBorder(paddingBorder1);
				class1.add(class1Hours);

				JLabel class1QualityPoints = new JLabel("Quality Points: 0");
				class1QualityPoints.setFont(f2);
				class1QualityPoints.setBorder(paddingBorder1);
				class1.add(class1QualityPoints);

				
				JButton btnDeleteClass2 = new JButton(new ImageIcon(buttonIcon2));
				btnDeleteClass2.setBorder(paddingBorder5);
				btnDeleteClass2.setContentAreaFilled(false);
				class2.add(btnDeleteClass2);
				
				JLabel fillerClass2 = new JLabel("Class 2");
				fillerClass2.setFont(f2);
				fillerClass2.addMouseListener(PopClickListener.createDialog(fillerClass1,  text + ": Class 2"));
				class2.add(fillerClass2);

				JLabel class2Grade = new JLabel("Grade: 0");
				class2Grade.setFont(f2);
				class2Grade.setBorder(paddingBorder2);
				class2.add(class2Grade);

				JLabel class2LetterGrade = new JLabel("Letter Grade: F");
				class2LetterGrade.setFont(f2);
				class2LetterGrade.setBorder(paddingBorder1);
				class2.add(class2LetterGrade);

				JLabel class2Hours = new JLabel("Hours: 0");
				class2Hours.setFont(f2);
				class2Hours.setBorder(paddingBorder1);
				class2.add(class2Hours);

				JLabel class2QualityPoints = new JLabel("Quality Points: 0");
				class2QualityPoints.setFont(f2);
				class2QualityPoints.setBorder(paddingBorder1);
				class2.add(class2QualityPoints);

				
				JButton btnDeleteClass3 = new JButton(new ImageIcon(buttonIcon2));
				btnDeleteClass3.setBorder(paddingBorder5);
				btnDeleteClass3.setContentAreaFilled(false);
				class3.add(btnDeleteClass3);
				
				JLabel fillerClass3 = new JLabel("Class 3");
				fillerClass3.setFont(f2);
				fillerClass3.addMouseListener(PopClickListener.createDialog(fillerClass3,  text + ": Class 3"));
				class3.add(fillerClass3);

				JLabel class3Grade = new JLabel("Grade: 0");
				class3Grade.setFont(f2);
				class3Grade.setBorder(paddingBorder2);
				class3.add(class3Grade);

				JLabel class3LetterGrade = new JLabel("Letter Grade: F");
				class3LetterGrade.setFont(f2);
				class3LetterGrade.setBorder(paddingBorder1);
				class3.add(class3LetterGrade);

				JLabel class3Hours = new JLabel("Hours: 0");
				class3Hours.setFont(f2);
				class3Hours.setBorder(paddingBorder1);
				class3.add(class3Hours);

				JLabel class3QualityPoints = new JLabel("Quality Points: 0");
				class3QualityPoints.setFont(f2);
				class3QualityPoints.setBorder(paddingBorder1);
				class3.add(class3QualityPoints);

				JButton btnDeleteClass4 = new JButton(new ImageIcon(buttonIcon2));
				btnDeleteClass4.setBorder(paddingBorder5);
				btnDeleteClass4.setContentAreaFilled(false);
				class4.add(btnDeleteClass4);
				
				JLabel fillerClass4 = new JLabel("Class 4");
				fillerClass4.setFont(f2);
				fillerClass4.addMouseListener(PopClickListener.createDialog(fillerClass4,  text + ": Class 4"));
				class4.add(fillerClass4);

				JLabel class4Grade = new JLabel("Grade: 0");
				class4Grade.setFont(f2);
				class4Grade.setBorder(paddingBorder2);
				class4.add(class4Grade);

				JLabel class4LetterGrade = new JLabel("Letter Grade: F");
				class4LetterGrade.setFont(f2);
				class4LetterGrade.setBorder(paddingBorder1);
				class4.add(class4LetterGrade);

				JLabel class4Hours = new JLabel("Hours: 0");
				class4Hours.setFont(f2);
				class4Hours.setBorder(paddingBorder1);
				class4.add(class4Hours);

				JLabel class4QualityPoints = new JLabel("Quality Points: 0");
				class4QualityPoints.setFont(f2);
				class4QualityPoints.setBorder(paddingBorder1);
				class4.add(class4QualityPoints);

				JButton btnDeleteClass5 = new JButton(new ImageIcon(buttonIcon2));
				btnDeleteClass5.setBorder(paddingBorder5);
				btnDeleteClass5.setContentAreaFilled(false);
				class5.add(btnDeleteClass5);
				
				JLabel fillerClass5 = new JLabel("Class 5");
				fillerClass5.setFont(f2);
				fillerClass5.addMouseListener(PopClickListener.createDialog(fillerClass5,  text + ": Class 5"));
				class5.add(fillerClass5);
				
				JLabel class5Grade = new JLabel("Grade: 0");
				class5Grade.setFont(f2);
				class5Grade.setBorder(paddingBorder2);
				class5.add(class5Grade);

				JLabel class5LetterGrade = new JLabel("Letter Grade: F");
				class5LetterGrade.setFont(f2);
				class5LetterGrade.setBorder(paddingBorder1);
				class5.add(class5LetterGrade);

				JLabel class5Hours = new JLabel("Hours: 0");
				class5Hours.setFont(f2);
				class5Hours.setBorder(paddingBorder1);
				class5.add(class5Hours);

				JLabel class5QualityPoints = new JLabel("Quality Points: 0");
				class5QualityPoints.setFont(f2);
				class5QualityPoints.setBorder(paddingBorder1);
				class5.add(class5QualityPoints);

				JButton btnDeleteClass6 = new JButton(new ImageIcon(buttonIcon2));
				btnDeleteClass6.setBorder(paddingBorder5);
				btnDeleteClass6.setContentAreaFilled(false);
				class6.add(btnDeleteClass6);
				
				JLabel fillerClass6 = new JLabel("Class 6");
				fillerClass6.setFont(f2);
				fillerClass6.addMouseListener(PopClickListener.createDialog(fillerClass6,  text + ": Class 6"));
				class6.add(fillerClass6);
				
				JLabel class6Grade = new JLabel("Grade: 0");
				class6Grade.setFont(f2);
				class6Grade.setBorder(paddingBorder2);
				class6.add(class6Grade);

				JLabel class6LetterGrade = new JLabel("Letter Grade: F");
				class6LetterGrade.setFont(f2);
				class6LetterGrade.setBorder(paddingBorder1);
				class6.add(class6LetterGrade);

				JLabel class6Hours = new JLabel("Hours: 0");
				class6Hours.setFont(f2);
				class6Hours.setBorder(paddingBorder1);
				class6.add(class6Hours);

				JLabel class6QualityPoints = new JLabel("Quality Points: 0");
				class6QualityPoints.setFont(f2);
				class6QualityPoints.setBorder(paddingBorder1);
				class6.add(class6QualityPoints);

				JButton btnDeleteClass7 = new JButton(new ImageIcon(buttonIcon2));
				btnDeleteClass7.setBorder(paddingBorder5);
				btnDeleteClass7.setContentAreaFilled(false);
				class7.add(btnDeleteClass7);
				
				JLabel fillerClass7 = new JLabel("Class 7");
				fillerClass7.setFont(f2);
				fillerClass7.addMouseListener(PopClickListener.createDialog(fillerClass7,  text + ": Class 7"));
				class7.add(fillerClass7);

				JLabel class7Grade = new JLabel("Grade: 0");
				class7Grade.setFont(f2);
				class7Grade.setBorder(paddingBorder2);
				class7.add(class7Grade);

				JLabel class7LetterGrade = new JLabel("Letter Grade: F");
				class7LetterGrade.setFont(f2);
				class7LetterGrade.setBorder(paddingBorder1);
				class7.add(class7LetterGrade);

				JLabel class7Hours = new JLabel("Hours: 0");
				class7Hours.setFont(f2);
				class7Hours.setBorder(paddingBorder1);
				class7.add(class7Hours);

				JLabel class7QualityPoints = new JLabel("Quality Points: 0");
				class7QualityPoints.setFont(f2);
				class7QualityPoints.setBorder(paddingBorder1);
				class7.add(class7QualityPoints);

				JButton btnDeleteClass8 = new JButton(new ImageIcon(buttonIcon2));
				btnDeleteClass8.setBorder(paddingBorder5);
				btnDeleteClass8.setContentAreaFilled(false);
				class8.add(btnDeleteClass8);
				
				JLabel fillerClass8 = new JLabel("Class 8");
				fillerClass8.setFont(f2);
				fillerClass8.addMouseListener(PopClickListener.createDialog(fillerClass8,  text + ": Class 8"));
				class8.add(fillerClass8);

				JLabel class8Grade = new JLabel("Grade: 0");
				class8Grade.setFont(f2);
				class8Grade.setBorder(paddingBorder2);
				class8.add(class8Grade);

				JLabel class8LetterGrade = new JLabel("Letter Grade: F");
				class8LetterGrade.setFont(f2);
				class8LetterGrade.setBorder(paddingBorder1);
				class8.add(class8LetterGrade);

				JLabel class8Hours = new JLabel("Hours: 0");
				class8Hours.setFont(f2);
				class8Hours.setBorder(paddingBorder1);
				class8.add(class8Hours);

				JLabel class8QualityPoints = new JLabel("Quality Points: 0");
				class8QualityPoints.setFont(f2);
				class8QualityPoints.setBorder(paddingBorder1);
				class8.add(class8QualityPoints);

				JLabel fillerSemester = new JLabel(text);
				fillerSemester.setFont(f1);
				semester.add(fillerSemester);
				
				JButton btnAddClass = new JButton(new ImageIcon(buttonIcon4));
				btnAddClass.setBorder(paddingBorder3);
				btnAddClass.setContentAreaFilled(false);
				addClass.add(btnAddClass);

				JLabel semesterGPA = new JLabel("Semester GPA: 0.00");
				semesterGPA.setFont(f2);
				semesterGPA.setBorder(paddingBorder6);
				gpaSemester.add(semesterGPA);

				JLabel totalGPA = new JLabel("Total GPA: 0.00");
				totalGPA.setFont(f2);
				totalGPA.setBorder(paddingBorder6);
				gpaTotal.add(totalGPA);
				
				this.add(semester);
				this.add(empty);
				this.add(class1);
				this.add(class2);
				this.add(class3);
				this.add(class4);
				this.add(class5);
				this.add(class6);
				this.add(class7);
				this.add(class8);
				this.add(addClass);
				this.add(gpaSemester);
				this.add(gpaTotal);
	}
}