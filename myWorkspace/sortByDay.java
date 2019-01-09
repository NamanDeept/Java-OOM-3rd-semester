 import java.util.*;

public class sortByDay implements Comparator<day>{
    public int compare(day d1,day d2){
        return d1.getDayValue() - d2.getDayValue();
    }
}
