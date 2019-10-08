package Greedy;

import java.util.Arrays;

/**
 * @author EvanHsia
 * @ClassName AdvantageShuffle.java
 * @Description No.870 Medium
 * @createTime 2019-10-08- 17:10
 */
public class AdvantageShuffle {
    //每次都拿A中最大的马和B中刚好比它弱一点的配对，如果不存在，就拿B中最大的与之配对        类比田忌赛马
    public int[] advantageCount(int[] A,int[] B){
        int n=A.length;

        int[] C=new int[n];
        for (int i=0;i<n;i++){
            C[i]=B[i];
        }

        Arrays.sort(A);
        Arrays.sort(C);

        int[] tmp=new int[n];
        int k=0;
        int j=n;

        for (int indexA=0,indexC=0;indexA<n;indexA++,indexC++){
            if (A[indexA]<=C[indexC]){          //劣等马放最后面
                tmp[--j]=A[indexA];
                indexC--;               //这匹马等会还要用，和indexC++相抵
            }else {
                tmp[k++]=A[indexA];
            }
        }
        int[] res=new int[n];

        //tmp和res对应，C和B对应
        for (int i=0;i<n;i++){
            for (int m=0;m<n;m++){
                if (B[i]==C[m]){
                    res[i]=tmp[m];
                    C[m]=-1;
                    break;          //跳出内循环
                }
            }
        }
        return res;
    }
}
