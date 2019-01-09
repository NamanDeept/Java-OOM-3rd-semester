import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

class iDeleteData{
    private Scanner scanner;
    private Formatter formatter;
    public void DeleteContent(String data){
        ArrayListStudents als = new ArrayListStudents();
        try{
            als.createList();
        }
        catch(Exception e){}
        try{
            formatter = new Formatter("createNew.csv");
            scanner = new Scanner(new File("createNew.csv"));
        }catch(Exception ex){}
        while(scanner.hasNextLine()){
            formatter.format("");
        }
        /*
         * Deleting every content of the file 
         * And then rewriting it using the formatter
        */
        Student s=als.getStudentByRoll(data);
        String string ="";
        for(int i=0; i < als.getLength();i++){
          if(als.getStudent(i) != s){
              Student stud = als.getStudent(i);
              string+=String.format("%d,%s,%s,%d,%d,%d,%d,%d\n",i,stud.getStudentRoll(),stud.getStudentName(),stud.getMarks1(),stud.getMarks2(),stud.getMarks3(),stud.getMarks4(),stud.getMarks5());
            }        
        }  
        formatter.format(string);
        formatter.close();
    }    
}