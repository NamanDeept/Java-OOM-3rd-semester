import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

class createJTableStudent extends screenGUI
{
    private JScrollPane jsp;
    
    private JFrame frame;
    public void createTable(){
        ArrayListStudents als = new ArrayListStudents();
        try{
            als.createList();
        }
        catch(Exception ex){}
        String StudentArr[][] = new String[als.getLength()][8];
        frame = new JFrame("TABLE LAYOUT");
        
        for(int i=0;i<als.getLength();i++){
            StudentArr[i][0] = String.format("%d",i);
            StudentArr[i][1] = als.getStudent(i).getStudentRoll();
            StudentArr[i][2] = String.format("%d",als.getStudent(i).getMarks1());
            StudentArr[i][3] = String.format("%d",als.getStudent(i).getMarks2());
            StudentArr[i][4] = String.format("%d",als.getStudent(i).getMarks3());
            StudentArr[i][5] = String.format("%d",als.getStudent(i).getMarks4());
            StudentArr[i][6] = String.format("%d",als.getStudent(i).getMarks5());
            StudentArr[i][7] = String.format("%d",als.getStudent(i).getTotalMarks());
            //System.out.println(StudentArr[i][1]);
        }
        
        String col[] ={"S.No","ROLL","Q1","Q2","Q3","Q4","Q5","TOTAL"};
        JTable table = new JTable(StudentArr,col);
       
        table.setAutoCreateRowSorter(true);
        table.setBounds(0,0,getScreenWidth(),getScreenHeight());
        jsp = new JScrollPane(table);
       
        frame.setSize(getScreenWidth(),getScreenHeight());
        frame.add(jsp);
        frame.setVisible(true);
    }    
}