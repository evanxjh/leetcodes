package Search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author EvanHsia
 * @ClassName OpenTheLock.java
 * @Description No.752 Medium
 * @createTime 2019-10-09- 10:27
 */
public class OpenTheLock {
    public int openLock(String[] deadends,String target){
        Set<String> deadSet=new HashSet<>();
        for (String deadend:deadends){
            deadSet.add(deadend);
        }

        if (deadSet.contains(target)|| deadSet.contains("0000")){
            return -1;
        }

        Set<String> visited=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        q.add("0000");
        int path=0;
        visited.add("0000");
        while (!q.isEmpty()){
            int size=q.size();
            path++;
            while (size-->0){
                //寻找下一层的节点
                String cur=q.poll();
                Set<String> next=getNext(cur,deadSet);
                for (String nextstr:next){
                    if (!visited.contains(nextstr)){
                        if (target.equals(nextstr)){
                            return path;
                        }
                        visited.add(nextstr);
                        q.add(nextstr);
                    }
                }

            }
        }
        return -1;
    }

    private Set<String> getNext(String cur,Set<String> deadSet){
        Set<String> res=new HashSet<>();
        for (int i=0;i<4;i++){
            int num= cur.charAt(i)-'0';
            int d=(num+1)%10;
            String t=cur.substring(0,i)+((char)(d+'0'))+cur.substring(i+1,4);
            if (!deadSet.contains(t)){
                res.add(t);
            }
            d=(num+9)%10;
            t=cur.substring(0,i)+((char)(d+'0'))+cur.substring(i+1,4);
            if (!deadSet.contains(t)){
                res.add(t);
            }
        }
        return res;
    }
}
