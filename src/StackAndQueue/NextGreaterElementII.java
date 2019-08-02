package StackAndQueue;

/**
 * @program: leetcodetrain
 * @description: No.503 Medium
 * @author: EvenHsia
 * @create: 2019-08-03 00:21
 **/

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a circular array (the next element of the last element is the first element of the array),
 * print the Next Greater Number for every element. The Next Greater Number of a number x is the
 * first greater number to its traversing-order next in the array, which means you could search
 * circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums){
       int[] ret=new int[nums.length];
        Arrays.fill(ret,-1);
        Stack<Integer> indexs=new Stack<>();
        for (int curr=0;curr<2*nums.length;curr++){            //构造circle
            int num=nums[curr % nums.length];
            while (!indexs.isEmpty() && num>nums[indexs.peek()]){
                ret[indexs.pop()]=num;
            }
            if (curr<nums.length) indexs.push(curr);
        }
        return ret;
    }
}
