package BitManipulation;

/**
 * @author EvenHsia
 * @ClassName SingleNumberIII.java
 * @Description No.260 Medium
 * @createTime 2019-08-06- 13:02
 */
//也可以用Hashet做
public class SingleNumberIII {
    public int[] singleNumber(int[] nums){
        int diff=0;
        for (int i=0;i<nums.length;i++){            //得到两个不同元素的异或结果
            diff^=nums[i];
        }
        int[] ret=new int[2];
        diff =diff&(-diff);                               //得到最右的一位
        for (int num:nums){
            if ((num&diff)==0) ret[0]^=num;         //利用diff可以将两个不同的元素区分出来
            else ret[1]^=num;
        }
        return ret;
    }
}
