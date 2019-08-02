package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @program: leetcodetrain
 * @description: No.94 Medium
 * @author: EvenHsia
 * @create: 2019-08-02 12:52
 **/
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ret=new ArrayList<>();
        if (root==null) return ret;
        return recurseinorder(root,ret);
    }
    private List<Integer> recurseinorder(TreeNode root,List<Integer> ret){
        if (root==null) return ret;
        ret=recurseinorder(root.left,ret);
        ret.add(root.val);
        ret=recurseinorder(root.right,ret);
        return ret;
    }


    public List<Integer> iterinorder(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        while (curr!=null || !stack.isEmpty()){
            while (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            TreeNode node=stack.pop();
            res.add(node.val);
            curr=node.right;
        }
        return res;
    }
}
