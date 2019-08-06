package BitManipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author EvenHsia
 * @ClassName ReverseBits.java
 * @Description No.190 Easy
 * @createTime 2019-08-06- 13:40
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret <<= 1;
            ret = ret | (n & 1);
            n >>>= 1;                   //右移和无符号右移皆可
        }
        return ret;
    }

    //将int拆成byte处理,调用很多次reverse，存在Map里可以减少运算
    private static Map<Byte,Integer> cache=new HashMap<>();
    public int reverseBits2(int n){
        int ret=0;
        for (int i=0;i<4;i++){          //1个int为4个Byte
            ret<<=8;
            ret |=reverseByte((byte) (n & 0b11111111));
            n >>=8;
        }
        return ret;
    }
    private int reverseByte(byte b){                //逆序并存放进Map
        if (cache.containsKey(b)) return cache.get(b);
        int ret=0;
        byte t=b;
        for (int i=0;i<8;i++){
            ret<<=1;
            ret |= (t & 1);
            t >>=1;
        }
        cache.put(b,ret);
        return ret;
    }
}
