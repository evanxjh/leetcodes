package dynamic_programming;

/**
 * @author EvanHsia
 * @ClassName CombinationSumIV.java
 * @Description No.377 Medium
 * @createTime 2019-08-23- 09:58
 */

/**
 * Given an integer array with all positive numbers and no duplicates,
 * find the number of possible combinations that add up to a positive integer target
 */
/*
 * 完全背包问题，且涉及到顺序
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums,int target){
        if (nums==null || nums.length==0) return 0;
        int[] dp=new int[target+1];
        dp[0]=1;
        for (int i=1;i<=target;i++){
            for (int num:nums){
                if (num<=i && dp[i-num]!=0){
                    dp[i]+=dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
