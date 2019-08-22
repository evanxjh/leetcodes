package dynamic_programming;

/**
 * @author EvanHsia
 * @ClassName LongestCommonSubsequence.java
 * @Description 最长公共子序列
 * @createTime 2019-08-22- 15:42
 */
//与编辑距离是一个类似的问题
//可以用一个二维数组用来存储最长公共子序列的长度，dp[i][j]表示num1前i个和num2的前j个
public class LongestCommonSubsequence {
    public int lenghtOfLCS(int[] num1,int[] num2){
        int n1=num1.length,n2=num2.length;
        int[][] dp=new int[n1+1][n2+1];
        for (int i=1;i<n1;i++){
            for (int j=1;j<n2;j++){
                if (num1[i]==num2[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[n1][n2];
    }
}
