package array.movingwindow;

import Tree.SymmetricTree;
import org.apache.ibatis.annotations.Select;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author EvanHsia
 * @ClassName LengthOfLongestSubstring.java
 * @Description No.3 Medium
 * @createTime 2019-09-24- 12:23
 */
public class LengthOfLongestSubstring {
    public int solution1(String s){
        if (s==null || s.length()==0){
            return 0;
        }
        int[] preindex=new int[256];
        Arrays.fill(preindex,-1);
        int maxlen=0;
        int pre=0;
        for (int curI=0;curI<s.length();curI++){
            int curIndex=s.charAt(curI);
            maxlen=Math.max(maxlen,curI-pre);
            if(preindex[curIndex]!=-1) {
                pre = pre <=preindex[curIndex]?preindex[curIndex]+1:pre;
            }
            preindex[curIndex]=curI;
        }
        return Math.max(maxlen,s.length()-pre);
    }

    public int solution2(String s){
        if (s==null || s.length()==0) return 0;
        Set<Character> set=new HashSet<>();
        int i=0,j=0;
        int maxlen=0;
        while (i<s.length() && j<s.length()){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                maxlen=Math.max(maxlen,j-i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return maxlen;
    }


}
