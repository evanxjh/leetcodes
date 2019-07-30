package dynamic_programming;

/**
 * @program: leetcodetrain
 * @description: No.70 Easy
 * @author: EvenHsia
 * @create: 2019-07-30 23:26
 **/

/**
 * //fibonacci
 */
public class ClimbingStairs {
    public int climbStairs(int n){
        if (n<2) return n;
        int fib1=1;
        int fib2=2;
        for (int i=3;i<=n;i++){
            int cur=fib1+fib2;
            fib1=fib2;
            fib2=cur;
        }
        return fib2;
    }
}
