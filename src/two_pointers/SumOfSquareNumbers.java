package two_pointers;

/**
 * @program: leetcodetrain
 * @description: No.633
 * @author: EvenHsia
 * @create: 2019-07-25 16:26
 **/
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c){
        for (int i=0,j=(int) Math.ceil(Math.sqrt(c));i<=j;){
            int sum=i*i+j*j;
            if (sum==c){
                return true;
            }else if (sum<c){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }
}
