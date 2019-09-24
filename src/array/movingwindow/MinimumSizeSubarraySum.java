package array.movingwindow;

import org.junit.Test;

/**
 * @author EvanHsia
 * @ClassName MinimumSizeSubarraySum.java
 * @Description No.209 Medium
 * @createTime 2019-09-24- 12:06
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s,int[] nums){
        int i=0,j=0;
        int minLen=nums.length;
        int sum=0;
        while (i<nums.length ){
            if (sum>=s){
                minLen=Math.min(minLen,j-i);
                sum-=nums[i++];
            }else if (j<nums.length){
                sum+=nums[j++];
            }else {
                break;
            }
        }
        if (i==0) return 0;
        return minLen;
    }

    @Test
    public void test(){
        int s=7;
        int[] arr=new int[]{2,3,1,2,4,3};
        minSubArrayLen(7,arr);
    }
}
