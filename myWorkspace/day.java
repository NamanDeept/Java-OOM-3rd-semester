 import java.util.*;
class day{
    private int day_value;
    public ArrayList <event> ev;
    public day(int value){
        day_value = value;
        ev = new ArrayList<event>();
    }

    public void addEvent(event e){
        ev.add(e);
    }

    /*getters */
    public event getEvent(int index){
        return ev.get(index);
    }

    public int getDayValue(){
        return day_value;
    }

    public void sortEvent(){
        Collections.sort(ev,new sortByTime());
    }

    public void displayDayEvents(){
        sortEvent();
        for(int i=0;i<ev.size();i++){
            System.out.printf("%s (%d) %s %s %s\n",ev.get(i).getEventTiming(),ev.get(i).getEventDuration(),ev.get(i).getEventID(),ev.get(i).getEventName(),ev.get(i).getEventDescription());

        }
    }
}