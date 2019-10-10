package Tree;

/**
 * @author EvanHsia
 * @ClassName BSTconstructPreorderAndInorder.java
 * @Description No.105 Medium
 * @createTime 2019-10-10- 16:10
 */
public class BSTconstructPreorderAndInorder {
    public TreeNode buildTree(int[] preorder,int[] inorder){
        return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    private TreeNode buildTree(int[] preorder,int[] inorder,int preStart,int preEnd,int inStart,int inEnd){
        if (preStart>preEnd || inStart>inEnd){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preStart]);
        int mid=0;
        for (int i=inStart;i<=inEnd;i++){
            if (inorder[i]==preorder[preStart]){
                mid=i;
                break;
            }
        }
        root.left=buildTree(preorder,inorder,preStart+1,preStart+(mid-inStart),inStart,mid-1);
        root.right=buildTree(preorder,inorder,preStart+(mid-inStart)+1,preEnd,mid+1,inEnd);
        return root;
    }
}
