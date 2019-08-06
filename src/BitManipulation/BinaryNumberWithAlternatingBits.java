package BitManipulation;

/**
 * @author EvanHsia
 * @ClassName BinaryNumberWithAlternatingBits.java
 * @Description No.693 Easy
 * @createTime 2019-08-06- 15:56
 */
//1010 右移一位和原来异或，结果应全为1
public class BinaryNumberWithAlternatingBits {
     public boolean hasAlternatingBits(int n){
        int a=n^(n>>1);
         return (a&(a+1))==0;
     }
}
