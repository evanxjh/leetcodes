package Mathematics;

/**
 * @author EvanHsia
 * @ClassName FactorialTrailingZeros.java
 * @Description No.172 Easy
 * @createTime 2019-08-16- 14:59
 */

/**
 * 统计阶乘尾部有多少个0
 */
//被5整除的个数，加上被25整除的，加上被125整除的
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n){
        return n==0?0:n/5+trailingZeroes(n/5);            //递归调用，求解包含5的幂次的个数
    }
}
