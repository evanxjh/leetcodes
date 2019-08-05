package Hashing;

/**
 * @author EvenHsia
 * @ClassName ContainsDuplicate.java
 * @Description No.217 Easy
 * @createTime 2019-08-05- 10:23
 */

import java.util.HashSet;

/**
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 */
public class ContainsDuplicate {
    public boolean containsDuplicates(int[] nums){
        HashSet<Integer> set=new HashSet<>();
        for (int i:nums){
            set.add(i);
        }
        return set.size()<nums.length;
    }
}
