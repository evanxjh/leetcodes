package dynamic_programming;

/**
 * @author EvanHsia
 * @ClassName LongestIncreasingSubsequence.java
 * @Description No.300 Medium
 * @createTime 2019-08-22- 11:12
 */
/*
 * dp[n]=max{1,dp[i]+1 | Si<Sn && i<n}
 * 一种是Sn比前面的都小，则构成一个长度为1的子序列，否则就是在前面某个子序列的基础上加上当前的Sn
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums){
        int n=nums.length;
        int[] dp=new int[n];
        for (int i=0;i<n;i++){
            int max=1;
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]){
                    max=Math.max(max,dp[j]+1);
                }
            }
            dp[i]=max;
        }
        int ret=0;
        for (int i=0;i<n;i++){
            ret=Math.max(ret,dp[i]);
        }
        return ret;
    }
}
