package strings;

/**
 * @author EvenHsia
 * @ClassName CountBinarySubstrings.java
 * @Description No.696 Easy
 * @createTime 2019-08-05- 15:22
 */

/**
 * Substrings that occur multiple times are counted the number of times they occur.
 *
 * Input: "00110011"
 * Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s){
        //prelen记录前面的0或1的字串长度，curlen记录当前1或0的字串长度，cnt记录结果。
        int prelen=0,curlen=1,cnt=0;
        for (int i=1;i<s.length();i++){
            if (s.charAt(i)==s.charAt(i-1)){
                curlen++;
            } else{
                prelen=curlen;
                curlen=1;
            }
            if (curlen<=prelen){
                cnt++;
            }
        }
        return cnt;
    }
}
