package BackTrack;

/**
 * @author EvanHsia
 * @ClassName NumberOfIslands.java
 * @Description No.200 Medium
 * @createTime 2019-10-12- 15:12
 */
public class NumberOfIslands {
    private int m;
    private int n;
    private boolean[][] visited;
    private final int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};

    private boolean isArea(int x,int y){
        return (x>=0 && y>=0 && x<m && y<n);
    }
    public int numIslands(char[][] grid){
        m=grid.length;
        if (m==0){
            return 0;
        }
        n=grid[0].length;
        visited=new boolean[m][n];
        int res=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]=='1' && !visited[i][j]){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][]grid,int x,int y){
        visited[x][y]=true;
        for (int[] d:dir){
            int newx=x+d[0];
            int newy=y+d[1];
            if (isArea(newx,newy)){
                if (grid[newx][newy]=='1' && !visited[newx][newy]){
                    dfs(grid,newx,newy);
                }
            }
        }
    }
}
