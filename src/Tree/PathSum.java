package Tree;

/**
 * @program: leetcodetrain
 * @description: No.112 Easy
 * @author: EvenHsia
 * @create: 2019-08-01 13:48
 **/

/**
 * Given the below binary tree and sum = 22,
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    public boolean hasPathSum(TreeNode root,int sum){
        if (root==null) return false;
        if (root.left==null && root.right==null && root.val==sum) return true;
        return (hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val));
    }
}
