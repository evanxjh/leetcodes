package strings;

/**
 * @author EvenHsia
 * @ClassName ReverseWordsInAString.java
 * @Description No.151 Medium
 * @createTime 2019-08-05- 13:33
 */

/**
 * Example 1:
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s){
        s=s.trim();                            //删除首尾的空格
        String[] array=s.split("\\s+");    //   \\s+表示多个空格，+表示多个
        StringBuffer sb=new StringBuffer();
        for (int i=array.length-1;i>=0;i--){
            sb.append(array[i]);
            if (i>0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
