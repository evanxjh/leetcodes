package BitManipulation;

/**
 * @author EvanHsia
 * @ClassName PowerOfFour.java
 * @Description No.342 Easy
 * @createTime 2019-08-06- 14:55
 */

//只有一个1，且这个1必须出现在奇数位上
public class PowerOfFour {
    public boolean isPowerOfFour(int num){
        return num>0 && (num&(num-1))==0 &&(num &0b01010101010101010101010101010101)!=0;
    }
}
