package DivideAndConquer;

/**
 * @author EvanHsia
 * @ClassName DiffWaysToAddParentheses.java
 * @Description No.241 Medium
 * @createTime 2019-08-15- 10:19
 */


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 */
public class DiffWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input){
        List<Integer> ways=new ArrayList<>();
        for (int i=0;i<input.length();i++){
            char c=input.charAt(i);
            if (c=='+' || c=='-' || c=='*'){
                List<Integer> left=diffWaysToCompute(input.substring(0,i));                 //运算符左边可能计算的结果
                List<Integer> right=diffWaysToCompute(input.substring(i+1));                //运算符右边可能计算的结果
                for (int l:left){
                    for (int r:right){
                        switch (c){
                            case '+':
                                ways.add(l+r);
                                break;
                            case '-':
                                ways.add(l-r);
                                break;
                            case '*':
                                ways.add(l*r);
                                break;
                        }
                    }
                }
            }
        }
        if (ways.size()==0){                                                                //input中没有运算符
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }

    @Test
    public void sometest(){
        String s="2*3-4*5";
        System.out.print(diffWaysToCompute(s));
    }
}
