package Search;

import java.util.HashSet;
import java.util.Set;

/**
 * @author EvanHsia
 * @ClassName IntersectionOfTwoArrays.java
 * @Description No.349 Easy
 * @createTime 2019-09-24- 17:13
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1,int[]nums2){
        Set<Integer> record=new HashSet<>();
        Set<Integer> res=new HashSet<>();
        for (int item:nums1){
            record.add(item);
        }
        for (int item:nums2){
            if (record.contains(item)){
                res.add(item);
            }
        }
        int []ret=new int[res.size()];
        int i=0;
        for (int item:res){
            ret[i++]=item;
        }
        return ret;
    }
}
