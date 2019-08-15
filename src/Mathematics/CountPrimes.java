package Mathematics;

/**
 * @author EvanHsia
 * @ClassName CountPrimes.java
 * @Description No.204 Easy
 * @createTime 2019-08-15- 16:30
 */
public class CountPrimes {
    public int countPrimes(int n){
        boolean[] notPrimes=new boolean[n+1];
        int count=0;
        for (int i=2;i<n;i++){
            if (notPrimes[i]){
                continue;
            }
            count++;
            for (long j=(long) (i)*i;j<n;j+=i){                  //将i的整数倍踢出去
                notPrimes[(int)j]=true;
            }
        }
        return count;
    }
}
