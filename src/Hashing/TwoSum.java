package Hashing;

import java.util.HashMap;
/**
 * @program: leetcodetrain
 * @description: No.1 on Leetcode
 * @author: EvenHsia
 * @create: 2019-07-25 13:23
 **/

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 */
public class TwoSum {
    public int[] twoSum(int[]nums ,int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args){
        TwoSum test=new TwoSum();
        int[] num={2,7,11,15};
        int[] result=test.twoSum(num,9);
        for (int i:result){
            System.out.print(result[i]);
        }
    }
}
