package Greedy;

/**
 * @program: leetcodetrain
 * @description: No.53 Easy
 * @author: EvenHsia
 * @create: 2019-08-10 22:49
 **/

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums){
        int max=nums[0];
        int sum=max;
        int curmax=max;
        for (int i=1;i<nums.length;i++){
            if (curmax<0){
                curmax=Math.max(curmax,nums[i]);
                sum=curmax;
                continue;
            }
            if (sum+nums[i]>=0) {               //还有连下去的价值
                sum+=nums[i];
                curmax=Math.max(curmax,sum);
            }else {                            //nums[i]是负数且，可以和后面斩断了
                max=Math.max(curmax,max);
                curmax=nums[i];
            }
        }
        return Math.max(max,curmax);
    }
}
