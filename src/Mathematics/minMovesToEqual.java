package Mathematics;

import java.util.Arrays;

/**
 * @author EvanHsia
 * @ClassName minMovesToEqual.java
 * @Description No.462 Medium
 * @createTime 2019-08-21- 09:50
 */
//可以证明，移动到数组的中位数所需的操作是最少的
public class minMovesToEqual {
    //方法一，先排序，后计算复杂度O(nlogn)
    public int minMoves2(int[] nums){
        Arrays.sort(nums);
        int move=0;
        int i=0,j=nums.length-1;
        while (i<=j){
            move+=nums[j--]-nums[i++];
        }
        return move;
    }

    //方法二，用快速选择找到中位数,复杂度O(n)
    public int minmoves2(int[] nums){
        int move=0;
        int median=findKthSmallest(nums,nums.length/2);
        for (int num:nums){
            move+=Math.abs(num-median);
        }
        return move;
    }
    private int findKthSmallest(int[] nums,int k){
        int l=0,h=nums.length-1;
        while (l<h){
            int j=partition(nums,l,h);
                if (j==k){
                    break;
                }
                if (j<k){
                    l=j+1;
                } else {
                    h=j-1;
            }
        }
        return nums[k];
    }
    private int partition(int[] nums,int l,int h){
        int i=l,j=h+1;
        while(true){
            while (nums[++i]<nums[l] && i<h);
            while (nums[--j]>nums[l] && j>l);
            if (i>=j){
                break;
            }
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
