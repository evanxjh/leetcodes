package Greedy;

/**
 * @author EvanHsia
 * @ClassName LemonadeChange.java
 * @Description No.86 Easy
 * @createTime 2019-10-08- 15:55
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills){
        int five=0;
        int ten=0;
        int twenty=0;
        for (int bill:bills){
            if (bill==5){
                five++;
            }else if (bill==10){
                ten++;
                if (five==0){
                    return false;
                }
                five--;
            }else {
                //优先找10块钱的
                if (ten>0 && five>0){
                    ten--;
                    five--;
                }else if (five>2){
                    five-=3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
