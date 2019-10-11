package BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EvanHsia
 * @ClassName PalindromePartitioning.java
 * @Description No.131 Medium
 * @createTime 2019-10-11- 14:31
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s){
        List<List<String>> res=new ArrayList<>();
        if (s.length()==0){
            return res;
        }
        List<String> p=new ArrayList<>();
        backtrack(s,0,p,res);
        return res;
    }
    private void backtrack(String s,int index,List<String> p,List<List<String>> res){
        if (s.length()==index){
            res.add(new ArrayList<>(p));                //一定要new
            return;
        }
        for (int i=index;i<s.length();i++){
            String next=s.substring(index,i+1);
            if (isPalindrome(next)){
                p.add(next);
                backtrack(s,i+1,p,res);
                p.remove(p.size()-1);               //回溯去掉当前的next
            }
        }
    }

    private boolean isPalindrome(String s){
        int start=0,end=s.length()-1;
        while (start<end){
            if (s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
