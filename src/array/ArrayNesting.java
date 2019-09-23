package array;

/**
 * @author EvenHsia
 * @ClassName ArrayNesting.java
 * @Description No.565 Medium
 * @createTime 2019-08-06- 10:39
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums){
        int cnt=1;
        int max=0;
        for (int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                swap(nums,i,nums[i]);
                cnt++;
            }
            max=Math.max(cnt,max);
            cnt=1;
        }
        return max;
    }
    //仅标记，不做交换操作
    public int solution2(int[] nums){
        int max=0;
        for (int i=0;i<nums.length;i++){
            int cnt=0;
            for (int j=i;nums[j]!=-1;){
                cnt++;
                int t=nums[j];
                nums[j]=-1;         //标记它
                j=t;
            }
            max=Math.max(max,cnt);
        }
        return max;
    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
