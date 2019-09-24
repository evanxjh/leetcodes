package two_pointers;

/**
 * @author EvanHsia
 * @ClassName maxArea.java
 * @Description No.11 Medium
 * @createTime 2019-09-24- 11:58
 */
public class maxArea {
    public int maxArea(int[] height){
        int l=0;
        int r=height.length-1;
        int max=0;
        while (l<r){
            max=Math.max(max,Math.min(height[l],height[r])*(r-l));
            if (height[l]>height[r]){
                r--;
            } else {
                l++;
            }
        }
        return max;
    }
}
