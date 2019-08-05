package array;

/**
 * @author EvenHsia
 * @ClassName MaxConsecutiveOnes.java
 * @Description findMaxConsecutiveOnes
 * @createTime 2019-08-05- 16:24
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums){
        int max=0,cur=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==1){
                cur++;
            } else if (cur!=0){
                max=Math.max(max,cur);
                cur=0;
            }
        }
        return Math.max(max,cur);
    }
}
