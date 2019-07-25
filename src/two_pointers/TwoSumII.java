package two_pointers;

/**
 * @program: leetcodetrain
 * @description: No.167
 * @author: EvenHsia
 * @create: 2019-07-25 14:29
 **/

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target){
        for (int i=0,j=numbers.length-1;i<j;){
            int sum=numbers[i]+numbers[j];
            if (sum==target){
                return new int[]{i+1,j+1};
            }else if (sum>target){
                j--;
            }else {
                i++;
            }
        }
        return null;
    }
}
