package DivideAndConquer;

import org.junit.Test;

import java.util.*;

/**
 * @author EvanHsia
 * @ClassName UniqueBSTII.java
 * @Description No.95 Medium
 * @createTime 2019-08-15- 15:35
 */

public class UniqueBSTII {
    //分治解法，递归，但是其中有很多重复计算
    public List<TreeNode> generateTrees(int n){
       if (n<1) {
           return new ArrayList<>();
       }

       return generateSubTrees(1,n);
    }
    private List<TreeNode> generateSubTrees(int s,int e){
        List<TreeNode> ret=new ArrayList<>();
        if (s>e){
            ret.add(null);
            return ret;
        }
        for (int i=s;i<=e;i++){
            List<TreeNode> left=generateSubTrees(s,i-1);
            List<TreeNode> right=generateSubTrees(i+1,e);
            for (TreeNode l:left){
                for (TreeNode r:right){
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    ret.add(root);
                }
            }
        }

        return ret;
    }
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }

    @Test
    public void sometest(){
        System.out.print(generateTrees(3));
    }

    //动态规划解法
    public List<TreeNode> generate(int n){
        if (n==0) return Collections.emptyList();
        List<TreeNode> [][] dp=new List[n+1][n+1];         //i行j列存储i到j的TreeNode链表
        dp[0][0]=Collections.singletonList(null);          //记录null
        for (int i=1;i<=n;i++){
            dp[i][i]=Collections.singletonList(new TreeNode(i));
        }
        return helper(1,n,dp);
    }
    private List<TreeNode> helper(int s,int e,List<TreeNode>[][] dp){
        if (s>e){
            return  dp[0][0];
        }
        List<TreeNode> res=dp[s][e];                    //之前已经计算过了，直接调用
        if (res!=null){
            return res;
        }
        res=new LinkedList<>();
        for (int i=s;i<=e;i++){
            List<TreeNode> left=helper(s,i-1,dp);
            List<TreeNode> right=helper(i+1,e,dp);
            for (TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    res.add(root);
                }
            }
        }
        dp[s][e]=res;                                       //将从s到e的结果储存起来，方便后边直接调用
        return res;
    }
}
