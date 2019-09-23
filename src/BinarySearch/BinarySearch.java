package BinarySearch;

/**
 * @author EvanHsia
 * @ClassName BinarySearch.java
 * @Description 二分查找
 * @createTime 2019-09-23- 17:16
 */
public class BinarySearch {
    //在[l,h]搜索
    public int search(int[] nums,int target){
        int l=0,h=nums.length-1;
        while (l<=h){
            int m=l+(h-l)/2;
            if (target<nums[m]){
                h=m-1;
            }else if (target>nums[m]){
                l=m+1;
            }else {
                return m;
            }
        }
        return -1;
    }
    //在 [l,h)搜索
    public int search2(int[] nums,int target){
        int l=0,h=nums.length;
        while (l<h){
            int m=l+(h-l)/2;
            if (target==nums[m]){
                return m;
            }else if (nums[m]>target){
                h=m;
            }else{
                l=m+1;
            }
        }
        return -1;
    }
}
