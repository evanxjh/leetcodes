package array;

/**
 * @author EvenHsia
 * @ClassName Search2DMatrixII.java
 * @Description No.240 Medium
 * @createTime 2019-08-05- 16:30
 */
public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix,int target){
        if (matrix==null ||matrix.length==0 ||matrix[0].length==0) return false;
        int r=matrix.length;
        int c=matrix[0].length;
        int row=0;
        int col=c-1;
        while (row<r && col>=0){                          //从右上角扫到左下角
            if (target==matrix[row][col]) return true;
            else if (target<matrix[row][col]) col--;           //awesome!
            else row++;
        }
        return false;
    }

}
