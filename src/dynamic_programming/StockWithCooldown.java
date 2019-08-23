package dynamic_programming;

/**
 * @author EvanHsia
 * @ClassName StockWithCooldown.java
 * @Description No.309 Medium
 * @createTime 2019-08-23- 10:18
 */

/**
 * 设计一种算法，让股票交易的利润最大，条件：1）买入前必须先卖出；2）卖出后的下一天不能再买
 */
public class StockWithCooldown {
    public int maxProfit(int[] prices){
        if (prices==null || prices.length==0){
            return 0;
        }
        int n=prices.length;
        int[] sell=new int[n+1];
        int[] buy=new int[n+1];
        for (int i=1;i<=n;i++){
            if (i>1) {
                //执行买操作时，第i天身上的钱数目最大值，两种情况：可以买，也可以不买
                buy[i] = Math.max(buy[i - 1], sell[i - 2]-prices[i-1]);
                //执行卖操作，第i天身上的钱数目最大值，两种情况：可以卖，也可以不卖
                sell[i]= Math.max(sell[i-1],buy[i-1]+prices[i-1]);
            } else{
                //第一天买入，身上的钱是负的
                buy[i]= -prices[i-1];
            }
        }
        return sell[n];
    }
}
