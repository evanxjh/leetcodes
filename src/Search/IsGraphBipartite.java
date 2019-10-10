package Search;

import java.util.Arrays;

/**
 * @author EvanHsia
 * @ClassName IsGraphBipartite.java
 * @Description No.785 Medium
 * @createTime 2019-10-10- 14:19
 */
public class IsGraphBipartite {
    private int[] checked;
    public boolean isBipartite(int[][] graph){
        checked=new int[graph.length];
        Arrays.fill(checked,-1);
        for (int i=0;i<graph.length;i++){
            if (checked[i]==-1){
                if (!check(graph,i,0))
                    return false;
            }
        }
        return true;
    }

    private boolean check(int[][] graph,int cur,int group){
        if (checked[cur]!=-1){
            return checked[cur]==group;
        }
        checked[cur]=group;
        for (int next:graph[cur]){
            if (!check(graph,next,1-group)){            //判断next是否与当前组不同
                return false;
            }
        }
        return true;
    }
}
