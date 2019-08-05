package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EvenHsia
 * @ClassName FindAllNumbersDisappeared.java
 * @Description No.448 Easy
 * @createTime 2019-08-05- 21:11
 */
public class FindAllNumbersDisappeared {
    public List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> res=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            while (nums[i]!=i+1 && nums[nums[i]-1]!=nums[i]){
                swap(nums,i,nums[i]-1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i+1);
            }
        }
        return res;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
