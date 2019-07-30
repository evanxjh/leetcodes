package Tree;

/**
 * @program: leetcodetrain
 * @description: No.110 Easy
 * @author: EvenHsia
 * @create: 2019-07-30 17:22
 **/

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    private boolean result=true;
    public boolean isBalanced(TreeNode root){
        maxDepth(root);
        return result;
    }
    private int maxDepth(TreeNode root){
        if (root==null) return 0;
        int l=maxDepth(root.left);
        int r=maxDepth(root.right);
        if (Math.abs(l-r)>1) result=false;
        return Math.max(l,r)+1;
    }
}
