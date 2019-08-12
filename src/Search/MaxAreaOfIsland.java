package Search;

/**
 * @author EvanHsia
 * @ClassName MaxAreaOfIsland.java
 * @Description No.695 Medium
 * @createTime 2019-08-12- 20:17
 */
//最大联通面积，DFS
public class MaxAreaOfIsland {
    private final int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    private int m,n;
    public int maxAreaOfIsland(int[][] grid){
        if (grid==null || grid.length==0) return 0;
        m=grid.length;
        n=grid[0].length;
        int maxArea=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                maxArea=Math.max(maxArea,dfs(grid,i,j));
            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid,int r,int c){
        if (r<0|| c<0|| r>=m||c>=n || grid[r][c]==0){
            return 0;
        }
        grid[r][c]=0;                                                   //标记
        int area=1;
        for (int[] d:dir){
            int nr=r+d[0];
            int nc=c+d[1];
            area+=dfs(grid,nr,nc);                                     //递归
        }
        return area;
    }
}
