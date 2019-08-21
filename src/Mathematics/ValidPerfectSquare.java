package Mathematics;

/**
 * @author EvanHsia
 * @ClassName ValidPerfectSquare.java
 * @Description No.367 Easy
 * @createTime 2019-08-21- 10:31
 */

/**
 * 判断一个数是否为平方数
 * 考察构造平方数序列的方法
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num){
        int interval=1;
        while (num>0){
            num-=interval;
            interval+=2;
        }
        return num==0;
    }

    //二分查找
    public boolean isPerfectsquare(int num){
        if (num<2) return true;   //0,1
        int l=1,h=num/2;
        while (l<=h){
            int mid=l+(h-l)/2;
            if ((long) mid *mid<num){
                l=mid+1;
            } else if ((long) mid*mid>num){
                h=mid-1;
            } else {
                return true;
            }
        }
        return false;
    }
}
