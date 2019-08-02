package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcodetrain
 * @description: No.530 Easy
 * @author: EvenHsia
 * @create: 2019-08-02 15:17
 **/
//中序遍历有序性
public class BSTMinimumAbsoluteDiff {
    private TreeNode prenode=null;
    private int mindiff=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root){
        inOrder(root);
        return mindiff;
    }
    private void inOrder(TreeNode root){
        if (root==null) return;
        inOrder(root.left);
        if (prenode!=null) mindiff=Math.min(mindiff,root.val-prenode.val);
        prenode=root;                         //原来是将其添加到ArrayList中，现在将它标记即可，表示下一个要添加节点的前面一个
        inOrder(root.right);
    }
}
