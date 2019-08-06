package array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author EvenHsia
 * @ClassName DegreeOfAnArray.java
 * @Description No.697 Easy
 * @createTime 2019-08-06- 09:32
 */
public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums){
        int shortest=Integer.MAX_VALUE;
        int maxcnt=0;
        Map<Integer,node> startindex= new HashMap<>();      //用了node就可以不需要多个hashmap了
        for (int i=0;i<nums.length;i++){
            if (!startindex.containsKey(nums[i])){
                startindex.put(nums[i],new node(i,1));
            }else{
                startindex.get(nums[i]).counts++;
            }
            node cur=startindex.get(nums[i]);
            if (cur.counts==maxcnt){
                shortest=Math.min(shortest,i-cur.index+1);
            } else if(cur.counts>maxcnt){
                shortest=i-cur.index+1;
                maxcnt=cur.counts;
            }
        }
        return shortest;
    }
    private class node{
        int index;
        int counts;
        public node(int i,int c){
            index=i;
            counts=c;
        }
    }

    @Test
    public void sometest(){
        int[] nums=new int[]{1,2,2,3,1};
        System.out.print(findShortestSubArray(nums));
    }
}
