package Mathematics;

/**
 * @author EvanHsia
 * @ClassName Base16.java
 * @Description No.405 Easy
 * @createTime 2019-08-16- 14:23
 */
public class Base16 {
    public String toHex(int num){
        final char[] map={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        if (num==0){
            return "0";
        }
        StringBuffer sb=new StringBuffer();
        while (num!=0){
            sb.append(map[ num & 0b1111]);
            num>>>=4;                           //java中采用的是补码运算，符号位不能有特殊的意义，所以需要使用无符号右移
        }
        return sb.reverse().toString();
    }

    //直接采用java自带的转换
    public String toHex2(int num){
        return Integer.toHexString(num);
    }
}
