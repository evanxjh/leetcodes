package dynamic_programming;

/**
 * @author EvanHsia
 * @ClassName Bagmodel.java
 * @Description 01背包
 * @createTime 2019-08-22- 16:09
 */

/**
 * 有一个容量为 N 的背包，要用这个背包装下物品的价值最大，这些物品有两个属性：体积 w 和价值 v。
 * 定义一个二维数组dp，，其中dp[i][j]表示前i件物品体积不超过j的情况下能达到的最大价值。
 * 对于第i件物品应做如下考虑：
 * 1）第i件不添加到背包，dp[i][j]=dp[i-1][j]
 * 2）第i件添加到背包，dp[i][j]=dp[i-1][j-w]+v
 * 应取此两者的较大值
 */
public class Knapsack {
    //W背包空间
    //N物品数量
    //weights和values每件物品的重量和价值
    public int knapsack(int W,int N,int[] weights,int[] values){
        int[][] dp=new int[N+1][W+1];                   //0-N  0-W
        for (int i=1;i<=N;i++){
            int w=weights[i-1],v=values[i-1];
            for (int j=1;j<=W;j++){
                if (j>=w){                               //有可能可以放入第i件物品
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w]+v);
                } else {
                    dp[i][j]=dp[i-1][j];                //容量还没w大，不可能放入第i件物品
                }
            }
        }
        return dp[N][W];
    }


    //优化空间结构，可以只用一个一维数组，因为是按层更新的
    public int knapsack2(int W,int N,int[] weights,int[] values){
        int[] dp=new int[W+1];
        for (int i=1;i<=N;i++){
            int w=weights[i-1],v=values[i-1];
            for (int j=W;j>=1;j--){                     //***因为后面的会用到前面的值，所以要从大到小更新
                if (j>=w){
                    dp[j]=Math.max(dp[j],dp[j-w]+v);
                }
            }
        }
        return dp[W];
    }
}
