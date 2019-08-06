package BitManipulation;

/**
 * @author EvanHsia
 * @ClassName SumOfTwoIntegers.java
 * @Description No.371 Easy
 * @createTime 2019-08-06- 17:02
 */

// (a&b)<<1为进位，a^b为不进位的加法，两者相加，即为结果
public class SumOfTwoIntegers {
    public int getSum(int a,int b){
        return b==0?a:getSum(a^b,(a&b)<<1);
    }
}
