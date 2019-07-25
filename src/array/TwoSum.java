package array;

import java.util.ArrayList;
import java.util.List;
/**
 * @program: leetcodetrain
 * @description: No.1 on leetcode
 * @author: EvenHsia
 * @create: 2019-07-25 14:04
 **/
public class TwoSum {
    private class NumNode {
        private int index;
        private int value;

        public NumNode(int i, int v) {
            this.index = i;
            this.value = v;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        List<NumNode> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            NumNode toadd = new NumNode(i, nums[i]);
            list.add(toadd);
        }
        list.sort((o1, o2) -> Integer.compare(o1.value, o2.value));       //lambda
        for (int i = 0, j = nums.length - 1; i < j; ) {
            NumNode nodei = list.get(i);
            NumNode nodej = list.get(j);
            int sum = nodei.value + nodej.value;
            if (sum == target) {
                return new int[]{nodei.index, nodej.index};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        int[] num = {11, 7, 2, 15};
        int[] result = test.twoSum(num, 9);
        for (int i : result) {
            System.out.print(i);
        }
    }
}


