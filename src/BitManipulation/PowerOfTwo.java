package BitManipulation;

/**
 * @author EvenHsia
 * @ClassName PowerOfTwo.java
 * @Description No.231 Easy
 * @createTime 2019-08-06- 14:44
 */

//只有1个1，其余全为0
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n){
        if (n<0) return false;
        while (n!=0){
            if ((n&1)==1)  break;
            n>>>=1;
        }
        if (n==1) return true;
        else return false;
    }

    public boolean isPowerOfTwo2(int n){
        return n>0 && Integer.bitCount(n)==1;
    }

    //去除最低位
    public boolean isPowerOfTwo3(int n){
        return n>0 && (n&(n-1))==0;
    }
}
