package Tree;

/**
 * @author EvanHsia
 * @ClassName DeleteNodeInBST.java
 * @Description No.450 Medium
 * @createTime 2019-10-10- 15:26
 */
public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key){
        if (root==null){
            return null;
        }
        if (root.val>key){
            root.left=deleteNode(root.left,key);
            return root;
        }
        if (root.val<key){
            root.right=deleteNode(root.right,key);
            return root;
        }
        //root.val==key
        if (root.right==null){
            return root.left;
        }else {
            TreeNode right=root.right;
            while (right.left!=null){
                right=right.left;
            }
            root.val=right.val;
            right.val=key;
            root.right=deleteNode(root.right,key);
            return root;
        }
    }
}
