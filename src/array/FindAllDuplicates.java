package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EvenHsia
 * @ClassName FindAllDuplicates.java
 * @Description No.442 Medium
 * @createTime 2019-08-05- 21:23
 */
public class FindAllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;
            if (nums[index]<0){                       //如果为负值，说明这个索引之前用过，重复
                res.add(index+1);
            }
            nums[index]*=-1;

        }
        return res;
    }
}
