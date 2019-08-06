package BitManipulation;

/**
 * @author EvanHsia
 * @ClassName CountingBits.java
 * @Description No.338 Medium
 * @createTime 2019-08-06- 20:05
 */

//动态规划  一个数1的个数比(去除最低位的那个数)1的个数多1
public class CountingBits {
    public int[] countBits(int num){
        int[] ret=new int[num+1];
        ret[0]=0;
        for (int i=1;i<=num;i++){
            ret[i]=ret[(i&(i-1))]+1;
        }
        return ret;
    }
}
