package SortProblems;

import edu.princeton.cs.algs4.In;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author EvanHsia
 * @ClassName KthLargestElement.java
 * @Description No.215 Medium
 * @createTime 2019-08-06- 20:44
 */
public class KthLargestElement {
    //java自带的排序
    public int findKthLargest(Integer[] nums,int k){
        Arrays.sort(nums,(i,j)->j-i);                     //改成降序，Comparator只接受引用参数
        return nums[k-1];
    }

    @Test
    public void method1(){
        Integer[] nums= new Integer[]{5,0,22,3,1,76,8};
        System.out.print(findKthLargest(nums,3));
    }

    //最小的K个元素，大顶堆；最大的K个元素，小顶堆
    public int findKthLargest2(int[] nums,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();   //小顶堆       大顶堆，可以修改comparator函数来实现
        for (int val:nums){
            pq.add(val);
            if (pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    //快速选择
    public int findKthLargest3(int[] nums,int k){
        k=nums.length-k;                                    //第k大，即为第n-k+1小,就是从小到大排序的数组第n-k项
        int l=0,h=nums.length-1;
        while (l<h){
            int j=partition(nums,l,h);
            if (j==k){
                break;
            }else if(j<k){
                l=j+1;
            }else{
                h=j-1;
            }
        }
        return nums[k];
    }
    private int partition(int[] a,int l,int h){
        int i=l,j=h+1;                              //以a[l]进行切分
        while (true){
            while (a[++i]<a[l] && i<h);
            while (a[--j]>a[l] && j>l);
            if(i>=j){
                break;
            }
            swap(a,i,j);
        }
        swap(a,l,j);
        return j;
    }
    private void swap(int[] a,int i,int j){
        a[i]^=a[j];
        a[j]^=a[i];
        a[i]^=a[j];
    }
}
