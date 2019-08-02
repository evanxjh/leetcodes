package Tree;

/**
 * @program: leetcodetrain
 * @description: No.669 Easy
 * @author: EvenHsia
 * @create: 2019-08-02 13:10
 **/
public class BSTtrim {
    public TreeNode trimBST(TreeNode root,int L,int R){
        if (root==null) return null;
        if (root.val<L) return trimBST(root.right,L,R);
        if (root.val>R) return trimBST(root.left,L,R);
        root.left=trimBST(root.left,L,R);
        root.right=trimBST(root.right,L,R);
        return root;
    }
}
