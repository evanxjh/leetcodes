package array;

/**
 * @author EvenHsia
 * @ClassName MoveZeros.java
 * @Description No.283 Easy
 * @createTime 2019-08-05- 15:53
 */

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 */
public class MoveZeros {
    public void moveZeros(int[] nums){
        int i=0,j=1;
        while(i<nums.length && j<nums.length){
            if (nums[i]==0){
                while (j<nums.length &&nums[j]==0){
                    j++;
                }
                if (j>=nums.length) break;
                nums[i]=nums[j];
                nums[j]=0;
            } else{
                i++;
                j++;
            }
        }
    }
}
