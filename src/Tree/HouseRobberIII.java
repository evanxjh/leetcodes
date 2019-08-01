package Tree;

/**
 * @program: leetcodetrain
 * @description: No.337 Medium 间隔遍历
 * @author: EvenHsia
 * @create: 2019-08-01 15:32
 **/
public class HouseRobberIII {
    public int rob(TreeNode root){
        if (root==null) return 0;
        int val1=root.val;
        if (root.left!=null) val1+=rob(root.left.left)+rob(root.left.right);
        if (root.right!=null) val1+=rob(root.right.left)+rob(root.right.right);
        int val2=rob(root.left)+rob(root.right);
        return Math.max(val1,val2);
    }
}
