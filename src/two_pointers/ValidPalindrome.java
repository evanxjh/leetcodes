package two_pointers;

/**
 * @program: leetcodetrain
 * @description: No.680
 * @author: EvenHsia
 * @create: 2019-07-25 22:08
 **/

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Note:The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 *
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s){
        for (int i=0,j=s.length()-1;i<j;i++,j--){
            if (s.charAt(i)!=s.charAt(j)){
                return isPalindrome(s,i,j-1)||isPalindrome(s,i+1,j);
            }
        }
        return true;
    }
    // help method
    private boolean isPalindrome(String s,int i,int j){
        while (i<j){
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }



    //ugly version
    /*public boolean validPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while (i<j){
            if (s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else {
                boolean condition1=true;
                for (int k=i,l=j-1;k<l;){
                    if (s.charAt(k)==s.charAt(l)){
                        k++;
                        l--;
                    }else {
                        condition1=false;
                        break;
                    }
                }
                if (condition1) return true;
                boolean condition2=true;
                for (int k=i+1,l=j;k<l;){
                    if (s.charAt(k)==s.charAt(l)){
                        k++;
                        l--;
                    }else {
                        condition2=false;
                        break;
                    }
                }
                if (condition2) return true;
                return false;
            }
        }
        return true;
    }*/
}
