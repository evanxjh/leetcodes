package Greedy;

/**
 * @author EvanHsia
 * @ClassName BestTimeToBuyAndSellStockIII.java
 * @Description No.123 Hard
 * @createTime 2019-08-09- 11:31
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices){
        if (prices==null || prices.length==0) return 0;
        int min1=prices[0];
        int max1=0;
        int min2=Integer.MAX_VALUE;
        int max2=0;
        for (int pos=1;pos<prices.length;pos++){
            int cur=prices[pos];
            min1=Math.min(min1,cur);
            max1=Math.max(max1,cur-min1);
            min2=Math.min(min2,cur-max1);
            max2=Math.max(max2,cur-min2);
        }
        return max2;
    }
}
