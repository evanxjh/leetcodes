package Search;

/**
 * @author EvanHsia
 * @ClassName ShortestPath.java
 * @Description BFS
 * @createTime 2019-08-12- 18:54
 */


import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 计算在网格中从原点到特定点的最短路径长度，1表示可以经过某个位置，求解(0,0)到(tr,tc)的长度
 */
//BFS问题可以用队列来解决，队列中存储每一轮遍历得到的节点
public class ShortestPath {
    private class pair {
        int r;
        int c;
        public pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    public int minPathLength(int[][]grids,int tr, int tc){
        final int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
        final int m=grids.length,n=grids[0].length;
        Queue<pair> queue=new LinkedList<>();
        queue.add(new pair(0,0));
        int pathlength=0;
        while (!queue.isEmpty()){
            int cursize=queue.size();                   //队列的大小为当前层的节点数
            pathlength++;
            for (int i=0;i<cursize;i++){
                pair cur=queue.poll();
                int cr=cur.r;
                int cc=cur.c;
                grids[cr][cc]=0;                        //标记，保证以后不会找它
                for (int[] dir:direction){
                    int nr=cr+dir[0];
                    int nc=cc+dir[1];
                    if (nr<0 || nr>=m || nc<0 || nc>=n ||grids[nr][nc]==0){
                        continue;
                    }
                    if (nr==tr && nc==tc) return pathlength;
                    queue.add(new pair(nr,nc));
                }
            }
        }
        return -1;                                      //表示不可到达
    }

    @Test
    public void sometest(){
        int[][] grid=new int[][]{{1,1,0,1},{1,0,1,0},{1,1,1,1}};
        System.out.print(minPathLength(grid,1,0));
    }
}
