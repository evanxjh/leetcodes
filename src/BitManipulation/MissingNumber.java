package BitManipulation;

/**
 * @author EvenHsia
 * @ClassName MissingNumber.java
 * @Description No.268 Easy
 * @createTime 2019-08-06- 12:46
 */
public class MissingNumber {
    public int missingNumber(int[] nums){
        int ret=0;
        for (int i=0;i<nums.length;i++){
            ret^=nums[i]^i;
        }
        return ret^nums.length;
    }
}
