package StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author EvanHsia
 * @ClassName AsteroidCollision.java
 * @Description No.735 Medium
 * @createTime 2019-10-08- 20:11
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids){
        if (asteroids==null || asteroids.length==0){
            return new int[]{};
        }
        if (asteroids.length==1){
            return new int[]{asteroids[0]};
        }
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<asteroids.length;i++){
            if (stack.isEmpty() || asteroids[i]>0){
                stack.push(asteroids[i]);
                continue;
            }
            while(true){
                int top=stack.peek();
                if (top<0){
                    stack.push(asteroids[i]);
                    break;
                }
                if (top==-asteroids[i]){
                    stack.pop();
                    break;
                } else if(top<-asteroids[i]){
                    stack.pop();
                    if (stack.isEmpty()){
                        stack.push(asteroids[i]);
                        break;
                    }
                }else {
                    break;
                }
            }
        }
        int[] res=new int[stack.size()];
        int i=stack.size()-1;
        while (!stack.isEmpty()){
            res[i--]=stack.pop();
        }
        return res;
    }
}
