package Greedy;

/**
 * @author EvanHsia
 * @ClassName ScoreAfterFlippingMatrix.java
 * @Description No.861 Medium
 * @createTime 2019-10-08- 17:02
 */
public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] A){
        int R=A.length;
        int C=A[0].length;
        //每行最高位必为1
        for (int i=0;i<R;i++){
            if (A[i][0]==0){
                for (int j=0;j<C;j++){
                    A[i][j]=1-A[i][j];
                }
            }
        }
        for (int j=1;j<C;j++){
            int zero=0;
            int one=0;
            for (int i=0;i<R;i++){
                if (A[i][j]==0){
                    zero++;
                }else {
                    one++;
                }
            }
            if (zero>one){
                for (int i=0;i<R;i++){
                    A[i][j]=1-A[i][j];
                }
            }
        }
        int res=0;
        for (int i=0;i<R;i++){
            for (int j=0;j<C;j++){
                res+=A[i][j]*Math.pow(2,(int) C-j-1);
            }
        }
        return res;
    }
}
