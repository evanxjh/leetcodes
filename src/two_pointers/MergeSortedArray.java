package two_pointers;

/**
 * @program: leetcodetrain
 * @description: No.88 Easy
 * @author: EvenHsia
 * @create: 2019-07-25 22:44
 **/

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 *
 */
public class MergeSortedArray {
    public void merge(int[] nums1,int m,int nums2[],int n){
        int index1=m-1;
        int index2=n-1;
        int indexmerge=m+n-1;
        while (index1>=0 || index2>=0){
            if (index1<0){                                      //数组1已归并完，直接归并2
                nums1[indexmerge--]=nums2[index2--];
            } else if (index2<0){                               //数组2已归并完，不需要再操作
                return;
            } else if (nums1[index1]<=nums2[index2]){           //尽量先放nums2中的元素，所以用<=
                nums1[indexmerge--]=nums2[index2--];
            } else {
                nums1[indexmerge--]=nums1[index1--];
            }
        }
    }

    public static void main(String[] args){
        int [] nums1=new int[]{1,4,6,0,0,0};
        int [] nums2=new int[]{4,5,7};
        int m=3,n=3;
        MergeSortedArray test=new MergeSortedArray();
        test.merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}
