package strings;

/**
 * @author EvenHsia
 * @ClassName PalindromeNumber.java
 * @Description No.9 Easy
 * @createTime 2019-08-05- 15:10
 */

//不能转字符串
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;
        int right = 0;
        while (x > right) {
            right=right*10+x%10;
            x=x/10;
        }
        return (x==right || x==right/10);          //两种情况x有偶数个数字和x有奇数个数字。
    }
}
