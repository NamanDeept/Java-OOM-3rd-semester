import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

class studentVersion extends screenGUI
{
    /* This class is made for the purpose that student button has been clicked
     * So it contains 2 buttons one for getting the marks by entering the roll number
     * And the other one for displaying the marks on a table 
     */
    public void displayGUI(){
        studentVersionGUI svg = new studentVersionGUI();
        svg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        svg.setSize(getScreenWidth(),getScreenHeight());
        svg.setVisible(true);
    }
}
class studentVersionGUI extends JFrame{
    private JButton displayButton;
    private JButton searchButton;
    
    public studentVersionGUI(){
        super("STUDENT'S VERSION");
        setLayout(new FlowLayout());
        displayButton = new JButton("DISPLAY MARKS");
        searchButton = new JButton("GET YOUR MARKS");
        add(searchButton);
        add(displayButton);
        studentHandler handler = new studentHandler();
        displayButton.addActionListener(handler);
        searchButton.addActionListener(handler);
    }
    private class studentHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == displayButton){
               // System.out.println("clicked display button");
                createJTableStudent c = new createJTableStudent();
                c.createTable();
            }
            else if(event.getSource() == searchButton){
                searchRoll sr = new searchRoll();
                sr.perform();
                System.out.println("clicked search button");
            }
        } 
    }
}
    
    