package Mathematics;

/**
 * @author EvanHsia
 * @ClassName MaxProductOfThreeNumbers.java
 * @Description No.628 Easy
 * @createTime 2019-08-21- 15:42
 */

/**
 * 找出数组中最大的三个数乘积
 */
public class MaxProductOfThreeNumbers {
    public int maximumProduct(int[] nums){
        int max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE,max3=Integer.MIN_VALUE,min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
        for (int n:nums){
            //3个正数min1>min2>min3
            if (n>max1){
                max3=max2;
                max2=max1;
                max1=n;
            } else if (n>max2){
                max3=max2;
                max2=n;
            } else if (n>max3){
                max3=n;
            }
            //2个负数，1个正数 min1<min2
            if (n<min1){
                min2=min1;
                min1=n;
            } else if(n<min2){
                min2=n;
            }
        }
        return Math.max(max1*max2*max3,min1*min2*max1);
    }
}
