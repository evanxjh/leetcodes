package strings;

import java.util.Arrays;

/**
 * @author EvanHsia
 * @ClassName FirstUniqueCharacter.java
 * @Description No.387 Easy
 * @createTime 2019-10-05- 14:56
 */
public class FirstUniqueCharacter {
    public int firstUniqChar(String s){
        int[] chars=new int[26];
        for (int i=0;i<s.length();i++){
            chars[s.charAt(i)-'a']++;
        }
        for (int i=0;i<s.length();i++){
            if (chars[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
}
