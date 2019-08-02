package Tree;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @program: leetcodetrain
 * @description: NO.145 Medium
 * @author: EvenHsia
 * @create: 2019-08-02 12:21
 **/
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> ret=new ArrayList<>();
        if (root==null) return ret;
        return recursepostorder(root,ret);
    }
    private List<Integer> recursepostorder(TreeNode root, List<Integer> ret ){
        if (root==null) return ret;
        ret=recursepostorder(root.left,ret);
        ret=recursepostorder(root.right,ret);
        ret.add(root.val);
        return ret;
    }


    public List<Integer> postorderiter(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode curr=stack.pop();
            res.add(curr.val);
            if (curr.left!=null) stack.push(curr.left);     //根，右，左，顺序的逆
            if (curr.right!=null) stack.push(curr.right);
        }
        Collections.reverse(res);
        return res;
    }
}
