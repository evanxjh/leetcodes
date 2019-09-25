package Search;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author EvanHsia
 * @ClassName MyCalendarTwo.java
 * @Description No.731 Medium
 * @createTime 2019-09-25- 13:31
 */
public class MyCalendarTwo {
    Set<Event> calendar;
    //记录重叠的区间
    Set<Event> overlap;

    public MyCalendarTwo(){
        calendar=new HashSet<>();
        overlap=new HashSet<>();
    }

    public boolean book(int start,int end){
        Event newEvent=new Event(start,end);
        for (Event e:overlap){
            if (overlapped(e,newEvent)){
                return false;
            }
        }

        for (Event e:calendar){
            if (overlapped(e,newEvent)){
                overlap.add(new Event(Math.max(e.start,newEvent.start),Math.min(e.end,newEvent.end)));
            }
        }
        calendar.add(newEvent);
        return true;
    }

    private boolean overlapped(Event e1,Event e2){
        return e1.start<e2.end && e2.start<e1.end;
    }
    private class Event{
        int start;
        int end;
        public Event(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
}
