package strings;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author EvanHsia
 * @ClassName LongestCommonPrefix.java
 * @Description No.14 Easy
 * @createTime 2019-10-05- 16:37
 */
public class LongestCommonPrefix {
    //将数组排序，即字典序，最后只需要比较第一个元素和最后一个元素
    public String longestCommonPrefix(String[] strs){
        if (strs==null || strs.length==0){
            return "";
        }
        if (strs.length==1){
            return strs[0];
        }
        Arrays.sort(strs);
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<Math.min(strs[0].length(),strs[strs.length-1].length());i++){
            if (strs[0].charAt(i)!=strs[strs.length-1].charAt(i)){
                break;
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}
