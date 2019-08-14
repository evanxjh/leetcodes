package BinarySearch;

/**
 * @author EvanHsia
 * @ClassName SqrtX.java
 * @Description No.69 Easy
 * @createTime 2019-08-14- 16:07
 */

/**
 *
 */
public class SqrtX {
    public int mySqrt(int x){
        if (x<=1){
            return x;
        }
        int l=1,h=x;
        while (l<=h){
            int m=l+(h-l)/2;
            int sqrt=x/m;
            if (sqrt==m){
                return m;
            } else if (m<sqrt){
                l=m+1;
            }else{
                h=m-1;
            }
        }
        return h;                         //应该返回h，因为h比l小
    }
}
