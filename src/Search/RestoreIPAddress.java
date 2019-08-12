package Search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EvanHsia
 * @ClassName RestoreIPAddress.java
 * @Description No.93 Medium
 * @createTime 2019-08-12- 21:07
 */

/**
 * 回溯问题，找出合法的ip地址
 */
public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s){
        List<String> address=new ArrayList<>();
        StringBuffer tempadd=new StringBuffer();
        doRestore(0,tempadd,address,s);
        return address;
    }
    private void doRestore(int k,StringBuffer tempadd,List<String> address,String s){         //String类型自动回溯
        if (k==4 || s.length()==0){
            if (k==4 && s.length()==0){
                address.add(tempadd.toString());
            }
            return;
        }
        for (int i=0;i<s.length() && i<=2;i++){         //最多有3位
            if (i!=0 && s.charAt(0)=='0'){                  //不可能有  255.02.255.0这样的
                break;
            }
            String part=s.substring(0,i+1);
            if (Integer.valueOf(part)<=255){
                if (tempadd.length()!=0){
                    part="."+part;
                }
                tempadd.append(part);
                doRestore(k+1,tempadd,address,s.substring(i+1));
                tempadd.delete(tempadd.length()-part.length(),tempadd.length());         //回溯tempadd，String不用回溯
            }
        }
    }
}
