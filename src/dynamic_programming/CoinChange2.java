package dynamic_programming;

/**
 * @author EvanHsia
 * @ClassName CoinChange2.java
 * @Description No.518 Medium
 * @createTime 2019-08-22- 21:43
 */
public class CoinChange2 {
    public int change(int amount,int[] coins){
        if (amount==0) return 1;
        if( coins==null || coins.length==0) return 0;
        int[] dp= new int[amount+1];
        dp[0]=1;
        for (int coin:coins){
            for (int i=coin;i<=amount;i++){
                dp[i]+=dp[i-coin];
            }
        }
        return dp[amount];
    }
}
