package strings;

import org.apache.logging.log4j.util.PropertySource;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author EvanHsia
 * @ClassName CustomSortString.java
 * @Description No.791 Medium
 * @createTime 2019-10-05- 15:19
 */
public class CustomSortString {
    public String customSortString(String S,String T){
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0;i<S.length();i++){
            map.put(S.charAt(i),i);
        }
        PriorityQueue<Character> pq=new PriorityQueue<>(Comparator.comparingInt(i->map.getOrDefault(i,0)));
        for (int i=0;i<T.length();i++){
            pq.offer(T.charAt(i));
        }
        String res="";
        while (!pq.isEmpty()){
            res+=pq.poll();
        }
        return res;
    }
}
