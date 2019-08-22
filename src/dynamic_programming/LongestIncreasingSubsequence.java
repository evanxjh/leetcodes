package dynamic_programming;

/**
 * @author EvanHsia
 * @ClassName LongestIncreasingSubsequence.java
 * @Description No.300 Medium
 * @createTime 2019-08-22- 11:12
 */
/*
 * dp[n]=max{1,dp[i]+1 | Si<Sn && i<n}
 * 一种是Sn比前面的都小，则构成一个长度为1的子序列，否则就是在前面某个子序列的基础上加上当前的Sn
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums){
        int n=nums.length;
        int[] dp=new int[n];
        for (int i=0;i<n;i++){
            int max=1;
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]){
                    max=Math.max(max,dp[j]+1);
                }
            }
            dp[i]=max;
        }
        int ret=0;
        for (int i=0;i<n;i++){
            ret=Math.max(ret,dp[i]);
        }
        return ret;
    }

    //解法2时间复杂度O(nlog(n))，用一个tail数组，tail[i]存储i+1长度递增子序列的最后一个元素，tail数组有序
    //因此可以用二分查找
    public int lengthOfLIS2(int[] nums){
        int n=nums.length;
        int[] tails=new int[n];
        int len=0;
        for (int num:nums){
            int index=binarysearch(tails,len,num);
            tails[index]=num;
            if (index==len){     //大于所有值，加到最后面，tails长度+1
                len++;
            }
        }
        return len;
    }
    private int binarysearch(int[] tails,int len,int key){
        int l=0,h=len-1;
        while (l<=h){
            int mid=l+(h-l)/2;
            if (key<tails[mid]){
                h=mid-1;
            } else if (key>tails[mid]){
                l=mid+1;
            } else {
                return mid;
            }
        }
        return l;
    }
}
