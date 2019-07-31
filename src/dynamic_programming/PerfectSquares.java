package dynamic_programming;

/**
 * @program: leetcodetrain
 * @description: No.279 Medium
 * @author: EvenHsia
 * @create: 2019-07-31 13:09
 **/

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 */
public class PerfectSquares {
    public int numSquares(int n){
        List<Integer>  squares=buildlist(n);
        int[] dp=new int[n+1];
        for (int i=1;i<=n;i++){
            int min=Integer.MAX_VALUE;
            for (int square:squares){
                if (square>i) break;
                min=Math.min(min,1+dp[i-square]);
            }
            dp[i]=min;
        }
        return dp[n];
    }
    public List<Integer> buildlist(int n){
        List<Integer> res=new ArrayList<>();
        int i=1;
        while (i*i<=n){
            res.add(i*(i++));
        }
        return res;
    }

    @Test
    public void sometest(){
        Assert.assertEquals(3,numSquares(12));
    }

}
