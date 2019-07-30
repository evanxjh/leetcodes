package Tree;

/**
 * @program: leetcodetrain
 * @description: No.543 Easy
 * @author: EvenHsia
 * @create: 2019-07-30 17:30
 **/

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 */
public class DiameterOfBinaryTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    private int max=0;
    public int diameterOfBinaryTree(TreeNode root){
        depth(root);
        return max;
    }
    private int depth(TreeNode root){
        if (root==null) return 0;
        int l=depth(root.left);
        int r=depth(root.right);
        max=Math.max(max,l+r);              //要么是该节点的深度，要么是该节点某个子节点的左右子节点的深度之和；
        return Math.max(l,r)+1;
    }
}
