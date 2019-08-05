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

    public List<Integer> anothermethod(int[] nums){
        List<Integer> res=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;
            if (nums[index]>0){                  //只要该索引出现过，则对应位置的值置为负，且只操作一次，以免负负得正。
                nums[index]*=-1;
            }
        }
        for (int i=0;i<nums.length;i++){
            if (nums[i]>0){
                res.add(i);
            }
        }
        return res;
    }
}
