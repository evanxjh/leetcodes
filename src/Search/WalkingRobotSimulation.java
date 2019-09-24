package Search;

import java.util.HashSet;
import java.util.Set;

/**
 * @author EvanHsia
 * @ClassName WalkingRobotSimulation.java
 * @Description No.874 Easy
 * @createTime 2019-09-24- 17:19
 */
public class WalkingRobotSimulation {
    private final int[][] dir=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int robotSim(int[] commands,int[][]obstacles){
        Set<String> record=new HashSet<>();
        for (int[] obs:obstacles){
            record.add(obs[0]+","+obs[1]);
        }
        //0表示朝北,1表示朝东，2表示朝南，3表示朝西
        int direction=0;
        int x=0,y=0;
        int len=0;
        for (int command:commands){
            if (command== -1){
                direction=(direction+1)%4;
            } else if (command==-2){
                direction=(direction+3)%4;
            }else {
                while (command-->0){
                    int newX=x+dir[direction][0];
                    int newY=y+dir[direction][1];
                    String s=newX+","+newY;
                    if (record.contains(s)){
                        break;
                    }
                    x=newX;
                    y=newY;
                }
                len=Math.max(len,x*x+y*y);
            }
        }
        return len;
    }
}
