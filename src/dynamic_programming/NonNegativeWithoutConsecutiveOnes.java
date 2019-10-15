package dynamic_programming;

/**
 * @author EvanHsia
 * @ClassName NonNegativeWithoutConsecutiveOnes.java
 * @Description No.600 Hard
 * @createTime 2019-10-15- 10:25
 */
public class NonNegativeWithoutConsecutiveOnes {
    //可以用直接法判断是否存在连续的1
    //此为用动态规划的解法
    public int findIntegers(int num){
        String str_num=toBinaryStr(num);
        int size=str_num.length();
        //dp0[i]表示当前位置设置为0时的整数的个数
        //dp1[i]表示当前位置设置为1时的整数的个数
        int[] dp0=new int[size];
        int[] dp1=new int[size];

        dp0[0]=1;
        dp1[0]=1;
        for (int i=1;i<size;i++){
            dp0[i]=dp0[i-1]+dp1[i-1];               //二进制中0的前面可以是1，也可以是0
            dp1[i]=dp0[i-1];                        //二进制中1的前面只能是0
        }

        int cnt=dp0[size-1]+dp1[size-1];
        for (int i=size-2;i>=0;i--){
            //出现连续的1，则剩下的<num的数它们的解必然<=num的解，此时的解就是结果
            if (str_num.charAt(i)=='1' && str_num.charAt(i+1)=='1'){
                break;
            }
            //对于10和01对解都没有影响
            //对于00，第一个0，有00和01，两种，则需要去除01
            if (str_num.charAt(i)=='0' && str_num.charAt(i+1)=='0'){
                cnt-=dp1[i];
            }
        }
        return cnt;
    }


    //倒序的二进制字符串表示
    private String toBinaryStr(int num){
        StringBuilder sb=new StringBuilder();
        while (num>0){
            sb.append(num%2+"");
            num/=2;
        }
        return sb.toString();
    }
}
