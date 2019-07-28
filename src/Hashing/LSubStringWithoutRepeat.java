package Hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcodetrain
 * @description: No.3 Medium
 * @author: EvenHsia
 * @create: 2019-07-28 12:37
 **/

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LSubStringWithoutRepeat {
    public int lengthOfLongestSubstring(String s){
        int n=s.length();
        Set<Character> set = new HashSet<>();
        int ans=0, start=0, end=0;
        while (start<n && end<n){
            if (!set.contains(s.charAt(end))){
                set.add(s.charAt(end++));
                ans=Math.max(ans,end-start);
            }else{
                set.remove(s.charAt(start++));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s="xjhqrcxp";
        LSubStringWithoutRepeat test=new LSubStringWithoutRepeat();
        System.out.println(test.lengthOfLongestSubstring(s));
    }
}
