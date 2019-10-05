package strings;

/**
 * @author EvanHsia
 * @ClassName NumberOfSegmentsInString.java
 * @Description No.434
 * @createTime 2019-10-05- 14:50
 */
public class NumberOfSegmentsInString {
    public int countSegments(String s){
        if (s==null || s.length()==0){
            return 0;
        }
        int res=1;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==' '){
                if (i<s.length()-1 && s.charAt(i+1)!=' '){
                    res++;
                }
            }
        }
        if (s.charAt(0)==' '){
            res--;
        }
        return res;
    }
}
