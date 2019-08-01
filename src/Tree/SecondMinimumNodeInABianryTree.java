package Tree;

/**
 * @program: leetcodetrain
 * @description: No.671 Easy
 * @author: EvenHsia
 * @create: 2019-08-01 16:25
 **/


/**
 * 满足root.val = min(root.left.val, root.right.val)
 * If no such second minimum value exists, output -1 instead.
 */
public class SecondMinimumNodeInABianryTree {
    //肯定在某个叶子节点中
    public int findSecondMinimumValue(TreeNode root){
        if (root==null) return -1;
        if (root.left==null || root.right==null) return -1;
        int leftval=root.left.val;
        int rightval=root.right.val;
        if (leftval==root.val) leftval=findSecondMinimumValue(root.left);
        if (rightval==root.val) rightval=findSecondMinimumValue(root.right);
        if (leftval!=-1 && rightval!=-1) return Math.min(leftval,rightval);
        if (leftval ==-1) return rightval;
        return leftval;
    }
}
