package BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EvanHsia
 * @ClassName Combinations.java
 * @Description No.77 Medium
 * @createTime 2019-10-12- 14:55
 */
public class Combinations {
    private List<List<Integer>> res;
    public List<List<Integer>> combine(int n,int k){
        res=new ArrayList<>();
        if (n<=0 || n<k){
            return res;
        }
        find(n,k,1,new ArrayList<>());
        return res;
    }

    private void find(int n,int k,int start,List<Integer> p){
        if (k==0){
            res.add(new ArrayList<>(p));
            return;
        }
        for (int i=start;i<=n;i++){
            p.add(i);
            find(n,k-1,i+1,p);
            p.remove(p.size()-1);
        }
    }
}
