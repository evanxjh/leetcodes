package Mathematics;

/**
 * @author EvanHsia
 * @ClassName ProductOfArrayExceptSelf.java
 * @Description No.238 Medium
 * @createTime 2019-08-21- 15:31
 */

import java.util.Arrays;

/**
 * 给定一个数组，创建一个新数组，新数组的每个元素为原始数组中除了该位置上的元素之外所有元素的乘积。
 *
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 */
//不能使用division，且需要O(n)
// 可用两个循环，一个计算比i小的项的乘积，一个计算比i大的项的乘积
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums){
        int n=nums.length;
        int[] products=new int[n];
        Arrays.fill(products,1);
        int left=1;
        for (int i=1;i<n;i++){
            left=left*nums[i-1];
            products[i]*=left;
        }
        int right=1;
        for (int j=n-2;j>=0;j--){
            right=right*nums[j+1];
            products[j]*=right;
        }
        return products;
    }
}
