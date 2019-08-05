package strings;

/**
 * @author EvenHsia
 * @ClassName IsomorphicStrings.java
 * @Description No.205 Easy
 * @createTime 2019-08-05- 14:28
 */

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * You may assume both s and t have the same length.
 */

//记录每个字符上次出现的位置,从1开始，未出现的都作为0处理
public class IsomorphicStrings {
    public boolean isIsomorphic(String s,String t){
        int[] preorderOfs=new int[256];
        int[] preorderOft=new int[256];
        for (int i=0;i<s.length();i++){
            char sc=s.charAt(i);
            char tc=t.charAt(i);
            if (preorderOfs[sc]!=preorderOft[tc]){
                return false;
            }
            preorderOfs[sc]=i+1;
            preorderOft[tc]=i+1;
        }
        return true;
    }
}
