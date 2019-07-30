package Tree;

/**
 * @program: leetcodetrain
 * @description: No.637 Easy
 * @author: EvenHsia
 * @create: 2019-07-30 22:41
 **/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * 使用BFS进行层次遍历，不需要使用两个队列来分别存储当前层的节点和下一层的节点，因为在开始遍历一层的节点时，
 * 当前队列中的节点数就是当前层的节点数，只要控制遍历这么多节点数，就能保证这次遍历的都是当前层的节点。
 */
public class AverageOfLevelsInBinaryTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    public List<Double> averageOfLevels(TreeNode root){
        List<Double> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int cursize=queue.size();
            double sum=0;
            for (int i=0;i<cursize;i++){                  //只循环cursize次，当前层有这么多个节点
                TreeNode node=queue.poll();
                sum+=node.val;
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
            result.add(sum / cursize);
        }
        return result;
    }
}
