package array;

/**
 * @author EvenHsia
 * @ClassName ReshapeMatrix.java
 * @Description No.566 Easy
 * @createTime 2019-08-05- 16:12
 */

public class ReshapeMatrix {
    public int[][] matrixReshape (int[][] nums,int r,int c){
        int numsr=nums.length;
        int numsc=nums[0].length;
        if (numsr*numsc!=r*c) {
            return nums;
        }
        int cnt=0;
        int[][] res =new int[r][c];
        for (int i=0;i<numsr;i++){
            for (int j=0;j<numsc;j++){
                res[cnt/c][cnt % c]=nums[i][j];
                cnt++;
            }
        }
        return res;
    }
}
