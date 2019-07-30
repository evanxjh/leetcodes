package dynamic_programming;

/**
 * @program: leetcodetrain
 * @description: No.198 Easy
 * @author: EvenHsia
 * @create: 2019-07-30 23:35
 **/

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have security
 * system connected and it will automatically contact the police if two adjacent
 * houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    public int rot(int[] nums){
        int len=nums.length;
        int fib1=0; int fib2=0;
        for (int i=0;i<len;i++){
            int cur=Math.max(fib2+nums[i],fib1);
            fib2=fib1;
            fib1=cur;
        }
        return fib1;
    }
}
