package Greedy;

/**
 * @author EvanHsia
 * @ClassName BestTimeToBuyAndSellStock.java
 * @Description No.121 Easy
 * @createTime 2019-08-09- 11:00
 */

/**
 * 第i个元素为一个股票第i天的价格
 * 只允许进行一次交易（买入一个，或者卖出一个），设计算法得到最高利润
 */
//贪心策略：premin记录之前最小的一天，premax记录premin更新后的最大的一天，max记录当前最大的profit
public class BestTimeToBuyAndSellStock {
    public int maxProfix(int[] prices){
        if (prices==null || prices.length==0) return 0;
        int profit=0;
        int premin=prices[0];
        for (int i=1;i<prices.length;i++){
            if (prices[i]<premin){
                premin=prices[i];
            }
            profit=Math.max(profit,prices[i]-premin);
        }
        return profit;
    }
}
