package array;

/**
 * @author EvenHsia
 * @ClassName ToeplitzMatrix.java
 * @Description No.766 Easy
 * @createTime 2019-08-06- 10:15
 */

/**
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 */
public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix){
        int row=matrix.length;
        int col=matrix[0].length;
        int[] oldline=new int[col];
        for (int j=0;j<col;j++){
            oldline[j]=matrix[0][j];
        }
        for (int i=1;i<row;i++){
            for (int j=col-1;j>0;j--){
                if (matrix[i][j]!=oldline[j-1]) return false;
                else{
                    oldline[j]=oldline[j-1];
                }
            }
            oldline[0]=matrix[i][0];
        }
        return true;
    }
}
