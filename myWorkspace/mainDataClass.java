import java.io.*;
import java.util.*;
import java.lang.*;

public class mainDataClass{
    /*
     * This is the main class where all the standard inputs have been considered
     */
    public static void main(String []args)throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            ArrayClassEvents ace = new ArrayClassEvents();
            day dObj;
            event eObj;
            int numberEvents = sc.nextInt();
            for(int i=0;i<numberEvents;i++){
                String eventId = sc.next();
                String eventName = sc.next();
                String eventDesc = sc.next();
                int dayNum = sc.nextInt();
                String evTime = sc.next();
                int duration = sc.nextInt();
                eObj = new event(eventId,eventName,eventDesc,dayNum,evTime,duration);
                dObj = new day(dayNum);
                ace.addEvent(eObj);
            }
            ace.addDay();
            ace.sortDay();
            for(int i=0;i<ace.countDay();i++){
                ace.displayDay(ace.getDay(i));
                ace.getDay(i).displayDayEvents();
            }   
        }
    }
}