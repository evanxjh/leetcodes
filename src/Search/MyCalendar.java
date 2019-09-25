package Search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EvanHsia
 * @ClassName MyCalendar.java
 * @Description No.729 Medium
 * @createTime 2019-09-25- 13:23
 */
public class MyCalendar {
    private List<Event> data;
    public MyCalendar(){
        data=new ArrayList<>();
    }

    private boolean overlapped(Event e1,Event e2){
        return e1.start<e2.end && e2.start<e1.end;
    }

    public boolean book(int start,int end){
        Event newEvent=new Event(start,end);
        for (Event e:data){
            if (overlapped(e,newEvent)){
                return false;
            }
        }
        data.add(newEvent);
        return true;
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
