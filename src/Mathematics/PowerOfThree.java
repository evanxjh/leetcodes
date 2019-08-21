package Mathematics;

/**
 * @author EvanHsia
 * @ClassName PowerOfThree.java
 * @Description No.326 Easy
 * @createTime 2019-08-21- 10:42
 */

/**
 * 判断是否为3的幂次
 */
public class PowerOfThree {
    //3^19是int中最大的3的幂次
    public boolean isPowerOfThree(int n){
        return n>0 && (1162261467 %n==0);
    }

    //正则表达式
    public boolean isPowerOfThree2(int n){
        String s=Integer.toString(n,3);    //3进制
        return s.matches("^10*$");        //^匹配开始位置，$匹配结束位置
    }
}
