package Hashing;

/**
 * @author EvenHsia
 * @ClassName LongestConsecutiveSequence.java
 * @Description No.128 Hard
 * @createTime 2019-08-05- 10:47
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums){
        Set<Integer> set=new HashSet<>();
        int max=0;
        for (int num:nums){
            set.add(num);
        }
        for (int e:nums){
            int count=1;
            if (!set.contains(e-1)){
                while (set.contains(e+1)){
                    count++;
                    e++;
                }
            }
            max=Math.max(max,count);
        }
        return max;
    }
}
