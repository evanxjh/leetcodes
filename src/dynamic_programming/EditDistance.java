package dynamic_programming;

/**
 * @program: leetcodetrain
 * @description: No.72 Hard
 * @author: EvenHsia
 * @create: 2019-07-31 14:34
 **/

/**
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * You have the following 3 operations permitted on a word:
 *      Insert a character
 *      Delete a character
 *      Replace a character
 */
public class EditDistance {
    public int minDistance(String word1,String word2){
        int length1=word1.length();
        int length2=word2.length();
        int[] dp=new int[length1+1];
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
                if (word1.charAt(j-1)==word2.charAt(i-1)){
                    //min=Math.min(old,Math.min(dp[j],dp[j-1])+1);
                    min=old;
                } else {
                    min=Math.min(old,Math.min(dp[j],dp[j-1]))+1;
                }
                old=dp[j];
                dp[j]=min;
            }
        }
        return dp[length1];
    }
}
