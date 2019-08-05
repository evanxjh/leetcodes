package strings;

/**
 * @author EvenHsia
 * @ClassName PalindromicSubstrings.java
 * @Description No.647 Medium
 * @createTime 2019-08-05- 14:51
 */

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 *
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class PalindromicSubstrings {
    public int countSubstring(String s){
        int cnt=0;
        for (int i=0;i<s.length();i++){
            int low=i;
            int high=i;
            while (low>=0 && high<s.length() && s.charAt(low)==s.charAt(high)){
                cnt++;
                low--;
                high++;
            }
            low=i;
            high=i+1;
            while (low>=0 &&high<s.length() && s.charAt(low)==s.charAt(high)){
                cnt++;
                low--;
                high++;
            }
        }
        return cnt;
    }
}
