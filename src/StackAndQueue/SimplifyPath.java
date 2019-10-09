package StackAndQueue;

import java.util.Stack;

/**
 * @author EvanHsia
 * @ClassName SimplifyPath.java
 * @Description No.71 Medium
 * @createTime 2019-10-08- 20:02
 */
public class SimplifyPath {
    public String simplifyPath(String path){
        String[] paths=path.split("/");

        Stack<String> stack=new Stack<>();
        for (String s:paths){
            if ("..".equals(s) && !stack.isEmpty()){
                stack.pop();
            }
            if (!"..".equals(s) && !"".equals(s) && !".".equals(s)){
                stack.push(s);
            }
        }
        return "/"+String.join("/",stack);
    }
}
