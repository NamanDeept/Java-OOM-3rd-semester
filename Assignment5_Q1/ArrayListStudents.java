import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

class ArrayListStudents{
    private ArrayList <Student> s;

    public void createList()throws FileNotFoundException,IOException{
        s = new ArrayList<Student>();
        Scanner scan = new Scanner(new File("newCSV.csv"));
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String []sArr = line.split(",");
            int mr[] = new int[5];
            for(int i=3;i<8;i++){
                mr[i-3] = Integer.parseInt(sArr[i]);
            }
            Student s_= new Student(sArr[1],sArr[2],mr[0],mr[1],mr[2],mr[3],mr[4]);
            s.add(s_);
        }
        // System.out.println(als.getStudent(5).getStudentRoll());
    }

    public ArrayListStudents(){
        s = new ArrayList<Student>();
    }

    public void addStudent(Student st){
        s.add(st);
    }

    public Student getStudent(int index){
        return s.get(index);
    }

    public int getLength(){
        return s.size();
    }

    public ArrayList getList(){
        return s;
    }

    public int getMark1ByRoll(String Roll){
        int mrks = -1;
        for(Student x:s){
            if(x.getStudentRoll().equals(Roll))
            {
                mrks =x.getMarks1();
                break;
            }
        }
        return mrks;
    }

    public int getMark2ByRoll(String Roll){
        int mrks = -1;
        for(Student x:s){
            if(x.getStudentRoll().equals(Roll))
            {
                mrks =x.getMarks2();
                break;
            }
        }
        return mrks;
    }

    public int getMark3ByRoll(String Roll){
        int mrks = -1;
        for(Student x:s){
            if(x.getStudentRoll().equals(Roll))
            {
                mrks =x.getMarks3();
                break;
            }
        }
        return mrks;
    }

    public int getMark4ByRoll(String Roll){
        int mrks = -1;
        for(Student x:s){
            if(x.getStudentRoll().equals(Roll))
            {
                mrks =x.getMarks4();
                break;
            }
        }
        return mrks;
    }

    public int getMark5ByRoll(String Roll){
        int mrks = -1;
        for(Student x:s){
            if(x.getStudentRoll().equals(Roll))
            {
                mrks =x.getMarks5();
                break;
            }
        }
        return mrks;
    }

    public Student getStudentByRoll(String rll){
        Student x =null;
        for(Student student:s){
            if(student.getStudentRoll().equals(rll)){
                x= student;
                break;
            }

        }
        return x;
    }

    public int getTotalMarksByRoll(String Roll){
        int total = getMark1ByRoll(Roll)+getMark2ByRoll(Roll)+getMark3ByRoll(Roll)+getMark4ByRoll(Roll)+getMark5ByRoll(Roll);
        return total;
    }
}
