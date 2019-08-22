package dynamic_programming;

/**
 * @author EvanHsia
 * @ClassName OnesAndZeros.java
 * @Description No.474 Medium
 * @createTime 2019-08-22- 17:16
 */

/**
 * find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.
 *
 * Example 1:
 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * Output: 4
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
 *
 *
 * Example 2:
 * Input: Array = {"10", "0", "1"}, m = 1, n = 1
 * Output: 2
 * Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 */
public class OnesAndZeros {
    public int findMaxForm(String[] strs,int m,int n){
        if (strs==null || strs.length==0){
            return 0;
        }
        int[][] dp=new int[m+1][n+1];
        for (String s:strs){
            int ones=0,zeros=0;
            for (char c:s.toCharArray()){
                if (c=='0'){
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int i=m;i>=zeros;i--){
                for (int j=n;j>=ones;j--){
                    dp[i][j]=Math.max(dp[i-zeros][j-ones]+1,dp[i][j]);             //考虑放和不放两种情况
                }
            }
        }
        return dp[m][n];
    }
}
