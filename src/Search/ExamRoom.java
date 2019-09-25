package Search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author EvanHsia
 * @ClassName ExamRoom.java
 * @Description No.855 Medium
 * @createTime 2019-09-25- 13:59
 */
//要用TreeSet，有排序功能
public class ExamRoom {
    //存储学生座位位置
    private List<Integer> seats;
    //座位总数
    private int n;
    public ExamRoom(){}
    private ExamRoom(int N){
        n=N;
        seats=new ArrayList<>();
    }

    public int seat(){
        if (seats.isEmpty()){
            seats.add(0);
            return 0;
        }
        //要坐的位置
        int res=0;
        //上一个同学的位置
        int idx=0;
        int maxDis=0;
        //0位置有人
        if (seats.contains(0)){
            maxDis=seats.get(0)-0;
        }
        for (int i=0;i<seats.size();i++){
            int dis=(seats.get(i)-idx)/2;
            if (dis>maxDis ){
                maxDis=dis;
                res=(seats.get(i)-idx)/2+idx;
            }
            idx=seats.get(i);
        }
        //最后一个位置是否有人
        if (!seats.contains(n-1)){
            int dis=n-1-seats.get(seats.size()-1);
            if (dis>maxDis){
                maxDis=dis;
                res=n-1;
            }
        }
        seats.add(res);
        return res;
    }

    public void leave(int p){
        for (int i=0;i<seats.size();i++){
            if (seats.get(i)==p){
                seats.remove(i);
            }

        }
    }
    @Test
    public void test(){
        this.n=10;
        seats=new ArrayList<>();
        System.out.println(seat());
        System.out.println(seat());
        System.out.println(seat());
        System.out.println(seat());
    }

    @Test
    public void testTreeSet(){
        Set<Integer> set=new TreeSet<>();
        set.add(5);
        set.add(3);
        set.add(0);
        set.add(1);
        for (int k:set){
            System.out.print(k+" ");
        }
    }
}
