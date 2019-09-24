package two_pointers;

/**
 * @author EvanHsia
 * @ClassName ValidPalindromeII.java
 * @Description No.125 Easy
 * @createTime 2019-09-24- 11:12
 */
public class ValidPalindromeII {
    public boolean isPalindrome(String s){
        int l=0,r=s.length()-1;
        char[] chars=s.toCharArray();
        while (l<=r){
            if (!(Character.isDigit(chars[l])||Character.isLetter(chars[l]))) {
                l++;
                continue;
            }
            if (!(Character.isLetter(chars[r])||Character.isDigit(chars[r]))){
                r--;
                continue;
            }
            if (Character.isDigit(chars[l]) && Character.isDigit(chars[r])){
                if (chars[l]==chars[r]){
                    l++;
                    r--;
                }else {
                    return false;
                }
            } else if(Character.isLetter(chars[l])&&Character.isLetter(chars[r])){
                if (chars[l]==chars[r] || Math.abs(chars[l]-chars[r])==32){
                    l++;
                    r--;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }
}
