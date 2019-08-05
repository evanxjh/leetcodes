package array;

/**
 * @author EvenHsia
 * @ClassName MaxChunksToMakeSorted.java
 * @Description No.769 Medium
 * @createTime 2019-08-05- 23:07
 */
public class MaxChunksToMakeSorted {
    //arr[index]>index那么至少0-arr[index]要捆绑在一起
    public int maxChunksToSorted(int[] arr){
        if (arr==null) return 0;
        int right=arr[0];
        int res=0;
        for (int i=0;i<arr.length;i++ ){
            right=Math.max(right,arr[i]);
            if (i==right) res++;              //说明前i个可以排序后为0到i
        }
        return res;
    }
}
