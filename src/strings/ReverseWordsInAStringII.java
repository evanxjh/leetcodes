package strings;

/**
 * @author EvanHsia
 * @ClassName ReverseWordsInAStringII.java
 * @Description No.557 Easy
 * @createTime 2019-09-25- 21:26
 */
public class ReverseWordsInAStringII {
    public String reverseWords(String s){
        if (s==null)return null;
        String[] words=s.split(" ");
        StringBuffer res=new StringBuffer();
        for (String ss:words){
            StringBuffer sb=new StringBuffer(ss);
            ss=sb.reverse().toString();
            res.append(ss+" ");
        }
        return res.toString().trim();
    }
}
