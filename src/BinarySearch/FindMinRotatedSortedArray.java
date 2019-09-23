package BinarySearch;

/**
 * @author EvanHsia
 * @ClassName FindMinRotatedSortedArray.java
 * @Description No.153 Medium
 * @createTime 2019-08-14- 16:58
 */
public class FindMinRotatedSortedArray {
    public int findMin(int[] nums){
        int l=0,h=nums.length-1;
        while (l<h) {
            int m = l + (h - l) / 2;
            if (nums[m]<nums[h]){
                h=m;                     //m处可能为最小值
            } else {
                l=m+1;                   //m处不可能为最小值
            }
        }
        return nums[h];                  //返回h和l都可以
    }
}
