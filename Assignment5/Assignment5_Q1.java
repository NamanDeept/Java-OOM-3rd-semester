import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

public class DisplayFrame extends screenGUI{
    public static void main(String []args){
      createFrame frame = new createFrame();
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.setSize(GetScreenWidth(),GetScreenHeight());
      frame.setVisible(true);
    }
}

import java.util.Collections;

class Student
{
    /* A student class contains the details of the student
     * Including the details of the marks in each Question along with the total marks obtianed
     */
    private String studentRoll;
    private String studentName;
    private int marks1;
    private int marks2;
    private int marks3;
    private int marks4;
    private int marks5;
    public Student(String studentRoll,String StudentName,int marks1,int marks2,int marks3,int marks4,int marks5){
        this.studentRoll = studentRoll;
        this.studentName = studentName;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
        this.marks4 = marks4;
        this.marks5 = marks5;
    }
    //getters and setter functions
    public int getMarks1(){
        return marks1;
    }
     public int getMarks2(){
        return marks2;
    }
     public int getMarks3(){
        return marks3;
    }
     public int getMarks4(){
        return marks4;
    }
     public int getMarks5(){
        return marks5;
    }
    public String getStudentName(){
        return studentName;
    }
    public String getStudentRoll(){
        return studentRoll;
    }
    public int getTotalMarks(){
        return marks1+marks2+marks3+marks4+marks5;
    }
    
    public void setStudentName(String name){
        this.studentName = name;
    }
    public void setStudentRoll(String roll){
        this.studentRoll = roll;
    }
    public void setStudentMarks1(int mrks){
       marks1 = mrks;
    }
    public void setStudentMarks2(int mrks){
       marks2 = mrks;
    }
    public void setStudentMarks3(int mrks){
       marks3 = mrks;
    }
    public void setStudentMarks4(int mrks){
       marks4 = mrks;
    }
    public void setStudentMarks5(int mrks){
       marks5 = mrks;
    }
}



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
                createJTable c = new createJTable();
                c.createTable();
            }
            else if(event.getSource() == searchButton){
                searchRoll sr = new searchRoll();
                sr.perform();
               // System.out.println("clicked search button");
            }
        } 
    }
}
    
/* This class contains global variables
 * Screen width and screen height taking into account for a good display
 */
public abstract class screenGUI{
    private static final int screen_width = 800;
    private static final int screen_height = 600;
    public int getScreenWidth(){
        return screen_width;
    }
    public int getScreenHeight(){
        return screen_height;
    }
     public static  int GetScreenWidth(){
        return screen_width;
    }
    public static int GetScreenHeight(){
        return screen_height;
    }
        
}


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
        
class createJTable extends screenGUI
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
        table.setCellSelectionEnabled(true);
        table.setAutoCreateRowSorter(true);
        table.setBounds(0,0,getScreenWidth(),getScreenHeight());
        jsp = new JScrollPane(table);
       
        frame.setSize(getScreenWidth(),getScreenHeight());
        frame.add(jsp);
        frame.setVisible(true);
    }    
}

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
class iEditOrAdd{
    private Scanner scanner;
    private Formatter formatter;
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
                formatter = new Formatter("newCSV.csv");
            }
            catch(Exception ex){}
            String tempLine ="";
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                String sarr[]= line.split(",");
                if(Integer.parseInt(sarr[0]) == index){
                    tempLine = line;
                    break;
                }
            }
            String newArr[] =tempLine.split(",");
            formatter.format("%d,%s,%s,%s,%s,%s,%s,%s\n",index,rollNum,"new Name",newArr[3],newArr[4],newArr[5],newArr[6],newArr[7],newArr[8]);
            formatter.close();
        }
        else{
            /*
             * No such student in the directory exist so append that student to that csv file
             */
            
            try{
                formatter = new Formatter("newCSV.csv");
            }
            catch(Exception e){}
            formatter.format("%d,%s,%s,%d,%d,%d,%d,%d\n",als.getLength(),rollNum,"new Name",num1,num2,num3,num4,num5);
            formatter.close();

        } 
    }
}
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
        for(int i=0; i < als.getLength();i++){
          if(als.getStudent(i) != s){
              Student stud = als.getStudent(i);
              formatter.format("%d,%s,%s,%d,%d,%d,%d,%d",i,stud.getStudentRoll(),stud.getStudentName(),stud.getMarks1(),stud.getMarks2(),stud.getMarks3(),stud.getMarks4(),stud.getMarks5());
            }        
        }        
    }    
}
class SummaryVersion extends screenGUI{
    private JLabel MaximumQ1;
    private JLabel MaximumQ2;
    private JLabel MaximumQ3;
    private JLabel MaximumQ4;
    private JLabel MaximumQ5;
    private JLabel MaximumTotal;
    private JLabel MinimumQ1;
    private JLabel MinimumQ2;
    private JLabel MinimumQ3;
    private JLabel MinimumQ4;
    private JLabel MinimumQ5;
    private JLabel MinimumTotal;
    private JLabel MeanQ1;
    private JLabel MeanQ2;
    private JLabel MeanQ3;
    private JLabel MeanQ4;
    private JLabel MeanQ5;
    private JLabel MeanTotal;
    private JLabel MedianQ1;
    private JLabel MedianQ2;
    private JLabel MedianQ3;
    private JLabel MedianQ4;
    private JLabel MedianQ5;
    private JLabel MedianTotal;
    private JTextField iMaximumQ1;
    private JTextField iMaximumQ2;
    private JTextField iMaximumQ3;
    private JTextField iMaximumQ4;
    private JTextField iMaximumQ5;
    private JTextField iMaximumTotal;
    private JTextField iMinimumQ1;
    private JTextField iMinimumQ2;
    private JTextField iMinimumQ3;
    private JTextField iMinimumQ4;
    private JTextField iMinimumQ5;
    private JTextField iMinimumTotal;
    private JTextField iMeanQ1;
    private JTextField iMeanQ2;
    private JTextField iMeanQ3;
    private JTextField iMeanQ4;
    private JTextField iMeanQ5;
    private JTextField iMeanTotal;
    private JTextField iMedianQ1;
    private JTextField iMedianQ2;
    private JTextField iMedianQ3;
    private JTextField iMedianQ4;
    private JTextField iMedianQ5;
    private JTextField iMedianTotal;

