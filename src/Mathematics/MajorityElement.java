package Mathematics;

import java.util.Arrays;

/**
 * @author EvanHsia
 * @ClassName MajorityElement.java
 * @Description No.169 Easy
 * @createTime 2019-08-21- 10:20
 */
public class MajorityElement {
    //一定是有序数组的最中间的数
    public int majorityElement(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    //利用Boyer-Moore Majority Vote Algorithm 时间复杂度为O(n),可以对前i个和后n-i个分开分析
    public int majorityelement(int[] nums){
        int cnt=0,majority=nums[0];
        for (int num:nums){
            majority=cnt==0?num:majority;
            cnt=num==majority?cnt+1:cnt-1;
        }
        return majority;
    }
}
