package array;

import java.util.PriorityQueue;

/**
 * @author EvenHsia
 * @ClassName KthSmallestElement.java
 * @Description No.378 Medium
 * @createTime 2019-08-05- 19:51
 */
public class KthSmallestElement {
    public int kthSmallest(int[][] matrix,int k){
        int m=matrix.length;
        int n=matrix[0].length;
        int lo=matrix[0][0];
        int hi=matrix[m-1][n-1];
        while (lo<=hi){
            int mid=(hi-lo)/2+lo;
            int cnt=0;
            for (int i=0;i<m;i++){
                for (int j=0;j<n && matrix[i][j]<=mid;j++){
                    cnt++;
                }
            }
            if (cnt<k) lo=mid+1;
            else hi=mid-1;
        }
        return lo;
    }

    //heap
    public int kthSmallestheap(int[][] matrix,int k){
        int m=matrix.length,n=matrix[0].length;
        PriorityQueue<Tuple> pq=new PriorityQueue<Tuple>();      //二叉小顶堆
        for (int j=0;j<n;j++){
            pq.offer(new Tuple(0,j,matrix[0][j]));
        }
        for (int i=0;i<k-1;i++){                                 //移除了k-1个
            Tuple t=pq.poll();
            if (t.x==m-1) continue;
            pq.offer(new Tuple(t.x+1,t.y,matrix[t.x+1][t.y]));
        }
        return pq.poll().val;

    }
    private class Tuple implements Comparable<Tuple>{
        int x,y,val;
        public Tuple(int x,int y,int val){
            this.x=x;
            this.y=y;
            this.val=val;
        }
        @Override
        public int compareTo(Tuple t){
            return this.val-t.val;
        }
    }
}
