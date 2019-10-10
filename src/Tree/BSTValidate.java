package Tree;

import org.junit.Test;

/**
 * @author EvanHsia
 * @ClassName BSTValidate.java
 * @Description No.98 Medium
 * @createTime 2019-10-10- 14:52
 */
public class BSTValidate {
    boolean isvalid=true;
    TreeNode prenode=null;
    public boolean isValidBST(TreeNode root){
        inorder(root);
        return isvalid;
    }
    private void inorder(TreeNode root){
        if (root==null || !isvalid){
            return;
        }
        inorder(root.left);
        if (!isvalid) return;
        isvalid=prenode==null || root.val>prenode.val;
        prenode=root;
        inorder(root.right);
    }

    @Test
    public void test(){
        TreeNode t1=new TreeNode(5);
        TreeNode t2=new TreeNode(1);
        TreeNode t3=new TreeNode(4);
        TreeNode t4=new TreeNode(3);
        TreeNode t5=new TreeNode(6);
        t1.left=t2;
        t1.right=t3;
        t3.left=t4;
        t3.right=t5;
        System.out.println(isValidBST(t1));


    }
}
