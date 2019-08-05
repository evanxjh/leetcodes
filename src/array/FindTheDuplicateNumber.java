package array;

/**
 * @author EvenHsia
 * @ClassName FindTheDuplicateNumber.java
 * @Description No.287 Medium
 * @createTime 2019-08-05- 22:01
 */

import org.junit.Test;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * !!!must not modify the array
 */
public class FindTheDuplicateNumber {
    //二分查找
    public int findDuplicate(int[] nums){
        int lo=1;
        int hi=nums.length-1;
        while (lo<=hi){
            int mid=(hi-lo)/2+lo;
            int cnt=0;
            for (int item:nums){
                if (item<=mid){
                    cnt++;
                }
            }
            if (cnt>mid) hi=mid-1;
            else lo=mid+1;
        }
        return lo;
    }
    //双指针法，相当于链表中存在环,找出环的入口
    public int findDuplicate2(int[] nums){
        int slow=nums[0];
        int fast=nums[nums[0]];
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        //此时fast比slow快了一倍，设fast走了2s，slow走了s，环长为r
        //则2s=s+nr
        //s=nr
        //设链表长L，入口环与相遇点距离为x，起点到环入口点距离为a
        //a+x=nr   a+x=(n-1)r+r=(n-1)r+L-a
        //a=(n-1)r+(L-a-x)      L-a-x为相遇点到环起点的步数
        //放一个指针在链表头，另一个放在相遇点，每次动一步，必定会在环入口处首次相遇
        fast=0;
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }

    @Test
    public void sometest(){
        int[] nums=new int[]{1,4,3,2,5,6,3};
        System.out.print(findDuplicate2(nums));
    }
}
