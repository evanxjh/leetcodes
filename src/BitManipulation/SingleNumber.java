package BitManipulation;

/**
 * @author EvenHsia
 * @ClassName SingleNumber.java
 * @Description No.136 Easy
 * @createTime 2019-08-06- 12:20
 */
public class SingleNumber {
    public int singleNumber(int[] nums){
        int ret=0;
        for (int num:nums){
            ret=ret^num;
        }
        return ret;
    }
}
