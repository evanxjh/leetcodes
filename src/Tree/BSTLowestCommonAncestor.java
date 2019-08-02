package Tree;

/**
 * @program: leetcodetrain
 * @description: No.235 Easy
 * @author: EvenHsia
 * @create: 2019-08-02 13:47
 **/

/**
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 */
public class BSTLowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if (root==null || root==p || root==q) return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        return left==null?right:right==null?left:root;
    }
}
