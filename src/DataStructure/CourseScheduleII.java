package DataStructure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author EvanHsia
 * @ClassName CourseScheduleII.java
 * @Description No.210 Medium
 * @createTime 2019-09-25- 20:03
 */
public class CourseScheduleII {
    private Stack<Integer> path;
    private boolean[] visited;
    private boolean[] onPath;
    public int[] findOrder(int numCourses,int[][] prerequisites){
        ArrayList<Integer> [] g=new ArrayList[numCourses];
        for (int i=0;i<numCourses;i++){
            g[i]=new ArrayList<>();
        }
        for (int[] arr:prerequisites){
            int from=arr[1];
            int to=arr[0];
            g[from].add(to);
        }
        //将检查有环和排序一起做
        return topOrder(g);
    }

    private int[] topOrder(ArrayList<Integer> [] g){
        visited = new boolean[g.length];
        onPath = new boolean[g.length];
        path=new Stack<>();
        boolean hasCycle=false;
        for(int i =0 ; i< g.length ;i++){
            if(dfs(g,i)){
                hasCycle=true;
                break;
            }
        }
        if (hasCycle) return new int[]{};
        int[] res=new int[g.length];
        int index=0;
        while (!path.isEmpty()){
            res[index++]=path.pop();
        }
        return res;
    }

    private boolean dfs(ArrayList<Integer>[] g,int v){
        //应该把判断放到下一层中来执行，这样就不会添加相同的元素了
        if (onPath[v]){
            return true;
        }
        if (visited[v]){
            return false;
        }
        onPath[v]=true;
        for (int next:g[v]){
            if (dfs(g,next)){
                return true;
            }
        }
        path.push(v);
        visited[v]=true;
        onPath[v]=false;                //回溯
        return false;
    }

    /**
     * 错误版本，stack中会有重复元素出现
     */
/*    private boolean dfs(ArrayList<Integer>[] g,int v){
        visited[v]=true;
        onPath[v]=true;
        for (int next:g[v]){
            if (!visited[next]){
                if (dfs(g,next)){
                    return true;
                }
            }else if(onPath[next]){
                return true;
            }
        }
        path.push(v);
        onPath[v]=false;
        return false;
    }*/

    @Test
    public void test(){
        int n=2;
        int[][] pre=new int[][]{{1,0}};
        findOrder(n,pre);
    }
}
