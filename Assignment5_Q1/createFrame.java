import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

class createFrame extends JFrame{
    private JButton StudentButton;
    private JButton InstructorButton;
    private JButton SummaryButton;

    public createFrame(){
        super("Frame of the main Class");
        setLayout(new FlowLayout());
        StudentButton = new JButton("STUDENT'S VERSION");
        InstructorButton = new JButton("INSTRUCTOR'S VERSION");
        SummaryButton = new JButton("SUMMARY");
        add(StudentButton);
        add(InstructorButton);
        add(SummaryButton);
        HandlerClass hc = new HandlerClass();
        StudentButton.addActionListener(hc);
        InstructorButton.addActionListener(hc);
        SummaryButton.addActionListener(hc);
    }
    private class HandlerClass implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(event.getSource()==StudentButton){
                /* Create a new frame when the user clicks student
                 * The new frame should contain 2 different buttons
                 * One to get the marks from the rollnumber of the student 
                 * Another to get the table of contents of the JTable
                 */
              //  System.out.println("Student Clicked");
                studentVersion v = new studentVersion();
                v.displayGUI();
            }
            else if(event.getSource() == InstructorButton){
                InstructorVersion iv = new InstructorVersion();
                iv.getGUIInstructor();
                //System.out.println("Instructor clicked");
            }
            else if(event.getSource() == SummaryButton){
               SummaryVersion sv = new SummaryVersion();
               sv.displayGUISummary();
            }
            }
        }
}


