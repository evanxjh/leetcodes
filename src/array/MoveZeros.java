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
    public void moveZeroes(int[] nums){
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

    public void solution(int[] nums){
        int k=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                if (i!=k){
                    swap(nums,k++,i);
                }else{
                    k++;
                }
            }
        }
    }
    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums [j];
        nums[j] = tmp;
    }
}
