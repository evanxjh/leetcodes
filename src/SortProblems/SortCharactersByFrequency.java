package SortProblems;

/**
 * @author EvanHsia
 * @ClassName SortCharactersByFrequency.java
 * @Description No.451 Medium
 * @createTime 2019-08-07- 14:08
 */

import edu.princeton.cs.algs4.In;

import java.util.*;

/**
 * radix sort
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s){
        int n=s.length();
        List<Character>[] frequency=new ArrayList[n+1];             //第i个存储出现频率为i次的字母
        Map<Character,Integer> hm=new HashMap<>();
        for (int i=0;i<n;i++){
            char c=s.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        for (char c:hm.keySet()){
            int f=hm.get(c);
            if (frequency[f]==null) {
                frequency[f]=new ArrayList<>();
            }
            frequency[f].add(c);
        }
        StringBuffer bf=new StringBuffer();
        for (int i=n;i>=0;i--){
            if (frequency[i]==null) continue;
            for (char thisc:frequency[i]){
                for (int j=0;j<i;j++){
                    bf.append(thisc);
                }
            }
        }
        return bf.toString();
    }

    // 优先队列，比较慢
    public String heappriorityqueue(String s){
        int n=s.length();
        Map<Character,Integer> hm=new HashMap<>();
        PriorityQueue<Character> pq=new PriorityQueue<>((i,j)->hm.get(j)-hm.get(i));        //大顶堆
        for (int i=0;i<n;i++){
            char c=s.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        for (char c:hm.keySet()){
            pq.offer(c);
        }
        StringBuffer bf=new StringBuffer();
        while(!pq.isEmpty()){
            char c=pq.poll();
            for (int i=0;i<hm.get(c);i++){
                bf.append(c);
            }
        }
        return bf.toString();
    }
}
