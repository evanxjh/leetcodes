package BinarySearch;

/**
 * @author EvanHsia
 * @ClassName FirstBadVersion.java
 * @Description No.278 Easy
 * @createTime 2019-08-14- 16:48
 */

/**
 * 给定一个元素 n 代表有 [1, 2, ..., n] 版本，在第 x 位置开始出现错误版本，导致后面的版本都错误。
 * 可以调用 isBadVersion(int x) 知道某个版本是否错误，要求找到第一个错误的版本。
 */
public class FirstBadVersion {
    public int findBadVersion(int n){
        int l=1; int h=n;
        while (l<h){
            int m=l+(h-l)/2;
            if (isBadVersion(m)){
                h=m;
            } else{
                l=m+1;
            }
        }
        return h;                  //return l和h都可以
    }


    //为了通过编译随便设定的
    private boolean isBadVersion(int m){
        return m==5;
    }
}
