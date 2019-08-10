package Greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcodetrain
 * @description: No.763 Medium
 * @author: EvenHsia
 * @create: 2019-08-10 23:31
 **/

/**
 * 分割字符串，使得某个字母只在一个子串中出现，而且要使分割的子串尽可能多
 */
//贪心思路：记录每个字母最后出现时的index存入数组中，
// 从某字母开始节点遍历到该字母对应的最后节点，如果中间某些字母对应的最后位置更靠后，则更新最后节点
// 直到最后遍历节点与最后节点重合，以此作为一个分段
public class PartitionLabels {
    public List<Integer> partitionLabels(String s){
        int [] lastIndexofChar=new int [26];
        for (int i=0;i<s.length();i++){
            lastIndexofChar[s.charAt(i)-'a']=i;
        }
        List<Integer> partition=new ArrayList<>();
        int firstIndex=0;
        while (firstIndex<s.length()){
            int lastIndex=firstIndex;
            for (int i=firstIndex;i<s.length() && i<=lastIndex;i++){        //让firstindex去追赶lastindex，追上了说明这一段是要分的一段
                int index=lastIndexofChar[s.charAt(i)-'a'];
                if (index>lastIndex){
                    lastIndex=index;
                }
            }
            //追赶上后添加入答案中
            partition.add(lastIndex-firstIndex+1);
            firstIndex=lastIndex+1;
        }
        return partition;
    }
}
