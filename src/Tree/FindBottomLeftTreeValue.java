package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcodetrain
 * @description: No.513 Easy
 * @author: EvenHsia
 * @create: 2019-07-30 23:19
 **/
public class FindBottomLeftTreeValue {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    public int findBottomLeftValue(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            root=q.poll();
            if (root.right!=null) q.add(root.right);                 //先添加right节点
            if (root.left!=null) q.add(root.left);
        }
        return root.val;
    }
}
