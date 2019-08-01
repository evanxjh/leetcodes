package Tree;

/**
 * @program: leetcodetrain
 * @description: No.337 Medium 间隔遍历
 * @author: EvenHsia
 * @create: 2019-08-01 15:32
 **/
public class HouseRobberIII {
    public int rob(TreeNode root){
        if (root==null) return 0;
        int val1=root.val;
        if (root.left!=null) val1+=rob(root.left.left)+rob(root.left.right);
        if (root.right!=null) val1+=rob(root.right.left)+rob(root.right.right);
        int val2=rob(root.left)+rob(root.right);
        return Math.max(val1,val2);
    }

    //另一个方法
    public int robnew(TreeNode root){
        int[] ret=helper(root);
        return Math.max(ret[0],ret[1]);
    }
 /*   返回一个含有两个元素的数组
  *   ret[0] 强盗会打开当前节点
  *   ret[1] 强盗不会打开当前节点
  * */
    private int[] helper(TreeNode root){
        if (root==null) return new int[]{0,0};
        int[] l=helper(root.left);
        int[] r=helper(root.right);
        return new int[]{root.val+l[1]+r[1],Math.max(l[0],l[1])+Math.max(r[0],r[1])};
    }
}
