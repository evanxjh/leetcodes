package StackAndQueue;

import java.util.Stack;

/**
 * @author EvanHsia
 * @ClassName EvaluateReversePolishNotation.java
 * @Description No.150 Medium
 * @createTime 2019-10-08- 19:45
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens){
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<tokens.length;i++){
            switch (tokens[i]){
                case "+":
                    int num1=stack.pop();
                    int num2=stack.pop();
                    stack.push(num1+num2);
                    break;
                case "-":
                    int num3=stack.pop();
                    int num4=stack.pop();
                    stack.push(num4-num3);
                    break;
                case "*":
                    int num5=stack.pop();
                    int num6=stack.pop();
                    stack.push(num5*num6);
                    break;
                case "/":
                    int num7=stack.pop();
                    int num8=stack.pop();
                    stack.push(num8/num7);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        return stack.pop();
    }
}
