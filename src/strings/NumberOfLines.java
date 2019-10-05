package strings;

/**
 * @author EvanHsia
 * @ClassName NumberOfLines.java
 * @Description No.806 Easy
 * @createTime 2019-10-05- 15:38
 */
public class NumberOfLines {
    public int[] numberOfLines(int[] widths,String S){
        int[] res=new int[2];
        res[0]=1;
        res[1]=0;
        for (int i=0;i<S.length();i++){
            int wide=widths[S.charAt(i)-'a'];
            if (res[1]+wide>100){
                res[0]++;
                res[1]=wide;
            }else{
                res[1]+=wide;
            }
        }
        return res;
    }
}
