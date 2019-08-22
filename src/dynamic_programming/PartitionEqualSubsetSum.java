package dynamic_programming;

/**
 * @author EvanHsia
 * @ClassName PartitionEqualSubsetSum.java
 * @Description No.416 Medium
 * @createTime 2019-08-22- 16:42
 */

/**
 * 一个只有正整数的数组，判断能否分成两组，使得各组数字之和相等
 */
//视为一个sum/2的背包
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums){
        int sum=0;
        for (int num:nums){
            sum+=num;
        }
        if (sum%2!=0) return false;             //总和奇数不可能
        int W=sum/2;
        boolean[] dp=new boolean[W+1];          //dp[i]表示能否放使总和为i，可以则返回true
        dp[0]= true;
        for (int num:nums){
            for (int i=W;i>=num;i--){
                dp[i]=dp[i] || dp[i-num];
            }
        }
        return dp[W];
    }
}
