package Tree;

/**
 * @program: leetcodetrain
 * @description: No.538 Easy
 * @author: EvenHsia
 * @create: 2019-08-02 13:35
 **/
public class BSTConvertToGreater {
    //先遍历右子树
    private int sum=0;
    public TreeNode convertBST(TreeNode root){
        travel(root);
        return root;
    }
    private void travel(TreeNode root){
        if (root==null) return ;
        travel(root.right);
        sum+=root.val;
        root.val=sum;
        travel(root.left);
    }
}
