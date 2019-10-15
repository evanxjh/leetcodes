package dynamic_programming;

/**
 * @author EvanHsia
 * @ClassName UniqueBinarySearchTrees.java
 * @Description No.96 Medium
 * @createTime 2019-10-15- 10:14
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n){
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<=n;i++){
            for (int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];         //左子树的情况*右子树的情况
            }
        }
        return dp[n];
    }
}
