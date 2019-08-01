package Tree;

/**
 * @program: leetcodetrain
 * @description: No.687 Easy
 * @author: EvenHsia
 * @create: 2019-08-01 15:10
 **/

/**
 * Given a binary tree, find the length of the longest path where each node in the path
 * has the same value. This path may or may not pass through the root.
 */
public class LongestUnivaluePath {
    private int max=0;
    public int longestUnivaluePath(TreeNode root){
        if (root==null) return 0;
        search(root);
        return max;
    }
    // 返回从当前节点开始，值保持不变的最大深度
    public int search(TreeNode root){
        if (root==null) return 0;
        int left=search(root.left);
        int right=search(root.right);
        int leftwithroot=(root.left!=null && root.left.val==root.val)?left+1:0;
        int rightwithroot=(root.right!=null && root.right.val==root.val)?right+1:0;
        max=Math.max(max,leftwithroot+rightwithroot);                            //两种情况：路径的根节点为当前节点；路径的根节点为当前节点的某个子节点
        return Math.max(leftwithroot,rightwithroot);
    }
}
