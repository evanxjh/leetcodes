package strings;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * @author EvenHsia
 * @ClassName stringcompute.java
 * @Description 编程之美/程序员代码面试指南等
 * @createTime 2019-08-05- 13:06
 */
public class stringcompute {
    //给定两个字符串 s1 和 s2，要求判定 s2 是否能够被 s1 做循环移位得到的字符串包含。
    //s1 进行循环移位的结果是 s1s1 的子字符串，因此只要判断 s2 是否是 s1s1 的子字符串即可。
    public boolean xunhuanyiwei(String s1,String s2){
        String s=s1+s1;
        return s.indexOf(s2)>0;
    }
    @Test
    public void xunhuantest(){
        String s1="AABCD";
        String s2="CDAA";
        String s3="BCDA";
        assertTrue(xunhuanyiwei(s1,s2));
        assertTrue(xunhuanyiwei(s1,s3));
    }


    public String yiwei(String s1,String s2){
        String s1reverse=new StringBuffer(s1).reverse().toString();
        String s2reverse=new StringBuffer(s2).reverse().toString();
        return new StringBuffer(s1reverse+s2reverse).reverse().toString();
    }

    @Test
    public void yiweitest(){
        String s1="abcd";
        String s2="123";
        System.out.print(yiwei(s1,s2));
    }

}
