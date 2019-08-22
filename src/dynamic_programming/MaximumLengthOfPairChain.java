package dynamic_programming;

/**
 * @author EvanHsia
 * @ClassName MaximumLengthOfPairChain.java
 * @Description No.646 Medium
 * @createTime 2019-08-22- 15:00
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * 对于(a,b)和(c,d)，如果b<c，则它们可以构成一条链，求最长的链长
 */
public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs){
        if (pairs==null || pairs.length==0){
            return 0;
        }
        Arrays.sort(pairs, Comparator.comparingInt(a->a[0]));
        int n=pairs.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for (int i=0;i<n;i++){
            for (int j=0;j<i;j++){
                if (pairs[i][0]>pairs[j][1]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
        }
        int ret=0;
        for (int len:dp){
            ret=Math.max(ret,len);
        }
        return ret;
    }

    //贪心算法,使右边的值尽量小，所以以右边界升序排序
    public int findLongestChain2(int[][] pairs){
        Arrays.sort(pairs,Comparator.comparingInt(e->e[1]));
        int cur=Integer.MIN_VALUE,ans=0;
        for (int i=0;i<pairs.length;i++){
            if (pairs[i][0]>cur){
                ans++;
                cur=pairs[i][1];
            }
        }
        return ans;
    }
}
