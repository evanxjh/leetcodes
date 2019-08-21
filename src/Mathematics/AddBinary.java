package Mathematics;

/**
 * @author EvanHsia
 * @ClassName AddBinary.java
 * @Description No.67 Easy
 * @createTime 2019-08-21- 09:08
 */
public class AddBinary {
    public String addBinary(String a,String b){
        int i=a.length()-1,j=b.length()-1;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        while (carry==1 || i>=0 || j>=0){
            if (i>=0 && a.charAt(i--)=='1'){
                carry++;
            }
            if (j>=0 && b.charAt(j--)=='1'){
                carry++;
            }
            sb.append(carry %2);                             //精髓，不用执行判断语句
            carry=carry /2;
        }
        return sb.reverse().toString();
    }
}
