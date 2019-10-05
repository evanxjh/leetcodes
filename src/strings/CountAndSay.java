package strings;

import org.junit.Test;

/**
 * @author EvanHsia
 * @ClassName CountAndSay.java
 * @Description No.38 Easy
 * @createTime 2019-10-05- 17:32
 */
public class CountAndSay {
    public String countAndSay(int n){
        String pre="1";
        for (int i=2;i<=n;i++){
            StringBuilder sb=new StringBuilder();
            int j=0;
            while (j<pre.length()){
                int start=j;
                while (j<pre.length() && pre.charAt(j)==pre.charAt(start)){
                    j++;
                }
                int len=j-start;
                sb.append(""+len+pre.charAt(start));
            }
            pre=sb.toString();
        }
        return pre;
    }

    @Test
    public void test(){
        countAndSay(4);
    }
}
