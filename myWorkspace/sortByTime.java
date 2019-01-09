import java.lang.*;
import java.io.*;
import java.util.*;
public class sortByTime implements Comparator<event>
{
    public int compare(event e1,event e2)
    { 
        return e1.event_timing.compareTo(e2.event_timing);
    }
}