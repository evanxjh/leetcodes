package BinarySearch;

/**
 * @author EvanHsia
 * @ClassName FindSmallestGreaterThanTarget.java
 * @Description No.744 Easy
 * @createTime 2019-08-14- 16:15
 */

/**
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target,
 * find the smallest element in the list that is larger than the given target.
 *
 * if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 */
public class FindSmallestGreaterThanTarget {
    public char nextGreatestLetter(char[] letters,char target){
        int l=0,h=letters.length-1;
        while (l<=h){
            int mid=l+(h-l)/2;
            if (letters[mid]<=target){
                l=mid+1;
            } else{
                h=mid-1;
            }
        }
        return l<letters.length?letters[l]:letters[0];          //l>=letters.length说明target比最大的那个还大，应该返回第一个
    }
}
