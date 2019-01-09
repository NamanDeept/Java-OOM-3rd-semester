import java.util.*;
/*
 * ArrayList can be found in the Collections class of utility package
 * Demonstrated the adding of various events and days in the ArrayList class
 */

class ArrayClassEvents
{
    private ArrayList<day>d;
    private ArrayList <event>e;
    private int countElements=0;
    ArrayClassEvents(){
        d = new ArrayList<day>();
        e = new ArrayList<event>();
    }
    public void addEvent(event ev){
       e.add(ev);
    }
    public void addDay(){
        day dy=null;
        for(int i = 1 ; i <= e.size() ;i++){
            int counter=0;
            for(int j=0;j<e.size();j++){
                if(i == e.get(j).getEventDay()){
                  dy = e.get(j).getEventDay1();
                  
                  dy.addEvent(e.get(j)); 
                }
            }
            if(counter!=0){
                dy.sortEvent();
                d.add(dy);
            }
        }        
    }
    public void displayDay(day d){
        System.out.println("Day "+d.getDayValue());
    }
    public void sortDay(){
        Collections.sort(d,new sortByDay());
    }  
    public int countDay(){
        int count_Day=0;
        for(int i = 1 ; i <= e.size() ;i++){
            int counter=0;
            for(int j=0;j<e.size();j++){
                if(i == e.get(j).getEventDay()){
                   counter++;
                }
            }
            if(counter!=0){
                count_Day++;
            }
        } 
        return count_Day;
    }
    public day getDay(int index){
        return d.get(index);
    }
    public event getEvent(int index){
        return e.get(index);
    }
}
    