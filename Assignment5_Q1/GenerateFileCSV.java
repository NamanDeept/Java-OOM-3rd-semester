import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/*
 * This class generates a file with data of every student  
 * along with their marks
 */
class GenerateFileCSV{
    private Scanner scanner;
    private Formatter formatter;
    public void openFile(){
        try{
            formatter = new Formatter("newCSV.csv");
        }
        catch(Exception e){
            System.out.println("Could not locate the file:\n");
        }
    }

    public void addRecord()throws NullPointerException{
        try{
            scanner = new Scanner(new File("AttendanceSheet_IOOM332C_[01.10.2018].csv"));
        }
        catch(Exception e){
            System.out.println("Could not locate the file:\n");
        }
        try{
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String []data = line.split(",");
                String rollNumber = data[1];
                String name = data[2];
                String serialNumber = data[0];
                int mark1 = (int)(Math.random()*6);
                int mark2 =(int)(Math.random()*6);
                int mark3 =(int)(Math.random()*6);
                int mark4 =(int)(Math.random()*6);
                int mark5 =(int)(Math.random()*6);
                formatter.format("%s,%s,%s,%d,%d,%d,%d,%d\n",serialNumber,rollNumber,name,mark1,mark2,mark3,mark4,mark5);
            }
        }catch(Exception e){}

    }

public void closeFile(){
        formatter.close();
        scanner.close();
    }

public void generateFile(){
        openFile();
        addRecord();
        closeFile();
    }
}