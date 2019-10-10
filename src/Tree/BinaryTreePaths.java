package Tree;

import linked_list.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EvanHsia
 * @ClassName BinaryTreePaths.java
 * @Description No.257 Easy
 * @createTime 2019-10-10- 10:53
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root){
        List<String> res=new ArrayList<>();
        if (root==null){
            return res;
        }
        if (root.left==null && root.right==null){
            res.add((root.val+""));
            return res;
        }
        List<String> left=binaryTreePaths(root.left);
        for (String s:left){
            res.add(root.val+"->"+s);
        }
        List<String> right=binaryTreePaths(root.right);
        for (String s:right){
            res.add(root.val+"->"+s);
        }
        return res;
    }
}
