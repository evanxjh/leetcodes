package strings;

import org.junit.Test;

/**
 * @author EvanHsia
 * @ClassName ExpressiveWords.java
 * @Description No.809 Medium
 * @createTime 2019-10-05- 15:55
 */
public class ExpressiveWords {
    public int expressiveWords(String S,String[] words){
        char[] sc=S.toCharArray();
        int res=0;
        for (String word:words){
            char[] wc=word.toCharArray();
            if (check(sc,wc)){
                res++;
            }
        }
        return res;
    }
    private boolean check(char[] sc,char[] wc){
        if (sc.length<wc.length){
            return false;
        }
        int i=0,j=0;
        while (i<sc.length && j<wc.length){
            if (sc[i]!=wc[j]){
                return false;
            }
            int sstart=i,wstart=j;
            while (i<sc.length && sc[i]==sc[sstart]){
                i++;
            }
            while (j<wc.length && wc[j]==wc[wstart]){
                j++;
            }
            int slen=i-sstart;
            int wlen=j-wstart;

            if (slen>=3 && slen>=wlen){
                continue;
            }
            if (slen==wlen){
                continue;
            }
            return false;
        }
        return (i==sc.length && j==wc.length);          //保证所有字符都被查询过
    }

    @Test
    public void test(){
        String s="heeellooo";
        String[] words=new String[]{"hello","hi","helo"};
        expressiveWords(s,words);
    }
}
