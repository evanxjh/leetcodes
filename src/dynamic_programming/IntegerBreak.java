package dynamic_programming;

/**
 * @program: leetcodetrain
 * @description: No.343 Medium
 * @author: EvenHsia
 * @create: 2019-07-31 11:43
 **/

/**
 * Given a positive integer n, break it into the sum of at least two positive integers
 * and maximize the product of those integers. Return the maximum product you can get.
 */
public class IntegerBreak {
    public int integerBreak(int n){
        if (n==1) return 0;
        if (n==2) return 1;
        if (n==3) return 2;
        int [] dp=new int[n+1];
        dp[2]=2;
        dp[3]=3;
        for (int i=4;i<n+1;i++){
            dp[i]=(i%3==0)?3*dp[i-3]:2*dp[i-2];
        }
        return dp[n];
    }
}
