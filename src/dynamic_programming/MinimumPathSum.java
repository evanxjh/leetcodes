package dynamic_programming;

/**
 * @program: leetcodetrain
 * @description: No.64 Medium
 * @author: EvenHsia
 * @create: 2019-07-31 11:19
 **/

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left
 * to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {
    public int minimumPathSum(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int[] dp=new int[n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (i==0){
                    dp[j]=(j==0)?grid[i][j]:grid[i][j]+dp[j-1];
                    continue;
                }
                if (j==0){
                    dp[j]+=grid[i][j];
                    continue;
                }
                dp[j]=Math.min(dp[j],dp[j-1])+grid[i][j];
            }
        }
        return dp[n-1];
    }
}
