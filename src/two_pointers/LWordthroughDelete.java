package two_pointers;

/**
 * @program: leetcodetrain
 * @description: No.524 Medium
 * @author: EvenHsia
 * @create: 2019-07-25 23:39
 **/

import java.util.List;

/**
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting
 * some characters of the given string. If there are more than one possible results, return the longest word with
 * the smallest lexicographical order. If there is no possible result, return the empty string.
 *
 * Note:All the strings in the input will only contain lower-case letters.
 *      The size of the dictionary won't exceed 1,000.
 *      The length of all the strings in the input won't exceed 1,000.
 *
 * Example 1:
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * Output:
 * "apple"
 *
 * Example 2:
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 * Output:
 * "a"
 */
public class LWordthroughDelete {
    public  String findLongestWord(String s, List<String> d){
        String longestword="";
        for (String target:d){
            int len1=longestword.length(),len2=target.length();
            if (len1>len2 || (len1==len2 && longestword.compareTo(target)<0)){             //比已有更短，或者同样长度且字典顺序靠后则不用考虑
                continue;
            }
            if (isSubString(s,target)){
                longestword=target;
            }
        }
        return longestword;
    }

    //help method  judge the substring
    private boolean isSubString(String s,String target){
        int i=0,j=0;
        while (i<s.length() && j<target.length()){
            if (s.charAt(i)==target.charAt(j)){
                j++;
            }
            i++;
        }
        return j==target.length();
    }
}
