import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

class InstructorVersion extends screenGUI implements ActionListener{
    private JButton addStudentButton;
    private JButton editStudentButton;
    private JButton deleteStudentButton;
    private JLabel addLabel;
    private JLabel RollLabel;
    private JLabel DeleteRollLabel;
    private JLabel deleteLabel;
    private JLabel Mark1label;
    private JLabel Mark2label; 
    private JLabel Mark3label;
    private JLabel Mark4label;
    private JLabel Mark5label;
    private JTextField RollArea;
    private JTextField mark1;
    private JTextField mark2;
    private JTextField mark3;
    private JTextField mark4;
    private JTextField mark5;
    private JTextField RollDelete;
    private JButton displayTableButton;
    
    public InstructorVersion(){
       
        addLabel = new JLabel("ADD STUDENT OR EDIT MARKS OF AN EXISTING STUDENT");
        addLabel.setBounds(100,10,500,50);
        RollLabel = new JLabel("ROLL NUMBER:");
        RollLabel.setBounds(10,70,200,50);
        RollArea = new JTextField();
        RollArea.setBounds(70,70,150,50);
        Mark1label = new JLabel("Q1");
        Mark1label.setBounds(10,150,30,30);
        mark1 = new JTextField();
        mark1.setBounds(50,150,30,30);
        Mark2label = new JLabel("Q2");
        Mark2label.setBounds(90,150,30,30);
        mark2 = new JTextField();
        mark2.setBounds(130,150,30,30);
        Mark3label = new JLabel("Q3");
        Mark3label.setBounds(170,150,30,30);
        mark3 = new JTextField();
        mark3.setBounds(210,150,30,30);
        Mark4label = new JLabel("Q4");
        Mark4label.setBounds(250,150,30,30);
        mark4 = new JTextField();
        mark4.setBounds(290,150,30,30);
        Mark5label = new JLabel("Q5");
        Mark5label.setBounds(330,150,30,30);
        mark5 = new JTextField();
        mark5.setBounds(370,150,30,30);
        addStudentButton = new JButton("ADD STUDENT");
        addStudentButton.setBounds(30,200,190,40);
        addStudentButton.addActionListener(this);
        editStudentButton = new JButton("EDIT STUDENT");
        editStudentButton.setBounds(240,200,190,40);
        editStudentButton.addActionListener(this);
        deleteLabel = new JLabel("DELETE STUDENT");
        deleteLabel.setBounds(30,260,120,40);
        DeleteRollLabel = new JLabel("ROLL NUM:");
        DeleteRollLabel.setBounds(10,310,90,30);
        RollDelete = new JTextField();
        RollDelete.setBounds(110,310,100,30);
        deleteStudentButton = new JButton("DELETE STUDENT");
        deleteStudentButton.setBounds(90,370,200,30);
        deleteStudentButton.addActionListener(this);
        displayTableButton = new JButton("DISPLAY TABLE");
        displayTableButton.setBounds(100,460,300,40);
        displayTableButton.addActionListener(this);
        JFrame frame = new JFrame("INSTRUCTOR'S VERSION");
        frame.setLayout(null);
        frame.setSize(getScreenWidth(),getScreenHeight());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(addLabel);
        frame.add(RollLabel);
        frame.add(RollArea);
        frame.add(Mark1label);
        frame.add(Mark2label);
        frame.add(Mark3label);
        frame.add(Mark4label);
        frame.add(Mark5label);
        frame.add(mark1);
        frame.add(mark2);
        frame.add(mark3);
        frame.add(mark4);
        frame.add(mark5);
        frame.add(addStudentButton);
        frame.add(editStudentButton);
        frame.add(DeleteRollLabel);
        frame.add(deleteLabel);
        frame.add(RollDelete);
        frame.add(deleteStudentButton); 
        frame.add(displayTableButton);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent event){
        String rollNumber = RollArea.getText();
        String m1 = mark1.getText();
        String m2 = mark2.getText();
        String m3 = mark3.getText();
        String m4 = mark4.getText();
        String m5 = mark5.getText();
        if(event.getSource() == addStudentButton){
            
            iEditOrAdd ieo = new iEditOrAdd();
            ieo.writeToFile(rollNumber,m1,m2,m3,m4,m5);
            JOptionPane.showMessageDialog(null,"Student Added Successfully");
        }
        else if(event.getSource() == editStudentButton){
            iEditOrAdd ieo = new iEditOrAdd();
            ieo.writeToFile(rollNumber,m1,m2,m3,m4,m5);
            JOptionPane.showMessageDialog(null,"Student's data edited successfully");
        }
        else if(event.getSource() == deleteStudentButton){
            iDeleteData idd = new iDeleteData();
            idd.DeleteContent(rollNumber);
            JOptionPane.showMessageDialog(null,"Student Deleted Successfully");
        }
        else if(event.getSource() == displayTableButton){
            createJTable cj = new createJTable();
            cj.createTable();
        }
        
    }
    public void getGUIInstructor(){
        new InstructorVersion();
    }
}    