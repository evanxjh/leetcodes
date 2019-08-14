package BinarySearch;

/**
 * @author EvanHsia
 * @ClassName SingleElement.java
 * @Description No.540 Medium
 * @createTime 2019-08-14- 16:30
 */

/**
 *   一个有序数组所有的元素都出现两次，只有一个出现1次，求出只出现一次的那个元素
 *
 *   Your solution should run in O(log n) time and O(1) space.
 */
//第一反应：位运算  xor 但时间复杂度位O(n)
public class SingleElement {
    public int singleNonDuplicate(int[] nums){
        int ret=0;
        for (int i=0;i<nums.length;i++){
            ret^=nums[i];
        }
        return ret;
    }

    //使用二分查找  时间复杂度位log(N)
    public int singleNonDuplicate2(int[] nums){
        int l=0,h=nums.length-1;
        while (l<h){
            int m=l+(h-l)/2;
            if (m%2==1){
                m--;
            }
            if (nums[m]==nums[m+1]){
                l=m+2;
            } else {
                h=m;                      //有这个上面while就不能取等号，防止死循环
            }
        }
        return nums[l];             //return nums[h]也是一样的
    }
}
