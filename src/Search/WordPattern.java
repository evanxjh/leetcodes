package Search;

import java.util.HashMap;
import java.util.Map;

/**
 * @author EvanHsia
 * @ClassName WordPattern.java
 * @Description No.290 Easy
 * @createTime 2019-09-24- 21:53
 */
public class WordPattern {
    public boolean wordPattern(String pattern,String str){
        String[] words=null;
        if (str!=null) {
            words = str.split(" ");
        }
        if (pattern.length()!=words.length){
            return false;
        }
        Map<Character,String> map=new HashMap<>();
        for (int i=0;i<pattern.length();i++){
            if (map.containsKey(pattern.charAt(i))){
                if  (words[i].equals(map.get(pattern.charAt(i)))){
                    continue;
                }else {
                    return false;
                }
            }else{
                //值也不能被映射两次
                if (map.containsValue(words[i])){
                    return false;
                }
                map.put(pattern.charAt(i),words[i]);
            }
        }
        return true;
    }
}
