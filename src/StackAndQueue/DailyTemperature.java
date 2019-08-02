package StackAndQueue;

/**
 * @program: leetcodetrain
 * @description: No.739 Medium
 * @author: EvenHsia
 * @create: 2019-08-02 23:23
 **/

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input,
 * tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 */
public class DailyTemperature {
    public int[] dailyTemperatures(int[] T){
        int[] ret=new int[T.length];
        Arrays.fill(ret,0);
        Stack<node> stack=new Stack<>();

        for (int i=0;i<T.length;i++){
            if (stack.isEmpty()){
                stack.push(new node(T[i],i));
                continue;
            }
            int top=stack.peek().val;
            while (T[i]>top){
                node rem=stack.pop();
                ret[rem.index]=i-rem.index;
                if (stack.isEmpty()) break;
                top=stack.peek().val;
            }
            stack.push(new node(T[i],i));
        }
        return ret;
    }
    private class node{
        int val;
        int index;
        public node(int v,int i){
            this.val=v;
            this.index=i;
        }
    }

    @Test
    public void sometest(){
        int[] T=new int[]{73,74,75,71,69,72,76,73};
        for (int k:dailyTemperatures(T)){
            System.out.println(k);
        }
    }
}
