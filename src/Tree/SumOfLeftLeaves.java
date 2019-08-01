package Tree;

/**
 * @program: leetcodetrain
 * @description: No.404 Easy
 * @author: EvenHsia
 * @create: 2019-08-01 14:52
 **/

/**
 * Find the sum of all left leaves in a given binary tree.
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root){
        if (root==null) return 0;
        if (!isLeaf(root.left)) return root.left.val+sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
    }
    private boolean isLeaf(TreeNode node){
        if (node==null) return false;
        return  (node.left==null && node.right==null);
    }
}
