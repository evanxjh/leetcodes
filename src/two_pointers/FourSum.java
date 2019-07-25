package two_pointers;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcodetrain
 * @description: No.18
 * @author: EvenHsia
 * @create: 2019-07-25 14:40
 **/
public class FourSum {


    public List<List<Integer>> fourSum(int[] nums,int target){
        List<List<Integer>> result=new ArrayList<>() ;
        if (nums.length<4) return result;
        Arrays.sort(nums);
        for (int i=0;i<nums.length-3;i++){
            if (i==0 || nums[i]!=nums[i-1]){
                for (int j=i+1;j<nums.length-2;j++){
                    if (j==i+1 || nums[j]!=nums[j-1]){
                        int k=j+1;
                        int l=nums.length-1;
                        while (k<l){
                            int sum=nums[i]+nums[j]+nums[k]+nums[l];
                            if (sum==target){
                                if (k==j+1 || nums[k]!=nums[k-1]) {                                  //保证不重复
                                    result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                                }
                                k++;
                                l--;
                            }else if(sum<target){
                                k++;
                            }else{
                                l--;
                            }
                        }
                    }
                }
            }
        }
        return  result;
    }

    public static void main(String[] args){
        int[] nums=new int[]{1,0,-1,0,-2,2};
        FourSum test=new FourSum();
        List<List<Integer>> result=test.fourSum(nums,0);
        System.out.println(result);
    }
}
