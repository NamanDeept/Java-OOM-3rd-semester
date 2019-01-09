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