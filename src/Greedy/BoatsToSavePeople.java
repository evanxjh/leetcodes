package Greedy;

import java.util.Arrays;

/**
 * @author EvanHsia
 * @ClassName BoatsToSavePeople.java
 * @Description Medium
 * @createTime 2019-10-08- 18:41
 */
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people,int limit){
        int l=0,r=people.length-1;
        Arrays.sort(people);
        int res=0;
        while (l<=r){
            if (l==r){
                return res+1;
            }
            if (people[l]+people[r]<=limit){
                res++;
                l++;
                r--;
            }else {
                r--;
                res++;
            }
        }
        return res;
    }
}
