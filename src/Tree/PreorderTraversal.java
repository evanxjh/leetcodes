package Tree;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: leetcodetrain
 * @description: No.144 Medium
 * @author: EvenHsia
 * @create: 2019-08-02 11:41
 **/
public class PreorderTraversal {
    List<Integer> ret=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root){
        if (root==null) return ret;
        dfs(root);
        return ret;
    }
    private void dfs(TreeNode root){
        ret.add(root.val);
        if (root.left!=null) dfs(root.left);
        if (root.right!=null) dfs(root.right);
    }

    public List<Integer> iterpreorder(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode curr=stack.pop();
            res.add(curr.val);
            if (curr.right!=null) stack.push(curr.right);     //一定要先push右节点，保证左节点先pop
            if (curr.left!=null) stack.push(curr.left);
        }
        return res;
    }

    //只push右节点，并持续找左节点，直到为null
    public List<Integer> iterpreorder2(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        stack.add(curr);
        while (!stack.isEmpty()){
            if (curr!=null){
                res.add(curr.val);
                if (curr.right!=null){
                    stack.push(curr.right);
                }
                curr=curr.left;
            } else {
                curr=stack.pop();                      //没有左节点了，pop最近的右节点
            }
        }
        return res;
    }
}
