package Mathematics;

/**
 * @author EvanHsia
 * @ClassName ExcelSheetColumn.java
 * @Description No.168 Easy
 * @createTime 2019-08-16- 14:53
 */
//按照excel表格的型式，1->A,2->B,26->Z,27->AA
public class ExcelSheetColumn {
    public String convertToTitle(int n){
        if (n==0){
            return "";
        }
        n--;
        return convertToTitle(n/26)+(char) ('A'+n%26);
    }
}
