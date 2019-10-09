package Tree;

/**
 * @author EvanHsia
 * @ClassName CountCompleteTreeNode.java
 * @Description No.222 Medium
 * @createTime 2019-10-09- 17:00
 */
public class CountCompleteTreeNode {
    public int countNodes(TreeNode root){
        if (root==null){
            return 0;
        }
        if (root.left==null && root.right==null){
            return 1;
        }
        int l=getLeftHeight(root);
        int r=getRightHeight(root);
        if(l==r){
            return (1<<r)-1;
        }else {
            return countNodes(root.left)+countNodes(root.right)+1;
        }
    }
    private int getLeftHeight(TreeNode root){
        int height=0;
        while (root!=null){
            height++;
            root=root.left;
        }
        return height;
    }

    private int getRightHeight(TreeNode root){
        int height=0;
        while (root!=null){
            height++;
            root=root.right;
        }
        return height;
    }
}
