package dynamic_programming;

/**
 * @author EvanHsia
 * @ClassName StockWithTransactionFee.java
 * @Description No.714 Medium
 * @createTime 2019-08-23- 11:27
 */

/**
 * 股票交易需要交易费用
 */
public class StockWithTransactionFee {
    public int maxProfit(int[] prices,int fee){
        if (prices==null || prices.length==0){
            return 0;
        }
        int n=prices.length;
        int[] buy=new int[n+1];
        int[] sell=new int[n+1];
        for (int i=1;i<=n;i++){
            if (i>1){
                //把交易费用与sell绑定
                buy[i]=Math.max(buy[i-1],sell[i-1]-prices[i-1]);
                sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i-1]-fee);
            } else{
                buy[i]=-prices[i-1];
            }
        }
        return sell[n];
    }
}
