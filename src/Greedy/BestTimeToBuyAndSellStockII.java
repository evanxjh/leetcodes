package Greedy;

/**
 * @author EvanHsia
 * @ClassName BestTimeToBuyAndSellStockII.java
 * @Description No.122 Easy
 * @createTime 2019-08-09- 13:37
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices){
        int profit=0;
        for (int i=1;i<prices.length;i++){
            if (prices[i]-prices[i-1]>0){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}
