package Tree;

/**
 * @program: leetcodetrain
 * @description: No.111 Easy
 * @author: EvenHsia
 * @create: 2019-08-01 14:40
 **/
public class MinimumDepthOfBinaryTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    public int minDepth(TreeNode root){
        if (root==null) return 0;
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        if (left==0 || right==0) return left+right+1;           //重要的一行，与最大高度区别
        return Math.min(left,right)+1;
    }
}
