package Tree;

import java.util.Comparator;

/**
 * @program: leetcodetrain
 * @description: No.104 Easy
 * @author: EvenHsia
 * @create: 2019-07-29 17:36
 **/

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 */
public class MaximumDepthOfBinaryTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    public int maxDepth(TreeNode root){
        if (root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
