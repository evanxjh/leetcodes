package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EvanHsia
 * @ClassName NumberOfMatchingSubsequence.java
 * @Description No.792 Medium
 * @createTime 2019-10-08- 14:40
 */
public class NumberOfMatchingSubsequence {
    public int numMatchingSubseq(String S,String[] words){
        //记录S中字母的位置
        List<Integer>[] pos=new ArrayList[26];
        for (int i=0;i<26;i++){
            pos[i]=new ArrayList<>();
        }
        //遍历S，记录位置
        for (int i=0;i<S.length();i++){
            char c=S.charAt(i);
            pos[c-'a'].add(i);
        }
        int res=0;
        for (String word:words){
            int j=0;
            int cur=-1;
            while (j<word.length()){
                int k=0;
                //每个pos的List中，i都是从小到大自动排序的
                while (k!=pos[word.charAt(j)-'a'].size()){
                    if (pos[word.charAt(j)-'a'].get(k)>cur){
                        cur=pos[word.charAt(j)-'a'].get(k);
                        break;
                    }
                    k++;
                }
                //没找到符合要求的，直接跳出，导致j不会增加
                if (k==pos[word.charAt(j)-'a'].size()){
                    break;
                }
                j++;
            }
            if (j==word.length()){
                res++;
            }
        }
        return res;
    }
}
