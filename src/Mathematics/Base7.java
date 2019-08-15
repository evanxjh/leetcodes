package Mathematics;

/**
 * @author EvanHsia
 * @ClassName Base7.java
 * @Description No.504 Easy
 * @createTime 2019-08-15- 16:53
 */
public class Base7 {
    public String convertToBase7(int num){
        if (num==0){
            return "0";
        }
        StringBuffer sb=new StringBuffer();
        boolean isNegative=num<0;
        if (isNegative){
            num=-num;
        }
        while (num>0){
            sb.append(num%7);
            num/=7;
        }
        String res=sb.reverse().toString();
        return isNegative?"-"+res:res;
    }


    //直接用java的toString函数，可以将一个整数转换为radix进制的字符串
    public String convert(int num){
        return Integer.toString(num,7);
    }
}
