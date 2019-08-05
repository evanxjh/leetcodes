package strings;

/**
 * @author EvenHsia
 * @ClassName ValidAnagram.java
 * @Description No.242 Easy
 * @createTime 2019-08-05- 14:08
 */

//可用hashmap,也可以用int[26]来统计出现次
//本题只考虑小写字母
public class ValidAnagram {
    public boolean isAnagram(String s,String t){
        int[] counts=new int[26];
        for (char c:s.toCharArray()){
            counts[c-'a']++;
        }
        for (char c:t.toCharArray()){
            counts[c-'a']--;
        }
        for (int i:counts){
            if (i!=0) return false;
        }
        return true;
    }
}
