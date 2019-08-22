package dynamic_programming;

/**
 * @author EvanHsia
 * @ClassName DecodeWays.java
 * @Description No.91 Medium
 * @createTime 2019-08-22- 10:17
 */

import edu.princeton.cs.algs4.In;
import org.junit.Test;

/**
 * A-Z分别用1-26代表，给一个字符串只包含数字，计算有多少方式去解码它
 *
 * Example
 * “226”
 * BZ或VF或BBF
 */
//需要考虑"0000"这种情况，应该返回0
public class DecodeWays {
    public int numDecodings(String s){
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=s.charAt(0)=='0'?0:1;
        for (int i=2;i<=s.length();i++){
            int one=Integer.parseInt(String.valueOf(s.charAt(i-1)));
            if (one!=0){
                dp[i]+=dp[i-1];
            }
            if (s.charAt(i-2)=='0'){
                continue;
            }
            int two= Integer.parseInt(String.valueOf(s.charAt(i-2)))*10+one;
            if (two<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[s.length()];
    }

    @Test
    public void test(){
        String s="0";
        System.out.print(numDecodings(s));
    }
}
