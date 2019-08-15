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
    public int gcd(int a,int b){
        return b==0?a:gcd(b,a % b);
    }


    @Test
    public void sometest(){
        assertEquals(6,gcd(24,18));
        assertEquals(1,gcd(35,8));
    }
}
