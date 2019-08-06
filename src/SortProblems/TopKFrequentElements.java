package SortProblems;

import edu.princeton.cs.algs4.In;

import java.util.*;

/**
 * @author EvanHsia
 * @ClassName TopKFrequentElements.java
 * @Description No.347 Medium
 * @createTime 2019-08-06- 21:52
 */

public class TopKFrequentElements {
    //桶排序
    // 设置若干个桶，每个桶存储出现频率相同的数。桶的下标表示数出现的频率，即第 i 个桶中存储的数出现的频率为 i。
    public List<Integer> topKFrequent(int[] nums,int k){
        Map<Integer,Integer> frequency=new HashMap<>();
        for (int num:nums){
            frequency.put(num,frequency.getOrDefault(num,0)+1);
        }
        List<Integer>[] buckets=new ArrayList[nums.length+1];             //桶
        for (int key:frequency.keySet()){
            int fre=frequency.get(key);
            if (buckets[fre]==null){
                buckets[fre]=new ArrayList<>();
            }
            buckets[fre].add(key);
        }
        //从后往前遍历桶
        List<Integer> topK=new ArrayList<>();
        for (int i=buckets.length-1;i>=0&&topK.size()<k;i--){
            if (buckets[i]==null) continue;
            if (buckets[i].size()<= k-topK.size()){
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0,k-topK.size()));
            }
        }
        return topK;
    }

    //堆-优先队列
    public List<Integer> topKFrequent2(int[] nums,int k){
        if (nums.length==0 ||nums==null) return null;
        List<Integer> topK=new ArrayList<>();                                  //store results
        Map<Integer,Integer> hm=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>((i,j)->hm.get(j)-hm.get(i));       //j-i大顶堆
        for (int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        pq.addAll(hm.keySet());
        while (k>0){
            topK.add(pq.poll());
            k--;
        }
        return topK;
    }

    //小顶堆
    public List<Integer> topKFrequent3(int[] nums,int k){
        if (nums.length==0 ||nums==null) return null;
        List<Integer> topK=new ArrayList<>();                                  //store results
        Map<Integer,Integer> hm=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>((i,j)->hm.get(i)-hm.get(j));       //默认小顶堆
        for (int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        for (int num:hm.keySet()){
            pq.add(num);
            if (pq.size()>k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            topK.add(pq.poll());
        }
        Collections.reverse(topK);
        return topK;
    }
}
