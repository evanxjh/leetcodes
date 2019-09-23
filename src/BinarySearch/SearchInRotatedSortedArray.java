package BinarySearch;

/**
 * @author EvanHsia
 * @ClassName SearchInRotatedSortedArray.java
 * @Description Leetcode No.33 Medium
 * @createTime 2019-09-23- 17:34
 */
public class SearchInRotatedSortedArray {
    public int search(int[]nums ,int target){
        int l=0;
        int h=nums.length-1;
        while (l<=h){
            int mid=(h-l)/2+l;
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]>nums[h]){       //左半部分有序
                if (target>=nums[l] && target<nums[mid]){
                    h=mid-1;
                }else {
                    l=mid+1;
                }
            }else{                              //右半部分有序
                if (target>nums[mid] && target<=nums[h]){
                    l=mid+1;
                }else{
                    h=mid-1;
                }
            }
        }
        return -1;
    }
}
