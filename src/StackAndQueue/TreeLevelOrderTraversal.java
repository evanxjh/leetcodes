package StackAndQueue;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author EvanHsia
 * @ClassName TreeLevelOrderTraversal.java
 * @Description No.102 Medium
 * @createTime 2019-10-08- 20:58
 */
public class TreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res=new ArrayList<>();
        if (root==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size= queue.size();
            List<Integer> list=new ArrayList<>();
            while (size-->0){
                TreeNode node=queue.poll();
                list.add(node.val);
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
            if (list.size()>0){
                res.add(list);
            }
        }
        return res;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
