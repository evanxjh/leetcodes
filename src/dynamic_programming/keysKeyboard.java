package dynamic_programming;

/**
 * @author EvanHsia
 * @ClassName keysKeyboard.java
 * @Description No.650 Medium
 * @createTime 2019-08-26- 16:19
 */

/**
 * 最开始只有一个字符 A，问需要多少次操作能够得到 n 个字符 A，每次操作可以复制当前所有的字符，或者粘贴。
 *
 * Input: 3
 * Output: 3
 * Explanation:
 * Intitally, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
 */
public class keysKeyboard {
    //方法一：递归
    public int minSteps(int n){
        if (n==1) return 0;
        for (int i=2;i<Math.sqrt(n);i++){
            if (n%i==0){                        //n不是素数
                return i+minSteps(n/i);
            }
        }
        return n;                               //n是素数，只能一个A一个A地粘贴
    }

    public int minsteps(int n){
        int[] dp=new int[n+1];
        int h=(int) Math.sqrt(n);
        for (int i=2;i<=n;i++){
            dp[i]=i; //默认为素数
            for(int j=2;j<=h;j++){
                if (i%j==0){
                    dp[i]=dp[j]+dp[i/j];
                    break;
                }
            }
        }
        return dp[n];
    }
}
