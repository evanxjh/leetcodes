package two_pointers;

/**
 * @program: leetcodetrain
 * @description: No.633
 * @author: EvenHsia
 * @create: 2019-07-25 16:26
 **/

/**
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 *
 * Example 1:
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 *
 * Example 2:
 * Input: 3
 * Output: False
 */
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c){
        for (int i=0,j=(int) Math.ceil(Math.sqrt(c));i<=j;){
            int sum=i*i+j*j;
            if (sum==c){
                return true;
            }else if (sum<c){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }
}
