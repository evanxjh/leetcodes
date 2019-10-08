package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EvanHsia
 * @ClassName RemoveComments.java
 * @Description No.722 Medium
 * @createTime 2019-10-08- 14:20
 */
public class RemoveComments {
    public List<String> removeComments(String[] source){
        List<String> res=new ArrayList<>();

        //判断是不是注释
        boolean isblock=false;
        StringBuilder sb=new StringBuilder();

        for (String s:source){
            int i=0;
            while (i<s.length()){
                if (!isblock){
                    //不是块注释，最后一个字符不能连取两个字符，单独讨论
                    if (i==s.length()-1){
                        sb.append(s.charAt(i++));
                    }else {
                        //i<=s.length()-2
                        String m=s.substring(i,i+2);        //取两个字符
                        if ("/*".equals(m)){
                            isblock=true;
                            i+=2;
                        }else if ("//".equals(m)){
                            break;      //忽略s中后续的字符
                        }else {
                            sb.append(s.charAt(i++));
                        }
                    }
                } else{
                    //快注释,最后一个字符不能连取两个字符，单独讨论
                    if (i==s.length()-1){
                        i++;
                    }else{
                        String m=s.substring(i,i+2);
                        if ("*/".equals(m)){
                            isblock=false;
                            i+=2;
                        }else {
                            i++;
                        }
                    }
                }
            }
            if (sb.length()>0  && !isblock){
                res.add(sb.toString());
                sb=new StringBuilder();
            }
        }
        return res;
    }
}
