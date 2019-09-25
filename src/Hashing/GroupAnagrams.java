package Hashing;

import java.util.*;

/**
 * @author EvanHsia
 * @ClassName GroupAnagrams.java
 * @Description No.49 Medium
 * @createTime 2019-09-25- 12:41
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> res=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        for (String s:strs){
            char[] chars=s.toCharArray();
            Arrays.sort(chars);
            String sortedStr=new String(chars);
            if (!map.containsKey(sortedStr)){
                map.put(sortedStr,new ArrayList<>());
            }
            map.get(sortedStr).add(s);
        }
        res.addAll(map.values());
        return res;
    }
}
