package BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EvanHsia
 * @ClassName permutations.java
 * @Description No.46 Medium
 * @createTime 2019-10-12- 11:22
 */
public class permutations {
    private List<List<Integer>> res;
    private boolean[] visited;
    public List<List<Integer>> permute(int[] nums){
        res=new ArrayList<>();
        if (nums==null || nums.length==0){
            return res;
        }
        visited=new boolean[nums.length];
        dfs(nums,0,new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums,int index,List<Integer> p){
        if (index==nums.length){
            res.add(new ArrayList<>(p));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (!visited[i]){
                p.add(nums[i]);
                visited[i]=true;
                dfs(nums,index+1,p);
                p.remove(p.size()-1);
                visited[i]=false;
            }
        }
        return;
    }
}
