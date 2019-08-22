package dynamic_programming;

/**
 * @author EvanHsia
 * @ClassName TargetSum.java
 * @Description No.494 Medium
 * @createTime 2019-08-22- 16:55
 */

/**
 * 改变一组数的正负号，使得它们的和为一给定的数
 */
/*
 * 可以将这组数看成两部分，P 和 N，其中 P 使用正号，N 使用负号，有以下推导：
 *
 *                                 sum(P) - sum(N) = target
 *               sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
 *                                      2 * sum(P) = target + sum(nums)
 * 因此只要找到一个子集，令它们都取正号，并且和等于 (target + sum(nums))/2，就证明存在解。
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums,int S){
        int sum=0;
        for (int num:nums){
            sum+=num;
        }
        if (sum<S || (sum+S)%2==1){
            return 0;
        }
        int W=(sum+S)/2;
        int[] dp=new int[W+1];
        dp[0]=1;                                        //和为0的情况只有1种，什么也不放
        for (int num:nums){
            for (int j=W;j>=num;j--){
                dp[j]=dp[j]+dp[j-num];                  //num放和不放的方法数之和
            }
        }
        return dp[W];
    }
}
