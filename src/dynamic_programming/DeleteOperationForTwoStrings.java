package dynamic_programming;

/**
 * @program: leetcodetrain
 * @description: No.583 Medium
 * @author: EvenHsia
 * @create: 2019-07-31 13:56
 **/

/**
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same,
 * where in each step you can delete one character in either string.
 *
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 */

//由编辑距离想到的，同时对于此类问题，只需要一个一维数组的空间即可。
public class DeleteOperationForTwoStrings {
    public int minDistance(String word1,String word2){
        int length1=word1.length();
        int length2=word2.length();
        int[] dp= new int[length1+1];
        for (int i=0;i<=length1;i++){
            dp[i]=i;
        }
        for (int i=1;i<=length2;i++){
            int old=dp[0];
            for (int j=0;j<=length1;j++){
                if (j==0){
                    dp[j]+=1;
                    continue;
                }
                int min;
                if (word1.charAt(j-1)!=word2.charAt(i-1)){
                    min=Math.min(dp[j],dp[j-1])+1;
                } else {
                    min=old;
                }
                old=dp[j];
                dp[j]=min;
            }
        }
        return dp[length1];
    }
}
