package Tree;

/**
 * @program: leetcodetrain
 * @description: No.501 Easy
 * @author: EvenHsia
 * @create: 2019-08-02 15:40
 **/

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree (BST) with duplicates,
 * find all the mode(s) (the most frequently occurred element) in the given BST.
 *
 * Note: If a tree has more than one mode, you can return them in any order.
 * Follow up: Could you do that without using any extra space?
 * (Assume that the implicit stack space incurred due to recursion does not count).
 */
//利用中序遍历的有序性
public class BSTFindMode {
    private int curCnt=1;
    private int maxCnt=1;
    private TreeNode prenode=null;
    public int[] findMode(TreeNode root){
        List<Integer> maxCntNums=new ArrayList<>();
        inOrder(root,maxCntNums);
        int[] ret=new int[maxCntNums.size()];
        int index=0;
        for (int num:maxCntNums){
            ret[index++]=num;
        }
        return ret;
    }
    private void inOrder(TreeNode root,List<Integer> list){
        if (root==null) return;
        inOrder(root.left,list);
        if (prenode!=null){
            curCnt=root.val==prenode.val?curCnt+1:1;
        }
        if (curCnt>maxCnt){
            maxCnt=curCnt;
            list.clear();                              //不能用new ArrayList，因为在递归中
            list.add(root.val);
        } else if (curCnt==maxCnt){
            list.add(root.val);
        }
        prenode=root;
        inOrder(root.right,list);
    }
}
