package dynamic_programming;

/**
 * @author EvanHsia
 * @ClassName WiggleSubsequence.java
 * @Description Medium
 * @createTime 2019-08-22- 15:24
 */

/**
 * 摆动子序列，要求前后之差为一正一负排列
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums){
        if (nums==null || nums.length==0) return 0;
        int up=1,down=1;
        for (int i=1;i<nums.length;i++){
            if (nums[i]>nums[i-1]){
                up=down+1;
            } else if (nums[i]<nums[i-1]){
                down=up+1;
            }
        }
        return Math.max(up,down);
    }
}
