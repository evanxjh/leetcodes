package array;

/**
 * @author EvenHsia
 * @ClassName SetMismatch.java
 * @Description No.645 Easy
 * @createTime 2019-08-05- 20:27
 */

/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error,
 * one of the numbers in the set got duplicated to another number in the set, which results in
 * repetition of one number and loss of another number.
 * Your task is to firstly find the number occurs twice and then find the number that is missing.
 * Return them in the form of an array.
 */
// 用排序为O(nlogn),将数组元素交换至其值对应的位置，可以为O(n)
public class SetMismatch {
    public int[] findErrorNums(int[] nums){
        for (int i=0;i<nums.length;i++){
            while (nums[i]!=i+1 && nums[nums[i]-1]!=nums[i]){      //完成一次while就会有一个位置上的值和索引对应，共做n次，所以只有1个位置上不对
                swap(nums,i,nums[i]-1);
            }
        }
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=i+1) return (new int[]{nums[i],i+1});
        }
        return null;
    }
    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
