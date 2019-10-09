package Search;

/**
 * @author EvanHsia
 * @ClassName WordLadder.java
 * @Description No.127 Medium
 * @createTime 2019-08-12- 19:42
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 找出一条从 beginWord 到 endWord 的最短路径，每次移动规定为改变一个字符，并且改变之后的字符串必须在 wordList 中。
 */
//规定必须要在wordList中，不能用编辑距离来计算
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        wordList.add(beginWord);
        int n=wordList.size();
        int start=n-1;
        int end=0;
        while (end<n && !wordList.get(end).equals(endWord)){
            end++;
        }
        if (end==n){       //全不是endWord
            return 0;
        }
        List<Integer>[] graphic=buildGraph(wordList);
        return getShortPath(graphic,start,end);
    }

    private int getShortPath(List<Integer>[] graphic,int start,int end){
        Queue<Integer> queue=new LinkedList<>();
        boolean[] ismarked=new boolean[graphic.length];
        queue.add(start);
        ismarked[start]=true;
        int path=1;
        while (!queue.isEmpty()){
            int size=queue.size();
            path++;
            while (size-->0){
                int cur=queue.poll();
                for (int next:graphic[cur]){
                    if (next==end){
                        return path;
                    }
                    if (ismarked[next]){
                        continue;
                    }
                    ismarked[next]=true;
                    queue.add(next);
                }
            }
        }
        return 0;
    }

    private List<Integer>[] buildGraph(List<String> wordList){        //对wordList中的单词编号，将相邻的两个word的序号绑定
        int n=wordList.size();
        List<Integer>[] graph=new List[n];
        for (int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
            for (int j=0;j<n;j++){
                if (isConnected(wordList.get(i),wordList.get(j))){
                    graph[i].add(j);
                }
            }
        }
        return graph;
    }
    private boolean isConnected(String s1,String s2){
        int diffCnt=0;
        for (int i=0;i<s1.length();i++){
            if (s1.charAt(i)!=s2.charAt(i)){
                diffCnt++;
            }
        }
        return diffCnt==1;
    }
}
