package BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EvanHsia
 * @ClassName AllPathsFromSourceToTarget.java
 * @Description No.797 Medium
 * @createTime 2019-10-12- 10:56
 */
public class AllPathsFromSourceToTarget {
    private List<List<Integer>> path;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph){
        path=new ArrayList<>();
        if (graph==null){
            return path;
        }
        boolean[] visited=new boolean[graph.length];
        int start=0;
        dfs(start,visited,new ArrayList<>(),graph.length-1,graph);
        return path;
    }
    private void dfs(int cur,boolean[] visited,List<Integer> p,int n,int[][] graph){
        if (cur==n){
            p.add(cur);
            path.add(new ArrayList<>(p));
            p.remove(p.size()-1);
            return;
        }
        p.add(cur);
        visited[cur]=true;
        for (int next:graph[cur]){
            if (!visited[next]){
                dfs(next,visited,p,n,graph);
            }
        }
        visited[cur]=false;                         //回溯
        p.remove(p.size()-1);                //回溯
    }
}
