package Mathematics;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * @author EvanHsia
 * @ClassName gcd.java
 * @Description 最大公约数
 * @createTime 2019-08-15- 16:42
 */
public class gcd {
    //辗转相除法
    public int gcd(int a,int b){
        return b==0?a:gcd(b,a % b);
    }

    //位运算和减法求解
    //a,b均为偶数
    //a,b一奇一偶
    //a，b都是奇数
    public int gcd2(int a,int b){
        if (a<b){
            return gcd2(b,a);
        }
        if (b==0){
            return a;
        }
        boolean isAEven=(a%2==0),isBEven=(b%2==0);
        if (isAEven&&isBEven){
            return gcd2(a>>1,b>>1)*2;
        } else if (isAEven){
            return gcd(a>>1,b);
        } else if (isBEven){
            return gcd(a,b>>1);
        } else {
            return gcd(b,a-b);
        }
    }
    @Test
    public void sometest(){
        assertEquals(6,gcd(24,18));
        assertEquals(1,gcd(35,8));
        assertEquals(6,gcd2(24,18));
        assertEquals(1,gcd2(35,8));
    }
}
