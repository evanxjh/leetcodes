package BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EvanHsia
 * @ClassName RestoreIpAddress.java
 * @Description NO.93 Medium
 * @createTime 2019-10-11- 10:32
 */
public class RestoreIpAddress {
    public List<String> restoreIpAddresses(String s){
        List<String> res=new ArrayList<>();
        if (s.length()<4 || s.length()>12){
            return res;
        }
        backtrack(0,"",res,s);
        return res;
    }
    private void backtrack(int count,String tmp,List<String> res,String s){
        if (count==4 || s.length()==0){
            if (count==4 && s.length()==0){
                res.add(tmp);
                return;
            }
            return;
        }
        for (int i=1;i<Math.min(s.length()+1,4);i++){
            if (i!=1 && s.charAt(0)=='0'){
                break;
            }
            String part=s.substring(0,i);
            if (Integer.valueOf(part)<=255){
                if (tmp.length()!=0){
                    part="."+part;
                }
                backtrack(count+1,tmp+part,res,s.substring(i));
            }
        }
    }
}
