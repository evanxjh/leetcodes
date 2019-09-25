package DataStructure;

import java.util.*;

/**
 * @author EvanHsia
 * @ClassName CourseScheduleII2.java
 * @Description 第二种方法，入度为0
 * @createTime 2019-09-25- 20:41
 */
public class CourseScheduleII2 {
    public int[] findOrder(int numCourses,int[][] prerequisites){
        ArrayList<Integer>[] g=new  ArrayList[numCourses];
        int[] indegrees=new int[numCourses];
        int edge=prerequisites.length;
        Queue<Integer> setOfZeros=new LinkedList<>();
        ArrayList<Integer> order=new ArrayList<>();

        for (int i=0;i<g.length;i++){
            g[i]=new ArrayList<>();
        }

        for (int[] arr:prerequisites){
            int from=arr[1];
            int to=arr[0];
            indegrees[to]++;
            g[from].add(to);
        }

        //统计入度为0的顶点
        for (int i=0;i<indegrees.length;i++){
            if (indegrees[i]==0){
                setOfZeros.offer(i);
            }
        }

        while (!setOfZeros.isEmpty()){
            int curNode=setOfZeros.poll();
            order.add(curNode);
            for (int next:g[curNode]){
                edge--;
                indegrees[next]--;
                if (indegrees[next]==0){
                    setOfZeros.offer(next);
                }
            }
        }

        if (edge!=0){
            return new int[]{};
        }

        int[] res=new int[g.length];
        int index=0;
        for (int item:order){
            res[index++]=item;
        }
        return res;
    }

}
