package two_pointers;

import java.util.Stack;

/**
 * @author EvanHsia
 * @ClassName TrappingRainWater.java
 * @Description No.42 Hard
 * @createTime 2019-09-24- 14:54
 */
public class TrappingRainWater {
    //双指针法
    public int trap(int[] height){
        if (height==null ||height.length==0){
            return 0;
        }
        int l=0,r=height.length-1;
        int count=0;
        int leftmax,rightmax;
        leftmax=height[l];
        rightmax=height[r];
        while (l<r){
            if (leftmax<rightmax){
                l++;
                count+=height[l]<leftmax?leftmax-height[l]:0;
                leftmax=Math.max(leftmax,height[l]);
            }else {
                r--;
                count+=height[r]<rightmax?rightmax-height[r]:0;
                rightmax=Math.max(rightmax,height[r]);
            }
        }
        return count;
    }


}
