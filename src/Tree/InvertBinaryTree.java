package Tree;

/**
 * @program: leetcodetrain
 * @description: No.226 Easy
 * @author: EvenHsia
 * @create: 2019-07-30 17:44
 **/

/**
 * Invert a binary tree.  水平翻转一棵树
 */
public class InvertBinaryTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    public TreeNode invertTree(TreeNode root){
        if (root ==null) return  null;
        root.left=invertTree(root.left);
        root.right=invertTree(root.right);
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        return root;
    }
}
