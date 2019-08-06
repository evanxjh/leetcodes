package BitManipulation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EvenHsia
 * @ClassName SwapWithXOR.java
 * @Description Easy
 * @createTime 2019-08-06- 14:37
 */
public class SwapWithXOR {
    public List<Integer> swap(int a , int b){
        a^=b;
        b^=a;
        a^=b;
        List<Integer> ret=new ArrayList<>();
        ret.add(a);
        ret.add(b);
        return  ret;
    }
    @Test
    public void sometests(){
        System.out.print(swap(1,2));
    }
}