    public SummaryVersion(){
        computeData cd = new computeData();
        MaximumQ1 = new JLabel("Maximum of Q1");
        MaximumQ1.setBounds(5,30,200,30);
        iMaximumQ1 = new JTextField(String.format("%d",cd.ComputeMaxQ1()));
        iMaximumQ1.setBounds(210,30,200,30);
        iMaximumQ1.setEditable(false);
        MaximumQ2 = new JLabel("Maximum of Q2");
        MaximumQ2.setBounds(5,70,200,30);
        iMaximumQ2 = new JTextField(String.format("%d",cd.ComputeMaxQ2()));
        iMaximumQ2.setBounds(210,70,200,30);
        iMaximumQ2.setEditable(false);
        MaximumQ3 = new JLabel("Maximum of Q3");
        MaximumQ3.setBounds(5,110,200,30);
        iMaximumQ3 = new JTextField(String.format("%d",cd.ComputeMaxQ3()));
        iMaximumQ3.setBounds(210,110,200,30);
        iMaximumQ3.setEditable(false);
        MaximumQ4= new JLabel("Maximum of Q4");
        MaximumQ4.setBounds(5,150,200,30);
        iMaximumQ4 = new JTextField(String.format("%d",cd.ComputeMaxQ4()));
        iMaximumQ4.setBounds(210,150,200,30);
        iMaximumQ4.setEditable(false);
        MaximumQ5= new JLabel("Maximum of Q5");
        MaximumQ5.setBounds(5,190,200,30);
        iMaximumQ5 = new JTextField(String.format("%d",cd.ComputeMaxQ5()));
        iMaximumQ5.setBounds(210,190,200,30);
        iMaximumQ5.setEditable(false);
        MaximumTotal= new JLabel("Maximum of Total");
        MaximumTotal.setBounds(5,230,200,30);
        iMaximumTotal = new JTextField(String.format("%d",cd.ComputeMaxTotal()));
        iMaximumTotal.setBounds(210,230,200,30);
        iMaximumTotal.setEditable(false);
        MinimumQ1 = new JLabel("Minimum of Q1");
        MinimumQ1.setBounds(5,270,200,30);
        iMinimumQ1 = new JTextField(String.format("%d",cd.ComputeMinQ1()));
        iMinimumQ1.setBounds(210,270,200,30);
        iMinimumQ1.setEditable(false);
        MinimumQ2 = new JLabel("Minimum of Q2");
        MinimumQ2.setBounds(5,310,200,30);
        iMinimumQ2 = new JTextField(String.format("%d",cd.ComputeMinQ2()));
        iMinimumQ2.setBounds(210,310,200,30);
        iMinimumQ2.setEditable(false);
        MinimumQ3 = new JLabel("Minimum of Q3");
        MinimumQ3.setBounds(5,350,200,30);
        iMinimumQ3 = new JTextField(String.format("%d",cd.ComputeMinQ3()));
        iMinimumQ3.setBounds(210,350,200,30);
        iMinimumQ3.setEditable(false);
        MinimumQ4= new JLabel("Minimum of Q4");
        MinimumQ4.setBounds(5,390,200,30);
        iMinimumQ4 = new JTextField(String.format("%d",cd.ComputeMinQ4()));
        iMinimumQ4.setBounds(210,390,200,30);
        iMinimumQ4.setEditable(false);
        MinimumQ5= new JLabel("Minimum of Q5");
        MinimumQ5.setBounds(5,430,200,30);
        iMinimumQ5 = new JTextField(String.format("%d",cd.ComputeMinQ5()));
        iMinimumQ5.setBounds(210,430,200,30);
        iMinimumQ5.setEditable(false);
        MinimumTotal= new JLabel("Minimum of Total");
        MinimumTotal.setBounds(5,470,200,30);
        iMinimumTotal= new JTextField(String.format("%d",cd.ComputeMinTotal()));
        iMinimumTotal.setBounds(210,470,200,30);
        iMinimumTotal.setEditable(false);
        MeanQ1 = new JLabel("Mean of Q1");
        MeanQ1.setBounds(5,510,200,30);
        iMeanQ1 = new JTextField(String.format("%f",cd.ComputeMeanQ1()));
        iMeanQ1.setBounds(210,510,200,30);
        iMeanQ1.setEditable(false);
        MeanQ2 = new JLabel("Mean of Q2");
        MeanQ2.setBounds(5,550,200,30);
        iMeanQ2 = new JTextField(String.format("%f",cd.ComputeMeanQ2()));
        iMeanQ2.setBounds(210,550,200,30);
        iMeanQ2.setEditable(false);
        MeanQ3= new JLabel("Mean of Q3");
        MeanQ3.setBounds(5,590,200,30);
        iMeanQ3 = new JTextField(String.format("%f",cd.ComputeMeanQ3()));
        iMeanQ3.setBounds(210,590,200,30);
        iMeanQ3.setEditable(false);
        MeanQ4= new JLabel("Mean of Q4");
        MeanQ4.setBounds(5,630,200,30);
        iMeanQ4 = new JTextField(String.format("%f",cd.ComputeMeanQ4()));
        iMeanQ4.setBounds(210,630,200,30);
        iMeanQ4.setEditable(false);
        MeanQ5 = new JLabel("Mean of Q5");
        MeanQ5.setBounds(5,670,200,30);
        iMeanQ5 = new JTextField(String.format("%f",cd.ComputeMeanQ5()));
        iMeanQ5.setBounds(210,670,200,30);
        iMeanQ5.setEditable(false);
        MeanTotal = new JLabel("Mean of Total");
        MeanTotal.setBounds(5,710,200,30);
        iMeanTotal = new JTextField(String.format("%f",cd.ComputeMeanTotal()));
        iMeanTotal.setBounds(210,710,200,30);
        iMeanTotal.setEditable(false);
        MedianQ1 = new JLabel("Median of Q1");
        MedianQ1.setBounds(5,750,200,30);
        iMedianQ1 = new JTextField();
        iMedianQ1.setBounds(210,750,200,30);
        iMedianQ1.setEditable(false);
        MedianQ2 = new JLabel("Median of Q2");
        MedianQ2.setBounds(5,790,200,30);
        iMedianQ2 = new JTextField();
        iMedianQ2.setBounds(210,790,200,30);
        iMedianQ2.setEditable(false);
        MedianQ3= new JLabel("Median of Q3");
        MedianQ3.setBounds(5,830,200,30);
        iMedianQ3 = new JTextField();
        iMedianQ3.setBounds(210,830,200,30);
        iMedianQ3.setEditable(false);
        MedianQ4 = new JLabel("Median of Q4");
        MedianQ4.setBounds(5,870,200,30);
        iMedianQ4 = new JTextField();
        iMedianQ4.setBounds(210,870,200,30);
        iMedianQ4.setEditable(false);
        MedianQ5= new JLabel("Median of Q5");
        MedianQ5.setBounds(5,910,200,30);
        iMedianQ5 = new JTextField();
        iMedianQ5.setBounds(210,910,200,30);
        iMedianQ5.setEditable(false);
        MedianTotal = new JLabel("Median of Total");
        MedianTotal.setBounds(5,950,200,30);
        iMedianTotal = new JTextField();
        iMedianTotal.setBounds(210,950,200,30);
        iMedianTotal.setEditable(false);
        JScrollPane jsp = new JScrollPane();
        JFrame frame = new JFrame("SUMMARY TABLE");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(MaximumQ1);
        frame.add(iMaximumQ1);
        frame.add(MaximumQ2);
        frame.add(MaximumQ3);
        frame.add(MaximumQ4);
        frame.add(MaximumQ5);
        frame.add(MaximumTotal);
        frame.add(MinimumQ1);
        frame.add(MinimumQ2);
        frame.add(MinimumQ3);
        frame.add(MinimumQ4);
        frame.add(MinimumQ5);
        frame.add(MinimumTotal);
        frame.add(MeanQ1);
        frame.add(MeanQ2);
        frame.add(MeanQ3);
        frame.add(MeanQ4);
        frame.add(MeanQ5);
        frame.add(MeanTotal);
        frame.add(MedianQ1);
        frame.add(MedianQ2);
        frame.add(MedianQ3);
        frame.add(MedianQ4);
        frame.add(MedianQ5);
        frame.add(MedianTotal);
       
        frame.add(iMaximumQ2);
        frame.add(iMaximumQ3);
        frame.add(iMaximumQ4);
        frame.add(iMaximumQ5);
        frame.add(iMaximumTotal);
        frame.add(iMinimumQ1);
        frame.add(iMinimumQ2);
        frame.add(iMinimumQ3);
        frame.add(iMinimumQ4);
        frame.add(iMinimumQ5);
        frame.add(iMinimumTotal);
        frame.add(iMeanQ1);
        frame.add(iMeanQ2);
        frame.add(iMeanQ3);
        frame.add(iMeanQ4);
        frame.add(iMeanQ5);
        frame.add(iMeanTotal);
        frame.add(iMedianQ1);
        frame.add(iMedianQ2);
        frame.add(iMedianQ3);
        frame.add(iMedianQ4);
        frame.add(iMedianQ5);
        frame.add(iMedianTotal);
        frame.setVisible(true);
        frame.setSize(2*getScreenWidth(),10*getScreenHeight());
        frame.add(jsp);
        
    }
    public void displayGUISummary(){
        new SummaryVersion();
    }
}
class computeData{
    private ArrayListStudents als = new ArrayListStudents();
    public int ComputeMaxQ1(){
        try{
            als.createList();
        }catch(Exception e){}
        int max =0;
        for(int i=0;i<als.getLength();i++){
            if(max < als.getStudent(i).getMarks1()){
                max = als.getStudent(i).getMarks1();
            }
        }
        return max;
    }
   

