package Search;

import org.junit.Test;

/**
 * @author EvanHsia
 * @ClassName FriendCircles.java
 * @Description No.547 Medium
 * @createTime 2019-08-12- 20:29
 */
//好友关系可以看成是无向图M[0][1]和M[1][0]应该相等
public class FriendCircles {
    private int n;
    public int findCircleNum(int[][] M){
        if (M==null || M.length==0) return 0;
        n=M.length;
        int circleNum=0;
        boolean[] hasvisit=new boolean[n];
        for (int i=0;i<n;i++){
            if (!hasvisit[i]){
                dfs(M,i,hasvisit);
                circleNum++;
            }
        }
        return circleNum;
    }
    private void dfs(int[][] M,int cur,boolean[] hasvisit){
        hasvisit[cur]=true;
        for (int i=0;i<n;i++){
            if (M[cur][i]==1 && !hasvisit[i]) {
                dfs(M, i,hasvisit);
            }
        }
    }

    @Test
    public void sometest(){
        int[][] M={{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.print(findCircleNum(M));
    }
}
