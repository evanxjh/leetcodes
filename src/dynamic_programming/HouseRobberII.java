package dynamic_programming;

/**
 * @program: leetcodetrain
 * @description: No.213 Medium
 * @author: EvenHsia
 * @create: 2019-07-30 23:56
 **/

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed. All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one. Meanwhile,
 * adjacent houses have security system connected and it will automatically
 * contact the police if two adjacent houses were broken into on the same night.
 */
public class HouseRobberII {
    public int rob(int[] nums){
        if (nums.length==0) return 0;
        int n=nums.length;
        if (n==1) return nums[0];
        /*两种情况：偷第一所房子，那就不能偷第n所；
         *          偷第n所房子，就不能偷第一所。
         *          两者取其大。
         */
        return Math.max(robhelper(nums,0,n-1),robhelper(nums,1,n));
    }
    public int robhelper(int[] nums,int start,int end){
        int fib1=0;
        int fib2=0;
        for (int i=start;i<end;i++){
            int cur=Math.max(nums[i]+fib2,fib1);
            fib2=fib1;
            fib1=cur;
        }
        return fib1;
    }
}
