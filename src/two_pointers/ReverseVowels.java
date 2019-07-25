package two_pointers;

/**
 * @program: leetcodetrain
 * @description: No.345
 * @author: EvenHsia
 * @create: 2019-07-25 16:40
 **/

import java.util.Arrays;
import java.util.HashSet;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 * Input: "hello"
 * Output: "holle"
 *
 * Example 2:
 * Input: "leetcode"
 * Output: "leotcede"
 */
public class ReverseVowels {
    private final static HashSet<Character> vowels=new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    public  String reverseVowels(String s){
        char[] result=new char[s.length()];
        for (int i=0,j=s.length()-1;i<=j;){
            char ci=s.charAt(i);
            char cj=s.charAt(j);
            if (!vowels.contains(ci)){
                result[i++]=ci;
            }else if(!vowels.contains(cj)){
                result[j--]=cj;
            }else{
                result[i++]=cj;
                result[j--]=ci;
            }
        }
        return new String(result);
    }

    public static void main(String[] args){
        String s="Hello";
        System.out.println(new ReverseVowels().reverseVowels(s));
    }
}
