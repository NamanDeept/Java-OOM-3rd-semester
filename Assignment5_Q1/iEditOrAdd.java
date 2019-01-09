import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

class iEditOrAdd{
    private Scanner scanner,scanner1;
    private Formatter formatter,formatter1;

    public void writeToFile(String rollNum,String txt1,String txt2,String txt3,String txt4,String txt5){
        int num1 =Integer.parseInt(txt1);
        int num2 =Integer.parseInt(txt2);
        int num3 =Integer.parseInt(txt3);
        int num4 =Integer.parseInt(txt4);
        int num5 =Integer.parseInt(txt5);
        ArrayListStudents als = new ArrayListStudents();
        try{
            als.createList();
        }
        catch(Exception e){
            System.out.print("File Not Found");
        }
        Student s =null;
        int index =0;
        for(int i=0;i < als.getLength();i++){
            if(als.getStudent(i).getStudentRoll() == rollNum){
                s = als.getStudent(i);
                index =i+1;
                break;
            }
        }
        if(s!=null){
            /* 
             * A student in the dataset already exist ..edit the marks of such student
             */

            try{
                scanner= new Scanner(new File("newCSV.csv"));

            }
            catch(Exception ex){}

            try{

                formatter = new Formatter("newCSV.csv");
            }
            catch(Exception ex){}
            String tempLine ="";
            String string="";
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String newArr[]= line.split(",");
                if(Integer.parseInt(newArr[0]) != index){           
                    string +=line+"\n";
                }
                else{
                    string +=String.format("%d,%s,%s,%d,%d,%d,%d,%d,%d\n",index,rollNum,"New Name",num1,num2,num3,num4,num5,num1+num2+num3+num4+num5);
                }
            }
            formatter.format(string);

                
            formatter.close();
            scanner.close();
        }
        else{
            /*
             * No such student in the directory exist so append that student to that csv file
             */

            try{
                formatter1 = new Formatter("newCSV.csv");
            }
            catch(Exception e){}
            try{
                scanner1 = new Scanner(new File("newCSV.csv"));
            }catch(Exception ex){}
            String string ="";
            while(scanner1.hasNextLine()){
                String line = scanner1.nextLine();

                String newArr[] = line.split(",");
                string+=line+"\n";
            }
            string+=String.format("%d,%s,%s,%d,%d,%d,%d,%d,%d\n",als.getLength(),rollNum,"New Name",num1,num2,num3,num4,num5,num1+num2+num3+num4+num5); 
            formatter1.format(string);
            formatter1.close();
            scanner1.close();
        } 
    }
}