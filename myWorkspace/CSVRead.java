import java.io.*;
/* 
The following program implements the reading of a CSV file which is included in my workspace file and outputing it to the console
 */

class CSVRead{
    public static void readFile(String fileName)throws FileNotFoundException,IOException{
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line = "";
        String[] tempArr;
        while ((line = br.readLine()) != null) {
            tempArr = line.split(",");
            for (String tempStr : tempArr) {
                System.out.print(tempStr + " ");
            }
            System.out.println();
        }
        br.close();
    } 
    public static void main(String args[])throws IOException{
        String myFile ="iris.csv";
        readFile(myFile);
    }
}


                
