package Greedy;

/**
 * @author EvanHsia
 * @ClassName CanPlaceFlowers.java
 * @Description No.605 Easy
 * @createTime 2019-08-09- 16:27
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed,int n){
        int len=flowerbed.length;
        int cnt=0;
        for (int i=0;i<len && cnt<n;i++){
            if (flowerbed[i]==1){
                continue;
            }
            int pre=i==0?0:flowerbed[i-1];          //第一个前面视为空
            int next=i==len-1?0:flowerbed[i+1];     //最后一个后面视为空
            if (pre==0 && next==0){
                cnt++;
                flowerbed[i]=1;
            }
        }
        return cnt>=n;
    }
}