    public int ComputeMaxQ2(){
        try{
            als.createList();
        }catch(Exception e){}
        int max =0;
        for(int i=0;i<als.getLength();i++){
            if(max < als.getStudent(i).getMarks2()){
                max = als.getStudent(i).getMarks2();
            }
        }
        return max;
    }

    public int ComputeMaxQ3(){
        try{
            als.createList();
        }catch(Exception e){}
        int max =0;
        for(int i=0;i<als.getLength();i++){
            if(max < als.getStudent(i).getMarks3()){
                max = als.getStudent(i).getMarks3();
            }
        }
        return max;
    }

    public int ComputeMaxQ4(){
        try{
            als.createList();
        }catch(Exception e){}
        int max =0;
        for(int i=0;i<als.getLength();i++){
            if(max < als.getStudent(i).getMarks4()){
                max = als.getStudent(i).getMarks4();
            }
        }
        return max;
    }

    public int ComputeMaxQ5(){
        try{
            als.createList();
        }catch(Exception e){}
        int max =0;
        for(int i=0;i<als.getLength();i++){
            if(max < als.getStudent(i).getMarks5()){
                max = als.getStudent(i).getMarks5();
            }
        }
        return max;
    }

    public int ComputeMaxTotal(){
        try{
            als.createList();
        }catch(Exception e){}
        int max =0;
        for(int i=0;i<als.getLength();i++){
            if(max < als.getStudent(i).getTotalMarks()){
                max = als.getStudent(i).getTotalMarks();
            }
        }
        return max;
    }
    public int ComputeMinQ1(){
         try{
            als.createList();
        }catch(Exception e){}
        int min =als.getStudent(0).getMarks1();
        for(int i=0;i<als.getLength();i++){
            if(min> als.getStudent(i).getMarks1()){
                min = als.getStudent(i).getMarks1();
            }
        }
        return min;
    }
     public int ComputeMinQ2(){
         try{
            als.createList();
        }catch(Exception e){}
        int min =als.getStudent(0).getMarks2();
        for(int i=0;i<als.getLength();i++){
            if(min> als.getStudent(i).getMarks2()){
                min = als.getStudent(i).getMarks2();
            }
        }
        return min;
    }
     public int ComputeMinQ3(){
         try{
            als.createList();
        }catch(Exception e){}
        int min =als.getStudent(0).getMarks3();
        for(int i=0;i<als.getLength();i++){
            if(min> als.getStudent(i).getMarks3()){
                min = als.getStudent(i).getMarks3();
            }
        }
        return min;
    }
     public int ComputeMinQ4(){
         try{
            als.createList();
        }catch(Exception e){}
        int min =als.getStudent(0).getMarks4();
        for(int i=0;i<als.getLength();i++){
            if(min> als.getStudent(i).getMarks4()){
                min = als.getStudent(i).getMarks4();
            }
        }
        return min;
    }
     public int ComputeMinQ5(){
         try{
            als.createList();
        }catch(Exception e){}
        int min =als.getStudent(0).getMarks5();
        for(int i=0;i<als.getLength();i++){
            if(min> als.getStudent(i).getMarks5()){
                min = als.getStudent(i).getMarks5();
            }
        }
        return min;
    } 
    public int ComputeMinTotal(){
         try{
            als.createList();
        }catch(Exception e){}
        int min =als.getStudent(0).getTotalMarks();
        for(int i=0;i<als.getLength();i++){
            if(min> als.getStudent(i).getTotalMarks()){
                min = als.getStudent(i).getTotalMarks();
            }
        }
        return min;
    }
    public float ComputeMeanQ1(){
         try{
            als.createList();
        }catch(Exception e){}
        int sum =0;
        for(int i=0;i<als.getLength();i++){
            sum+= als.getStudent(i).getMarks1();
        }
        return sum/als.getLength();
    } 
    public float ComputeMeanQ2(){
         try{
            als.createList();
        }catch(Exception e){}
        int sum =0;
        for(int i=0;i<als.getLength();i++){
            sum+= als.getStudent(i).getMarks2();
        }
        return sum/als.getLength();
    }
    public float ComputeMeanQ3(){
         try{
            als.createList();
        }catch(Exception e){}
        int sum =0;
        for(int i=0;i<als.getLength();i++){
            sum+= als.getStudent(i).getMarks3();
        }
        return sum/als.getLength();
    }
    public float ComputeMeanQ4(){
         try{
            als.createList();
        }catch(Exception e){}
        int sum =0;
        for(int i=0;i<als.getLength();i++){
            sum+= als.getStudent(i).getMarks4();
        }
        return sum/als.getLength();
    }
    public float ComputeMeanQ5(){
         try{
            als.createList();
        }catch(Exception e){}
        int sum =0;
        for(int i=0;i<als.getLength();i++){
            sum+= als.getStudent(i).getMarks5();
        }
        return sum/als.getLength();
    }
    public float ComputeMeanTotal(){
         try{
            als.createList();
        }catch(Exception e){}
        int sum =0;
        for(int i=0;i<als.getLength();i++){
            sum+= als.getStudent(i).getTotalMarks();
        }
        return sum/als.getLength();
    }
}


class newGenerateCSV{
    public void readAndWrite()throws IOException,FileNotFoundException
    {
        File file = new File("AttendanceSheet_IOOM332C_[01.10.2018].csv");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line ="";
        String []tempArr;
        while((line=br.readLine())!=null){
            tempArr = line.split(",");
            String filePath = "newCSV.txt";
            int mark1 = (int)(Math.random()*6);
            int mark2 =(int)(Math.random()*6);
            int mark3 =(int)(Math.random()*6);
            int mark4 =(int)(Math.random()*6);
            int mark5 =(int)(Math.random()*6);
            saveRecord(tempArr[0],tempArr[1],tempArr[2],mark1,mark2,mark3,mark4,mark5,filePath);
        }
    }

    public void saveRecord(String snum,String rnum,String name,int a,int b,int c,int d,int e,String fileName)throws IOException,FileNotFoundException{
        FileWriter fw = new FileWriter(fileName,true);
        BufferedWriter br = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(br);
        pw.println(snum+"\t"+rnum+"\t"+name+"\t"+a+"\t"+b+"\t"+c+"\t"+d+"\t"+e+"\t");
        pw.flush();
        pw.close();

    }
}
