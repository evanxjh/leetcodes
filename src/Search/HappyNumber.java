package Search;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author EvanHsia
 * @ClassName HappyNumber.java
 * @Description No.202 Easy
 * @createTime 2019-09-24- 21:40
 */
public class HappyNumber {
    public boolean isHappy(int n){
        Set<Integer> set=new HashSet<>();
        while (n!=1){
            if (set.contains(n)){
                return false;
            } else{
                set.add(n);
                n=getnext(n);
            }
        }
        return true;
    }
    private int getnext(int n){
        int res=0;
        while (n>=1){
            res+=(n%10)*(n%10);
            n=n/10;
        }
        return res;
    }
    @Test
    public void  sometest(){
        isHappy(19);
    }
}
