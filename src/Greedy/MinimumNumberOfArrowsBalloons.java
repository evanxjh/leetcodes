package Greedy;

/**
 * @author EvanHsia
 * @ClassName MinimumNumberOfArrowsBalloons.java
 * @Description No.452 Medium
 * @createTime 2019-08-08- 20:40
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * 气球在一个水平数轴上摆放，可以重叠,飞镖垂直投降坐标轴，使得路径上的气球都被刺破，求最少投掷次数，刺破全部气球
 */
//区间选点问题
//贪心策略：计算不重叠区间个数，只不过[1,2]和[2,3]算是重叠的区间
public class MinimumNumberOfArrowsBalloons {
    public int findMinArrowShots(int[][] points){
        if (points.length==0){
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int ret=1;
        int pre=points[0][1];
        for (int i=1;i<points.length;i++){
            if (points[i][0]>pre){
                ret++;
                pre=points[i][1];
            }
        }
        return ret;
    }
}
