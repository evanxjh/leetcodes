package Greedy;

/**
 * @program: leetcodetrain
 * @description: No.665 Easy
 * @author: EvenHsia
 * @create: 2019-08-10 22:24
 **/
public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums){
        boolean firstdec=false;
        for (int i=1;i<nums.length;i++){
            if (nums[i]<nums[i-1]) {
                if (!firstdec){
                    firstdec=true;
                    if(i>1 && nums[i]<nums[i-2]){
                        nums[i]=nums[i-1];
                    } else {
                        nums[i-1]=nums[i];
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
