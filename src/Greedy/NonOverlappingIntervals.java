package Greedy;

/**
 * @author EvanHsia
 * @ClassName NonOverlappingIntervals.java
 * @Description No.435 Medium
 * @createTime 2019-08-08- 20:21
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * 计算让一组取间不重叠所需移除的区间的个数
 */
//贪心：先计算最多能组成的不重叠区间数，然后区间总数减去它，每次选择中，区间的结果越小，留给后面的区间空间越大
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals){
        if (intervals.length==0){
            return 0;
        }
        //Arrays.sort(intervals,(o1,o2)->o1[1]-o2[1]);
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int cnt=1;
        int pre=intervals[0][1];
        for (int i=1;i<intervals.length;i++){
            if (intervals[i][0]>=pre) {
                cnt++;
                pre=intervals[i][1];
            }
        }
        return intervals.length-cnt;
    }


    //动态规划解法：按区间开始值排序，转为最长上升子序列问题
    public int eraseOverlapInterval(int[][] intervals){
        int n=intervals.length;
        if (n==0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
            }
        });
        int[] memo=new int[n];
        for (int i=0;i<n;i++){
            memo[i]=1;
        }
        for (int i=1;i<n;i++){
            for (int j=0;j<i;j++){
                if (intervals[i][0]>=intervals[j][1]){
                    memo[i]=Math.max(memo[i],memo[j]+1);
                }
            }
        }
        int res=0;
        for (int i=0;i<n;i++){
            res=Math.max(res,memo[i]);
        }
        return res;
    }
}
