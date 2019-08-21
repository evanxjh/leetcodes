package Mathematics;

/**
 * @author EvanHsia
 * @ClassName AddStrings.java
 * @Description No.415 Easy
 * @createTime 2019-08-21- 09:34
 */
public class AddStrings {
    public String addString(String num1,String num2){
        int i=num1.length()-1,j=num2.length()-1,carry=0;
        StringBuilder sb=new StringBuilder();
        while (carry!=0 || i>=0 || j>=0){
            int x=i<0?0:num1.charAt(i--)-'0';
            int y=j<0?0:num2.charAt(j--)-'0';
            sb.append((x+y+carry)%10);
            carry=(x+y+carry)/10;
        }
        return sb.reverse().toString();
    }
}
