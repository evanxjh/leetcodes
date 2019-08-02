package Tree;

/**
 * @program: leetcodetrain
 * @description: No.108 Easy
 * @author: EvenHsia
 * @create: 2019-08-02 14:22
 **/
public class BSTConvertSortedArray {
    public TreeNode sortedArrayToBST(int[] nums){
        return helper(nums,0,nums.length-1);
    }
    private TreeNode helper(int[] nums,int start,int end){
        if (start>end) return null;
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,start,mid-1);
        root.right=helper(nums,mid+1,end);
        return root;
    }
}
