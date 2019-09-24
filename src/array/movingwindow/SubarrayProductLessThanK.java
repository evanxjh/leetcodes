package array.movingwindow;

import org.junit.Test;

/**
 * @author EvanHsia
 * @ClassName SubarrayProductLessThanK.java
 * @Description No.713 Medium
 * @createTime 2019-09-24- 14:24
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums,int k){
        int count=0,l=0,r=0;
        int CurPro=1;
        while (r<nums.length){
            CurPro*=nums[r];
            while (CurPro>=k && l<=r){              //或者在最开始将k<=1单独讨论，这里可以不限定l<=r
                CurPro=CurPro/nums[l++];
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
    @Test
    public void sometest(){
        int[] a=new int[]{10,5,2,6};
        int k=100;
        System.out.println(numSubarrayProductLessThanK(a,k));
    }
}
