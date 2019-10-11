package BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EvanHsia
 * @ClassName LetterCombinationsOfAPhoneNumber.java
 * @Description No.17 Medium
 * @createTime 2019-10-10- 17:09
 */
public class LetterCombinationsOfAPhoneNumber {
    private String[] lettermap=new String[]{" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private List<String> res=new ArrayList<>();
    public List<String> letterCombinations(String digits){
        if ("".equals(digits)){
            return res;
        }
        find(digits,0,"");
        return res;
    }

    private void find(String digits,int index,String cur){
        if (index==digits.length()){
            res.add(cur);
            return;
        }
        int i=digits.charAt(index)-'0';
        for (int j=0;j<lettermap[i].length();j++){
            find(digits,index+1,cur+lettermap[i].charAt(j));        //String类型非引用类型，自动回溯
        }
    }
}
