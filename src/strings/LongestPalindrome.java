package strings;

/**
 * @author EvenHsia
 * @ClassName LongestPalindrome.java
 * @Description No.409 Easy
 * @createTime 2019-08-05- 14:14
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest
 * palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 */
// 同样可以用int[128]来做
public class LongestPalindrome {
    public int longestPalindrome(String s){
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        boolean hasodd=false;
        int res=0;
        for (Character c:map.keySet()){
            if (!hasodd && map.get(c) % 2==1){
                hasodd=true;
            }
            res+=map.get(c)/2;
        }
        return hasodd?res*2+1:res*2;
    }
}
