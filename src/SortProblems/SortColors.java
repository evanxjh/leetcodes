package SortProblems;

/**
 * @author EvanHsia
 * @ClassName SortColors.java
 * @Description No.75 Medium
 * @createTime 2019-08-07- 14:33
 */
public class SortColors {
    //快速排序三向切分
    public void sortColors(int[] nums){
        int zero=-1,one=0,two=nums.length;
        while (one<two){
            if (nums[one]==0){
                swap(nums,++zero,one++);       //交换过来的是肯定<=1，所以one可以++
            } else if(nums[one]==2){
                swap(nums,--two,one);          //交换过来的值不知道数值，所以one不变
            } else {
                one++;
            }
        }

    }
    private void swap(int[] a,int i,int j){
        if (i==j) return;                      //同一项不需要交换
        a[i]^=a[j];
        a[j]^=a[i];
        a[i]^=a[j];
    }
}
