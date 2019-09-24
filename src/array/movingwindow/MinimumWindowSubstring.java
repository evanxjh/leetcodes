package array.movingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author EvanHsia
 * @ClassName MinimumWindowSubstring.java
 * @Description No.76 Hard
 * @createTime 2019-09-24- 14:07
 */
public class MinimumWindowSubstring {
    public String minWindow(String s,String t){
        Map<Character,Integer> map=new HashMap<>();
        //统计t中出现的字母，并计数
        for (int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int l=0,r=0;
        int count=0;
        String ret="";
        int minLen=s.length()+1;
        while (r<s.length()){
            if (map.containsKey(s.charAt(r))){
                int freq=map.get(s.charAt(r));
                map.put(s.charAt(r),--freq);
                if(freq>=0){
                    count++;
                }


                //s中出现的字符刚好包括t中所有的字符
                while (count==t.length()) {
                    if (r - l + 1 < minLen) {
                        minLen = r - l + 1;
                        ret = s.substring(l, r + 1);
                    }
                    if (map.containsKey(s.charAt(l))) {
                        int sfreq = map.get(s.charAt(l));
                        map.put(s.charAt(l), ++sfreq);
                        if (sfreq > 0) {
                            --count;
                        }
                    }
                    l++;
                }
            }
            r++;
        }
        return ret;
    }
}
