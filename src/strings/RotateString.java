package strings;

/**
 * @author EvanHsia
 * @ClassName RotateString.java
 * @Description No.796
 * @createTime 2019-10-05- 17:30
 */
public class RotateString {
    public boolean rotateString(String A,String B){
        if (A.length()!=B.length()){
            return false;
        }
        A+=A;
        return A.indexOf(B)!=-1;
    }
}
