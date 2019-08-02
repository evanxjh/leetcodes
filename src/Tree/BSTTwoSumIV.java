package Tree;

/**
 * @program: leetcodetrain
 * @description: No.653 Easy
 * @author: EvenHsia
 * @create: 2019-08-02 14:43
 **/

import java.util.*;

/**
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 */
//思路：遍历，twosum的解法
//层次遍历，set解法，有点慢
//先中序遍历得到有序数组，而后用双指针法,较快
public class BSTTwoSumIV {
    public boolean findTarget(TreeNode root,int k){
        Set<Integer> set=new HashSet<>();
        if (root==null) return false;
        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);
        set.add(root.val);
        while(!stack.empty()){
            int cursize=stack.size();
            for (int i=0;i<cursize;i++){
                TreeNode node=stack.pop();
                if (node.left!=null){
                    if (set.contains(k-node.left.val)) return true;
                    set.add(node.left.val);
                    stack.push(node.left);
                }
                if (node.right!=null){
                    if (set.contains(k-node.right.val)) return true;
                    set.add(node.right.val);
                    stack.push(node.right);
                }
            }
        }
        return false;
    }

    public boolean findTarget2(TreeNode root,int k){
        List<Integer> list=new ArrayList<>();
        inOrder(root,list);
        int i=0;
        int j=list.size()-1;
        while(i<j){
            if (list.get(i)+list.get(j)==k) return true;
            else if (list.get(i)+list.get(j)<k) i++;
            else j--;
        }
        return false;
    }
    private void inOrder(TreeNode root,List<Integer> list){
        if (root==null) return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}
