package Tree;

/**
 * @program: leetcodetrain
 * @description: No.572 Easy
 * @author: EvenHsia
 * @create: 2019-08-01 14:13
 **/

/**
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 */
public class SubTreeOfAnotherTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    public boolean isSubtree(TreeNode s,TreeNode t){
        if (s==null) return false;
        return isSubtreeWithRoot(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    private boolean isSubtreeWithRoot(TreeNode s,TreeNode t){
        if (s==null && t==null) return true;
        if (s==null || t==null) return false;
        if (s.val!=t.val) return false;
        return isSubtreeWithRoot(s.left,t.left) && isSubtreeWithRoot(s.right,t.right);
    }
}
