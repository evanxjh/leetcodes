package BitManipulation;

/**
 * @author EvenHsia
 * @ClassName HammingDistance.java
 * @Description No.461 Easy
 * @createTime 2019-08-06- 11:10
 */

/**
 * 整数的二进制表示中不同的位的总数
 * 异或
 */
public class HammingDistance {
    public int hammingDistance(int x,int y){
        int z=x^y;
        int cnt=0;
        while (z!=0){
            if ((z&1)==1) cnt++;
            z=z>>1;                //向右移1位，代表/2
        }
        return cnt;
    }

    //法2：用z&(z-1)去除表示最低的那一位
    public int hammingDistance2(int x,int y){
        int z=x^y;
        int cnt=0;
        while (z!=0){
            z&=(z-1);
            cnt++;
        }
        return cnt;
    }
}
