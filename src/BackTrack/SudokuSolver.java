package BackTrack;

/**
 * @author EvanHsia
 * @ClassName SudokuSolver.java
 * @Description No.37 Hard
 * @createTime 2019-10-12- 16:04
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board){
        boolean[][] row=new boolean[9][10];
        boolean[][] col=new boolean[9][10];
        boolean[][] block=new boolean[9][10];
        //initial
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (board[i][j]!='.'){
                    int num=board[i][j]-'0';
                    row[i][num]=true;
                    col[j][num]=true;
                    block[i/3*3+j/3][num]=true;
                }
            }
        }
        for (int i=0;i<81;i++){
            if (board[i/9][i%9]=='.'){
                if (!canPutNum(board,i,row,col,block)){
                    continue;
                }
            }
        }
    }

    private boolean canPutNum(char[][]board,int pos,boolean[][]row,boolean[][]col,boolean[][]block){
        if (pos==81){
            return true;
        }
        //寻找下一个填写数字的位置
        int next=pos+1;
        for (;next<81;next++){
            if (board[next/9][next%9]=='.'){
                break;
            }
        }
        int x=pos/9;
        int y=pos%9;
        for (int i=1;i<=9;i++){
            //判断是否能够填写i
            if (!row[x][i] && !col[y][i] && !block[x/3*3+y/3][i]){
                row[x][i]=true;
                col[y][i]=true;
                block[x/3*3+y/3][i]=true;
                board[x][y]=(char)(i+'0');
                if (canPutNum(board,next,row,col,block)){
                    return true;
                }
                //回溯
                block[x/3*3+y/3][i]=false;
                col[y][i]=false;
                row[x][i]=false;
                board[x][y]='.';
            }
        }
        //1-9都不行返回false;
        return false;
    }
}
