import java.util.*;
import java.io.*;
import java.lang.*;
class event
{
    private String event_id;
    private String event_name;
    private String event_description;
    private int event_day;
    public String event_timing;
    public int event_duration;
    public day eventDay;
    public event(String event_id,String event_name,String event_description,int event_day,String event_timing,int event_duration){
        this.event_id = event_id;
        this.event_name = event_name;
        this.event_description = event_description;
        this.event_day = event_day;
        this.event_timing = event_timing;
        this.event_duration = event_duration;
    }
    public event(String event_id,String event_name,String event_description,day eventDay,String event_timing,int event_duration){
        this.event_id = event_id;
        this.event_name = event_name;
        this.event_description = event_description;
        this.eventDay = eventDay;
        this.event_timing = event_timing;
        this.event_duration = event_duration;
    }
    public String getEventID(){
        return event_id;
    }
    public String getEventName(){
        return event_name;
    }
    public String getEventDescription(){
        return event_description;
    } 
    public int getEventDay(){
        return event_day;
    }
    public String getEventTiming(){
        return event_timing;
    }
    public int getEventDuration(){
        return event_duration;
    }
    public day getEventDay1(){
        return eventDay;
    }
}
