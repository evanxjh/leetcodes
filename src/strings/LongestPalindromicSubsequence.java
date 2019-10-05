package strings;

/**
 * @author EvanHsia
 * @ClassName LongestPalindromicSubsequence.java
 * @Description No.516 Medium
 * @createTime 2019-10-05- 17:11
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s){
        if (s==null || s.length()==0){
            return 0;
        }
        int len=s.length();
        //dp[i][j]表示i-j的最长回文子串的长度
        int[][] dp=new int[len][len];

/*        for (int i=len-1;i>=0;i--){
            dp[i][i]=1;
            for (int j=i+1;j<len;j++){
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;            //i+1>j-1是默认为0
                } else {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];*/

    //循环的升序和降序的不同，导致dp数组的涵义不同
        for (int i=0;i<len;i++){
            dp[i][i]=1;
            for (int j=i-1;j>=0;j--){
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i-1][j+1]+2;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j+1]);
                }
            }
        }
        return dp[len-1][0];
    }
}
