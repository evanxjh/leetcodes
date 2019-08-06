package BitManipulation;

/**
 * @author EvanHsia
 * @ClassName MaximumProductOfWordLength.java
 * @Description No.318 Medium
 * @createTime 2019-08-06- 19:04
 */

/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words
 * do not share common letters. You may assume that each word will contain only lower case letters.
 * If no such two words exist, return 0.
 */
//26个字母，可用32位的int,来存储每个字符是否出现过，1代表出现过，0代表未出现，靠左移0-25位对不同位操作
public class MaximumProductOfWordLength {
    public int maxProduct(String[] words){
        int n= words.length;
        int[] val=new int[n];
        for (int i=0;i<n;i++){
            for (char c:words[i].toCharArray()){
                val[i] |=1<<(c-'a');                //review
            }
        }
        int ret=0;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if ((val[i]&val[j])==0){
                    ret=Math.max(ret,words[i].length()*words[j].length());
                }
            }
        }
        return ret;
    }
}
