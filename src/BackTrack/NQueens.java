package BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EvanHsia
 * @ClassName NQueens.java
 * @Description No.51 Hard
 * @createTime 2019-10-12- 15:29
 */
public class NQueens {
    private List<List<String>> res;
    private boolean[] col;
    private boolean[] dial1;
    private boolean[] dial2;

    public List<List<String>> solveNQueens(int n){
        res=new ArrayList<>();
        if (n<=0){
            return res;
        }
        col=new boolean[n];
        dial1=new boolean[2*n-1];
        dial2=new boolean[2*n-1];
        putQueen(n,0,new ArrayList<>());
        return res;
    }

    private void putQueen(int n,int index,List<Integer> row){
        if (index==n){
            res.add(generateBoard(n,row));
            return;
        }
        for (int j=0;j<n;j++){
            if (!col[j] && !dial1[index+j] && !dial2[index-j+n-1]){
                row.add(j);
                col[j]=true;
                dial1[index+j]=true;
                dial2[index-j+n-1]=true;
                putQueen(n,index+1,row);
                col[j]=false;
                dial1[index+j]=false;
                dial2[index-j+n-1]=false;
                row.remove(row.size()-1);
            }
        }
        return;
    }

    private List<String> generateBoard(int n,List<Integer> row){
        List<String> res=new ArrayList<>();
        for (int i=0;i<n;i++){
            int index=row.get(i);
            String cur="";
            for (int j=0;j<n;j++){
                if (j!=index){
                    cur+=".";
                }else {
                    cur+="Q";
                }
            }
            res.add(cur);
        }
        return res;
    }
}
