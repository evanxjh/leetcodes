package array.Matrix;

import edu.princeton.cs.algs4.In;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author EvanHsia
 * @ClassName KthSmallestElementInSortedMatrix.java
 * @Description No.378 Medium
 * @createTime 2019-09-24- 16:13
 */
public class KthSmallestElementInSortedMatrix {
    //二分查找
    public int kthSmallest(int[][] matrix,int k){
        int n=matrix.length;
        int lo=matrix[0][0];
        int hi=matrix[n-1][n-1];
        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            int count=0;
            for (int i=0;i<n;i++){
                for (int j=0;j<n && matrix[i][j]<=mid;j++){
                    count++;
                }
            }
            if (count<k){
                lo=mid+1;
            } else{
                hi=mid-1;
            }
        }
        return lo;
    }

    //第k小，大顶堆,全部元素加入，最后堆顶就是所求
    public int solution2(int[][] matrix,int k){
        int n=matrix.length;
       /* PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });*/
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.comparingInt(i->-i));      //大顶堆
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pq.add(matrix[i][j]);
                if(pq.size() > k){
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }

    //小顶堆，不断地poll（） k次,需要记录poll出来的坐标，并将它下面的元素添加至优先队列中
/*    public int solution3(int[][] matrix,int k){
        int n=matrix.length;

    }*/

}
