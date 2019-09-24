package BinarySearch;

/**
 * @author EvanHsia
 * @ClassName minEatingSpeed.java
 * @Description No.875 Medium
 * @createTime 2019-09-24- 10:52
 */
public class minEatingSpeed {
    public int minEatingSpeed(int[] piles,int H){
        if (piles.length>H){
            return -1;
        }
        int maxSpeed=piles[0];
        for (int i=0;i<piles.length;i++){
            maxSpeed=Math.max(maxSpeed,piles[i]);
        }
        int l=1,h=maxSpeed;
        while (l<=h){
            int mid=l+(h-l)/2;
            int hours=hours(piles,mid);
            if (hours==H){
                return mid;
            }else if (hours<H){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;               //保证吃完，应取l
    }
    private int hours(int[] piles,int speed){
        int res=0;
        for (int i=0;i<piles.length;i++){
            res+=Math.ceil((piles[i]*1.0/speed));  //向上取整
        }
        return res;
    }
}
