import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

class searchRoll extends screenGUI implements ActionListener{
    private JFrame frame;
    private JButton SubmitButton;
    private JLabel Question;
    private JTextField textArea;
    private JLabel empty;
    
    searchRoll(){
        frame = new JFrame("MARKS BY ROLL NUMBER");
        frame.setLayout(null);
        SubmitButton = new JButton("SUBMIT");
        Question = new JLabel("ENTER THE ROLL");
        textArea = new JTextField();
        textArea.setEditable(true);
        empty =    new JLabel();
        Question.setBounds(10,10,150,30);
        SubmitButton.setBounds(100,100,200,50);
        textArea.setBounds(180,10,200,40);
        empty.setBounds(20,50,300,30);
        SubmitButton.addActionListener(this);
        frame.setSize(getScreenWidth(),getScreenHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(Question);
        frame.add(textArea);
        frame.add(SubmitButton);
        frame.add(empty);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
            String txt = textArea.getText();
            if(e.getSource() == SubmitButton){
               ArrayListStudents als = new ArrayListStudents();
               try{
                   als.createList();
                }catch(Exception ex){}
                int num1=als.getMark1ByRoll(txt);
                int num2=als.getMark2ByRoll(txt);
                int num3=als.getMark3ByRoll(txt);
                int num4=als.getMark4ByRoll(txt);
                int num5=als.getMark5ByRoll(txt);
                if(num1 == -1){
                    empty.setText("Invalid Roll Number Entered");
                }
                 else
                empty.setText(String.format("Q1:%d Q2:%d Q3:%d Q4:%d Q5:%d TOTAL:%d",num1,num2,num3,num4,num5,num1+num2+num3+num4+num5));
        }
        }
    
    public void perform(){
        new searchRoll();
    }
}
        
    