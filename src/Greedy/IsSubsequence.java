package Greedy;

/**
 * @program: leetcodetrain
 * @description: No.392 Easy
 * @author: EvenHsia
 * @create: 2019-08-10 22:06
 **/

/**
 * 判断s是不是t的子串，t很长，然而s相对较短
 */
//考虑用双指针，然后并没有变快
public class IsSubsequence {
    public boolean isSubsequence(String s,String t){
        int start=0,end=t.length()-1;
        int l=0,h=s.length()-1;
        while (l<=h && start<=end){
            if (t.charAt(start++)==s.charAt(l)){
                l++;
            }
            if (t.charAt(end--)==s.charAt(h)){
                h--;
            }
        }
        if (l>h)return true;
        else return false;
    }
}
