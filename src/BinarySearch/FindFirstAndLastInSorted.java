package BinarySearch;

/**
 * @author EvanHsia
 * @ClassName FindFirstAndLastInSorted.java
 * @Description No.34 Medium
 * @createTime 2019-08-14- 17:09
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstAndLastInSorted {
    public int[] searchRange(int [] nums,int target){
        int first=binarySearch(nums,target);
        int last=binarySearch(nums,target+1)-1;      //找比target大1的，last就比这个值小1
        if ( first==nums.length || nums[first]!=target){
            return new int[]{-1,-1};
        } else {
            return new int[]{first,Math.max(first,last)};    //target为数组中最大的，且只有一个
        }

    }
    private int binarySearch(int[] nums,int target){
        int l=0,h=nums.length;                        //最大返回值为nums.length,保证target为数组中最后一个元素时，last为最后一个，而不是倒数第二个
        while (l<h){
            int m=l+(h-l)/2;
            if (nums[m]>=target){
                h=m;
            } else {
                l=m+1;
            }
        }
        return l;
    }

    //查找第一个元素
    private int binarySearchFirstTarget(int[] nums,int target){
        int l=0,h=nums.length-1,res=-1;
        while (l<=h){
            int mid=l+(h-l)/2;
            if (target<=nums[mid]){
                h=mid-1;
            } else{
                l=mid+1;
            }
            if (target==nums[mid]){
                res=mid;
            }
        }
        return res;
    }

    @Test
    public void sometest(){
        int[] t=new int[]{5,7,7,8,8,10};
        System.out.print(searchRange(t,8)[0]+" "+searchRange(t,8)[1]);
    }
}
