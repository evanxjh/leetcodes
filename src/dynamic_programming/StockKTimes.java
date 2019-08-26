package dynamic_programming;

/**
 * @author EvanHsia
 * @ClassName StockKTimes.java
 * @Description No.188 Hard
 * @createTime 2019-08-26- 14:49
 */

/**
 * 最多交易k次
 */
public class StockKTimes {
    public int maxProfit(int k,int[] prices){
        int n=prices.length;
        if (k>=n/2){                        //  普通的股票交易问题
            int maxProfit=0;
            for (int i=1;i<n;i++){
                if (prices[i]>prices[i-1]){
                    maxProfit+=prices[i]-prices[i-1];
                }
            }
            return maxProfit;
        }
/*        //二维数组
        int[][] maxProfit=new int[k+1][n];
        for (int i=1;i<=k;i++){
            int localMax=maxProfit[i-1][0]-prices[0];
            for (int j=1;j<n;j++){
                maxProfit[i][j]=Math.max(maxProfit[i][j-1],prices[j]+localMax);     //第j天不交易，还是交易，两种情况
                localMax=Math.max(localMax,maxProfit[i-1][j]-prices[j]);            //保证交易i-1次，且在第1至j-1天中买入股票后，拥有的钱是最多的，这样在第j天卖出赚的最多。
            }
        }
        return maxProfit[k][n-1];*/

        //一维数组
        int[] dp=new int[n];
        for (int i=1;i<=k;i++){
            int oldmax=dp[0]-prices[0];
            for (int j=1;j<n;j++){
                int curmax=Math.max(oldmax,dp[j]-prices[j]);
                dp[j]=Math.max(dp[j-1],prices[j]+oldmax);
                oldmax=curmax;
            }
        }
        return dp[n-1];
    }
}
