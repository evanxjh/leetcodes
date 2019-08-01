package Tree;

/**
 * @program: leetcodetrain
 * @description: No.101 Easy
 * @author: EvenHsia
 * @create: 2019-08-01 14:26
 **/
public class SymmetricTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    public boolean isSymmetric(TreeNode root){
        if (root==null) return true;
        return isSymmetric(root.left,root.right);
    }
    private boolean isSymmetric(TreeNode l,TreeNode r){
        if (l==null && r==null) return true;
        if (l==null || r==null) return false;
        if (l.val!=r.val) return false;
        return isSymmetric(l.left,r.right) && isSymmetric(l.right,r.left);
    }
}
