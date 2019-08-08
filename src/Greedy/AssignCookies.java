package Greedy;

import java.util.Arrays;

/**
 * @author EvanHsia
 * @ClassName AssignCookies.java
 * @Description No.455 Easy
 * @createTime 2019-08-08- 20:09
 */
//贪心策略：应该先满足吃的少的，因为这样才不会浪费
//证明：可用反证法
public class AssignCookies {
    public int findContentChildren(int[] g,int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int gi=0,si=0;
        while (gi<g.length && si<s.length){
            if (g[gi]<=s[si]) {
                gi++;
                si++;
            } else {
                si++;
            }
        }
        return gi;
    }

}
