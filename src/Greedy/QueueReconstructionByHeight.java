package Greedy;

/**
 * @author EvanHsia
 * @ClassName QueueReconstructionByHeight.java
 * @Description No.406 Medium
 * @createTime 2019-08-09- 10:29
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 一个学生用两个分量( h,k)描述，h表示很高，k表示排在前面的有k个学生身高比他高或者和他一样高
 * 要对一个随机的队列重新排列，使其满足上述要求
 */
//贪心策略：h按降序排列，k按升序排列，从个子高的人开始插入，插入到第k个位置，前面正好有k个比他高，即0到k-1
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people){
        if (people==null || people.length==0 || people[0].length==0) {
            return new int[0][0];
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];                         //k升序
                }else {
                    return o2[0]-o1[0];                         //h降序
                }
            }
        });
        List<int[]> queue=new ArrayList<>();
        for (int[] p:people){
            queue.add(p[1],p);                                  //如果当前位置有元素，则将后续元素向右移动一位
        }
        return queue.toArray(new int[queue.size()][]);          //toArray的用法，值得关注
    }
}
