package dynamic_programming;

/**
 * @author EvanHsia
 * @ClassName CoinChange.java
 * @Description No.322 Medium
 * @createTime 2019-08-22- 21:24
 */

/**
 * 给一些面额的硬币，要求用这些硬币来组成给定面额的钱数，并且使得硬币数量最少。硬币可以重复使用。
 * 物品：硬币
 * 物品大小：面额
 * 物品价值：数量
 */
//完全背包问题，硬币可以重复使用，完全背包是将0-1背包逆序遍历要改成正序遍历
public class CoinChange {
    public int coinChange(int[] coins,int amount){
        if (amount==0 || coins==null || coins.length==0) return 0;
        int[] dp=new int[amount+1];
        for (int coin:coins){
            for (int i=coin;i<=amount;i++){
                if (i==coin){
                    dp[i]=1;
                } else if ( dp[i]==0 && dp[i-coin]!=0){
                    dp[i]=dp[i-coin]+1;
                } else if(dp[i-coin]!=0){
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount]==0?-1:dp[amount];                //不能构成这个数值，比如全是偶数面额的硬币要构成奇数的总额
    }
}
