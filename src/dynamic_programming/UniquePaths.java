package dynamic_programming;

/**
 * @program: leetcodetrain
 * @description: No.62 Medium
 * @author: EvenHsia
 * @create: 2019-07-31 11:36
 **/

import java.util.Arrays;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 */

//还可用m+n-2 选 m-1 的组合数计算
public class UniquePaths {
    public int uniquePaths(int m,int n){
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[j]=dp[j]+dp[j-1];
            }
        }
        return dp[n-1];
    }
}
