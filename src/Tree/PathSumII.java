package Tree;

import linked_list.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EvanHsia
 * @ClassName PathSumII.java
 * @Description No.113 Medium
 * @createTime 2019-10-10- 12:53
 */
public class PathSumII {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root,int sum){
        if (root==null) {
            return res;
        }
        dfs(root,sum,new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode node,int sum,List<Integer> list){
        if (node==null){
            return;
        }
        list.add(node.val);
        if (node.left==null && node.right==null){
            if (node.val==sum){
                res.add(new ArrayList<>(list));
            }
        }else {
            if (node.left!=null){
                dfs(node.left,sum-node.val,list);
            }
            if (node.right!=null){
                dfs(node.right,sum-node.val,list);
            }
        }
        list.remove(list.size()-1);
        return;
    }


    @Test
    public void testlist(){
        List<List<Integer>> result=new ArrayList<>();
        List<List<Integer>> correctresult=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        result.add(list);
        correctresult.add(new ArrayList<>(list));
        list.add(4);
        result.add(list);
        correctresult.add(new ArrayList<>(list));
        System.out.println(result);//[[1, 2, 4], [1, 2, 4]]
        System.out.println(correctresult);//[[1, 2], [1, 2, 4]]
    }
}
