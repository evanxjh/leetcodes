package BitManipulation;

import org.junit.Test;

/**
 * @author EvanHsia
 * @ClassName NumberComplement.java
 * @Description No.476 Easy
 * @createTime 2019-08-06- 16:04
 */
//
public class NumberComplement {
    public int findComplement(int num){
        int cnt=0;
        int n=num;
        while (n!=0){
            n>>=1;
            cnt++;
        }
        return (int)(Math.pow(2,cnt) - 1-num);          //直接对2^31取整，会把
    }

    @Test
    public void sometest(){
        System.out.print(findComplement(2147483647));
    }

    //其他方法一：求掩码，然后异或
    public int findComplement2(int num){     //0000 0101
        if (num==0) return 1;
        int mask=1<<30;
        while ((num&mask)==0) mask>>=1;      //mask最高位与num的最高位一致     0000 0100
        mask=(mask<<1)-1;                    //得到num的掩码                   0000 0111
        return num^mask;
    }

    //java的highestOneBit方法
    public int findComplement3(int num){
        if (num==0) return 1;
        int mask=Integer.highestOneBit(num);
        mask=(mask<<1)-1;
        return num^mask;
    }
}
