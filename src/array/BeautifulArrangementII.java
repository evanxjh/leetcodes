package array;

/**
 * @author EvenHsia
 * @ClassName BeautifulArrangementII.java
 * @Description No.667 Medium
 * @createTime 2019-08-06- 09:08
 */

/**
 * 数组元素为 1~n 的整数，要求构建数组，使得相邻元素的差值不相同的个数为 k。
 */

//构造法：[1,2,3,...,n-k-1,n-k,n,n-k+1,n-1,...]从n-k开始后面的差值为k至1
public class BeautifulArrangementII {
    public int[] constructArray(int n,int k){
        int[] res=new int[n];
        for (int i=0;i<n-k;i++){
            res[i]=i+1;
        }
        for (int i=0;i<=k;i++){
            if (i%2==1){
                res[i+n-k-1]=n-i/2;
            } else{
                res[i+n-k-1]=n-k+i/2;
            }
        }
        return res;
    }
}
