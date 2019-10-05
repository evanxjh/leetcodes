package strings;

import org.junit.Test;

/**
 * @author EvanHsia
 * @ClassName BuddyStrings.java
 * @Description No.859 Easy
 * @createTime 2019-10-05- 16:47
 */
public class BuddyStrings {
    public boolean buddyStrings(String A,String B){
        if (A.length()!=B.length()){
            return false;
        }
        int firstdiff=-1;
        boolean thirddiff=false;
        int[] freq=new int[26];
        boolean hasduplicate=false;
        for (int i=0;i<A.length();i++){
            if (++freq[A.charAt(i)-'a']>1){
                hasduplicate=true;
            }
            if (A.charAt(i)==B.charAt(i)){
                continue;
            }
            if (thirddiff){
                return false;
            }
            if (firstdiff!=-1){
                if (A.charAt(firstdiff)!=B.charAt(i) || A.charAt(i)!=B.charAt(firstdiff)){
                    return false;
                }
                thirddiff=true;
            }
            if (firstdiff==-1) {
                firstdiff = i;
            }
        }
        return firstdiff==-1?hasduplicate:true;
    }

    @Test
    public void test(){
        String A="aa";
        String B="aa";
        buddyStrings(A,B);
    }
}
