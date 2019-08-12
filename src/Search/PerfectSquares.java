package Search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author EvanHsia
 * @ClassName PerfectSquares.java
 * @Description No.279 Medium
 * @createTime 2019-08-12- 19:24
 */
//也可以用dp解决，这里用BFS解决，将每个整数看成图中的节点，如果两数之差为平方数，则两节点之间就有一条边，求n到0的最短路径
public class PerfectSquares {
    public int numSquares(int n){
        List<Integer> squares=generateSquare(n);
        Queue<Integer> queue=new LinkedList<>();
        boolean[] marked=new boolean[n+1];
        queue.add(n);
        marked[n]=true;
        int path=0;
        while (!queue.isEmpty()){
            int cursize=queue.size();
            path++;
            while (cursize-->0){
                int cur=queue.poll();
                for (int sq:squares){
                    int newn=cur-sq;
                    if (newn<0){
                        break;                  //后面都是小于0
                    }
                    if (newn==0 ) return path;      //至少需要1个
                    if (marked[newn]){
                        continue;
                    }
                    marked[newn]=true;
                    queue.add(newn);
                }
            }
        }
        return n;
    }
    private List<Integer> generateSquare(int n){
        List<Integer> res=new ArrayList<>();
        int square=1;
        int diff=3;
        while (square<=n){
            res.add(square);
            square+=diff;
            diff+=2;
        }
        return res;
    }
}
