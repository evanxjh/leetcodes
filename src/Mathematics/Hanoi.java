package Mathematics;

/**
 * @author EvanHsia
 * @ClassName Hanoi.java
 * @Description 汉诺塔
 * @createTime 2019-09-23- 15:47
 */
public class Hanoi {
    public static void move(int n,String from,String buffer,String to){
        if (n==1){
            System.out.println("from"+from+"to"+to);
            return;
        }
        move(n-1,from,to,buffer);
        move(1,from,buffer,to);
        move(n-1,buffer,from,to);
    }

    public static void main(String[] args) {
        Hanoi.move(3,"H1","H2","H3");
    }
}
