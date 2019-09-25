package DataStructure;

import java.util.ArrayList;

/**
 * @author EvanHsia
 * @ClassName CourseSchedule.java
 * @Description No.207 Medium
 * @createTime 2019-09-25- 19:45
 */

//判断有向图是否有环
public class CourseSchedule {
    private boolean[] visited;      //记录节点的访问情况
    private boolean[] onPath;       //记录有向环的顶点
    ArrayList<Integer>[] g;
    public boolean canFinish(int numCourses,int[][] prerequisites){
        g=new ArrayList[numCourses];
        for (int i=0;i<numCourses;i++){
            g[i]=new ArrayList<>();
        }
        //构造图
        for (int[] arr:prerequisites){
            int from=arr[1];
            int to=arr[0];
            g[from].add(to);
        }
        return !hasCycle(g);
    }

    private boolean hasCycle(ArrayList<Integer>[] g){
        visited=new boolean[g.length];
        onPath=new boolean[g.length];
        for (int i=0;i<g.length;i++){
            if (!visited[i]){
                if (dfs(g,i,visited,onPath)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(ArrayList<Integer>[] g,int v,boolean[] visited,boolean[] onPath){
        visited[v]=true;
        onPath[v]=true;
        for (int next:g[v]){
            if (!visited[next]){
                if (dfs(g,next,visited,onPath)){
                    return true;
                }
            }else if (onPath[next]){
                return true;
            }
        }
        onPath[v]=false;                                //回溯
        return false;
    }
}
