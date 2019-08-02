package Tree;

/**
 * @program: leetcodetrain
 * @description: No.230 Medium
 * @author: EvenHsia
 * @create: 2019-08-02 13:23
 **/
public class BSTKthSmallest {
    public int kthSmallest(TreeNode root,int k){
        int lftcnt=count(root.left);
        if (lftcnt==k-1) return root.val;
        if (lftcnt>k-1) return kthSmallest(root.left,k);
        return kthSmallest(root.right,k-lftcnt-1);            //k可以等于0，所以要-1
    }
    private int count(TreeNode node){
        if (node==null) return 0;
        return count(node.left)+count(node.right)+1;
    }
}
