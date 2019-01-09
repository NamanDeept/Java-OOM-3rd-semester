import java.util.Scanner;
import java.util.*;

class ArrayClass{
    private Student students[];
    private Question questions[];
     int countStudents = 0;
     int countQuestions = 0;
    
    public ArrayClass(int numberOfStudents,int numberOfQuestions){
        students= new Student[numberOfStudents];
        questions = new Question[numberOfQuestions];
    }
    
    public void BubbleSort(int number){
        Student tempStudent = null;
        /*a null reference to a temporary student */
        for(int i = 0 ; i < number-1 ; i++){
            for(int j = 0 ; j < number - i -1; j++){
                if(students[j].getStudentRoll().compareTo(students[j+1].getStudentRoll())>0)
                {
                    tempStudent = students[j];
                    students[j] = students[j+1];
                    students[j+1] = tempStudent;
                }
            }
        }
    }
    
    /*Getter methods */
    public Student getStudent(int index){
        return students[index];
    }
    public Question getQuestion(int index){
        return questions[index];
    }
    
    public void addStudent(Student s){
        students[countStudents++] = s;
    }
    
    public void addQuestion(Question q){
        questions[countQuestions++] = q;
    }
}
        
    
                                      
              
public class Assign_4_Q2{
    public static void main(String args[]){
        Scanner data = new Scanner(System.in);
        int testCases = data.nextInt();
        for(int t = 0 ; t<testCases ; t++){
            int numberOfQuestions = data.nextInt();
            int numberOfStudents = data.nextInt();
            String string = data.nextLine();
            ArrayClass ac = new ArrayClass(numberOfStudents,numberOfQuestions);
            String specialQuestion ="";
            Question ques;
            Student s;
            for(int i=0 ; i<numberOfQuestions ; i++){
                String quesId = data.next();
                String quesType = data.next();
                String quesText = data.next();
                int quesMarks = data.nextInt();
                ques = new Question(quesId,quesType,quesText,quesMarks);
                ac.addQuestion(ques);
            }
            int counter = 0;
            for(int i=0 ; i<numberOfStudents ; i++){
                String roll = data.next();
                String name = data.next();
                int numberAttempted = data.nextInt();
                s = new Student(roll,name,numberAttempted);
                ac.addStudent(s);
                int q_index = 0;
                
                for(int j = 0 ; j < numberAttempted ;j++){
                    String quesid = data.next();
                    String text = data.next();
                    counter++;
                    for(int k= 0 ; k < numberOfQuestions; k++){
                        if(ac.getQuestion(k).getQuestionId().equals(quesid)){
                         q_index =k;
                        }
                        
                    }
                    if(ac.getQuestion(q_index).getQuestionType().equals("specialized")){
                        int references = data.nextInt();
                        for(int k=0;k<references;k++){
                            String ref = data.next();
                       }
                    }
                }
            }
            /*Now getting the actual marks of the student */
            
            for(int i=0;i<counter;i++){
                String roll_n = data.next();
                String ques_n = data.next();
                int mrks = data.nextInt();
                int index_student=0;
                int index_question = 0;
                int cnt = 0;
                int index = 0;
                for(int j = 0 ; j < numberOfStudents ;j++){
                    if(ac.getStudent(j).getStudentRoll().equals(roll_n)){
                        index_student = j;
                        break;
                    }
                }
                for(int k = 0 ; k < numberOfQuestions ;k++){
                    if(ac.getQuestion(k).getQuestionId().equals(ques_n)){
                        index_question = k;
                        break;
                    }
                }
                Question qu = ac.getQuestion(index_question);
                int marks = qu.getQuestionMarks();
                Student std = ac.getStudent(index_student);
                if(mrks > marks){
                    std.addQuestionMarks(marks);
                  }
                 else if(mrks < 0)
                  std.addQuestionMarks(0);
                  else 
                  std.addQuestionMarks(mrks);
                
             }
             
             ac.BubbleSort(numberOfStudents);
             for(int i = 0 ; i < numberOfStudents ; i++){
                 Student var = ac.getStudent(i);
                 System.out.printf("%s %s %d\n",var.getStudentRoll(),var.getStudentName(),var.getTotal());
                }
            }
        }
    }
                                      
              
    class Student{
    private String StudentName;
    private String StudentRoll;
    private ArrayList<Question> questions;
    private ArrayList<Integer>QuestionMarks;
    
    public Student(String roll,String name,int numberOfAttempts){
        StudentName = name;
        StudentRoll = roll;
        questions = new ArrayList<Question>();
        QuestionMarks = new ArrayList<Integer>();
    }

    
    /*getter methods */
    public String getStudentName(){
        return StudentName;
    }
    public String getStudentRoll(){
        return StudentRoll;
    }
    public Question getQuestion(int index){
        return questions.get(index);
    }
    
    /*setter functions */
    public void setStudentName(String Name){
        StudentName = Name;
    }
    public void setStudentRoll(String Roll){
        StudentRoll = Roll;
    }
    
    public void addQuestion(Question ques){
        questions.add(ques);
    }
    public void addQuestionMarks(int marks){
       QuestionMarks.add(marks);
    }
    
    
    public int getTotal(){
        int total = 0;
        for(int questionMarks : QuestionMarks){
            total += questionMarks;
        }
        return total;
    }
}
    
  class Question{
    private String QuestionId;
    private String QuestionType;
    private String QuestionText;
    private int QuestionMarks;
    
    public Question(String quesId,String QuesType,String QuesText,int marks){
        QuestionId = quesId;
        QuestionType = QuesType;
        QuestionText = QuesText;
        QuestionMarks = marks;
    }
    
    public Question(String quesId,String QuesText,int marks){
        QuestionId = quesId;
        QuestionText = QuesText;
        QuestionMarks = marks;
    }
    
    /*Getter methods */
    public String getQuestionId(){
        return QuestionId;
    }
    public String getQuestionType(){
        return QuestionType;
    }
    public String getQuestionText(){
        return QuestionText;
    }
    public int getQuestionMarks(){
        return QuestionMarks;
    }
    
    /*Setter Methods */
    public void setQuestionId(String qID){
        QuestionId = qID;
    }
    public void setQuestionType(String qType){
        QuestionType = qType;
    }
    public void setQuestionText(String text){
        QuestionText = text;
    }
    public void setQuestionMarks(int mrks){
        QuestionMarks = mrks;
    }
}
