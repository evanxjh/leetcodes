package strings;

/**
 * @author EvanHsia
 * @ClassName StringCompression.java
 * @Description No.443 Easy
 * @createTime 2019-10-05- 15:07
 */
//用两个指针，一个用来控制修改的位置，以用来遍历整个数组
public class StringCompression {
    public int compress(char[] chars){
        int i=0,j=0;
        int n=chars.length;
        while (j<n){
            if (j==n-1 || chars[j]!=chars[j+1]){
                chars[i++]=chars[j++];
            } else{
                chars[i++]=chars[j];
                int k=j;
                while (j<n && chars[j]==chars[k]){
                    j++;
                }
                String s=j-k+"";
                for (int m=0;m<s.length();m++){
                    chars[i++]=s.charAt(m);
                }
            }
        }
        return i;
    }
}
