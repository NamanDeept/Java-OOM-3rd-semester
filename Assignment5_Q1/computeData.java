import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

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
