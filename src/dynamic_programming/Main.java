package dynamic_programming;

import java.util.Scanner;

/**
 * @author EvanHsia
 * @ClassName Main.java
 * @Description
 * @createTime 2019-09-26- 10:52
 */
public class Main {
    public static int[] dp=new int[41];
    public Main(){
        dp[1]=1;
        dp[2]=2;
        for (int i=3;i<=40;i++ ){
            dp[i]=dp[i-1]+dp[i-2];
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N=sc.nextInt();
        for (int i=0;i<N;i++){
            int x=sc.nextInt();
            System.out.println(Main.dp[x-1]);
        }
    }
}
