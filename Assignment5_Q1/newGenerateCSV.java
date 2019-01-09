import java.io.*;
import java.util.*;
import java.lang.*;

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
 