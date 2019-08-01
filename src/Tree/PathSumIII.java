package Tree;

/**
 * @program: leetcodetrain
 * @description: No.437 Easy
 * @author: EvenHsia
 * @create: 2019-08-01 13:56
 **/

/**
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class PathSumIII {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    //递归的嵌套
    public int pathSum(TreeNode root,int sum){
        if (root==null) return 0;
        int res=pathSum(root.left,sum)+pathSum(root.right,sum)+pathSumWithRoot(root,sum);
        return res;
    }
    //必须要从当前节点开始,val可正可负
    private int pathSumWithRoot(TreeNode root,int sum){
        if (root==null) return 0;
        int res=0;
        if (root.val==sum) res++;
        res+=pathSumWithRoot(root.left,sum-root.val)+pathSumWithRoot(root.right,sum-root.val);
        return res;
    }
}
