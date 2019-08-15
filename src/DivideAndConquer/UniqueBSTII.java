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
}
