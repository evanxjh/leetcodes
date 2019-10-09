package Search;

import java.util.*;

/**
 * @author EvanHsia
 * @ClassName WordLadderII.java
 * @Description No.126 Hard
 * @createTime 2019-10-08- 21:44
 */
public class WordLadderII {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> findLadders(String beginWord,String endWord,List<String> wordList){

        wordList.add(beginWord);
        int n=wordList.size();
        int start=n-1;
        int end=0;
        while (end<n && !wordList.get(end).equals(endWord)){
            end++;
        }
        if (end==n){
            return res;
        }
        List<Integer>[] graph=buildgraph(wordList);
        getPaths(graph,start,end,wordList);
        return res;
    }

    private void getPaths(List<Integer>[] graph,int start,int end,List<String> wordList){
        HashSet<Integer> used=new HashSet<>();
        Queue<LinkedList<Integer>> q=new LinkedList<>();
        boolean found=false;
        List<LinkedList<Integer>> ret=new ArrayList<>();

        LinkedList<Integer> first=new LinkedList<>();
        first.add(start);
        q.add(first);
        used.add(start);

        while (!q.isEmpty()){
            int size=q.size();
            //对于每一层都有一个loaclused，这样保证通过不同路径到达某层的同一个词，都可以转换到最终的结果
            HashSet<Integer> localused=new HashSet<>();
            while (size-->0){
                LinkedList<Integer> curr=q.poll();
                int last=curr.getLast();
                for (int next:graph[last]){
                    if (!used.contains(next)){
                        LinkedList<Integer> list=new LinkedList<>(curr);
                        list.addLast(next);
                        if (next==end){
                            found=true;
                            ret.add(list);
                            continue;
                        }
                        localused.add(next);
                        q.offer(list);
                    }
                }
            }
            for (int i:localused){
                used.add(i);
            }
            if (found) break;
        }
        for (LinkedList<Integer> linkedList:ret){
            List<String> list=new ArrayList<>();
            for (int i:linkedList){
                list.add(wordList.get(i));
            }
            res.add(list);
        }
    }

    private List<Integer>[] buildgraph(List<String> wordList){
        int N=wordList.size();
        List<Integer>[] graph=new List[N];
        for (int i=0;i<N;i++){
            graph[i]=new ArrayList<>();
            for (int j=0;j<N;j++){
                if (isconnect(wordList.get(i),wordList.get(j))){
                    graph[i].add(j);
                }
            }
        }
        return graph;
    }

    private boolean isconnect(String a,String b){
        int diff=0;
        for (int i=0;i<a.length();i++){
            if (a.charAt(i)!=b.charAt(i)){
                diff++;
            }
        }
        return diff==1;
    }
}
