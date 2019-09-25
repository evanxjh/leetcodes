package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author EvanHsia
 * @ClassName ThreeSum.java
 * @Description No.15 Medium
 * @createTime 2019-09-25- 12:22
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res=new ArrayList<>();
        if (nums==null || nums.length<3){
            return res;
        }
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){
            if (i==0 || nums[i]!=nums[i-1]){
                int j=i+1;
                int k=nums.length-1;
                while (j<k){
                    int sum=nums[i]+nums[j]+nums[k];
                    if (sum==0){
                        if (j==i+1  || nums[j]!=nums[j-1]){
                            res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        }
                        j++;
                        k--;
                    }
                    else if (sum<0){
                        j++;
                    }else {
                        k--;
                    }
                }
            }
        }
        return res;
    }
}
