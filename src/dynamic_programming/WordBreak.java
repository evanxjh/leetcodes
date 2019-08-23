package dynamic_programming;

/**
 * @author EvanHsia
 * @ClassName WordBreak.java
 * @Description No.139 Medium
 * @createTime 2019-08-23- 09:47
 */

import java.util.List;

/**
 * 给一个字符串和一个单词表，判断是否能将字符串用单词表中的单词分割
 *
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */

//可以用背包问题来解决，但是要考虑单词表中的使用顺序
//顺序背包问题：对物品的迭代放在里层，背包的迭代放在外层，才能保证物品按一定顺序放入背包中。
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict){
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for (int i=1;i<=n;i++){
            for (String word:wordDict){
                int len=word.length();
                if (len<=i && word.equals(s.substring(i-len,i))){
                    dp[i]=dp[i-len] || dp[i];                           //可以不用这个word也可以用这个word
                }
            }
        }
        return dp[n];
    }
}
