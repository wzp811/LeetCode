package LeetCodeContest.Weekly312;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GoodIndices {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums.length < 2 * k + 1) return res;
        if (k == 1) {
            for (int i = 1; i < nums.length - 1; i++) res.add(i);
            return res;
        }
        Deque<Integer> stackLeft = new ArrayDeque<>();
        Deque<Integer> stackRight = new ArrayDeque<>();
        boolean[][] check = new boolean[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            while (!(stackLeft.isEmpty() || nums[i] <= nums[stackLeft.peekLast()])) {
                stackLeft.pollLast();
            }
            stackLeft.addLast(i);
            if (i - k + 1 >= 0) {
                check[i][0] = stackLeft.size() == k;
                if (i - k + 1 == stackLeft.peekFirst()) stackLeft.pollFirst();
            }
            while (!(stackRight.isEmpty() || nums[nums.length - 1 - i] <= nums[stackRight.peekLast()])) {
                stackRight.pollLast();
            }
            stackRight.addLast(nums.length - i - 1);
            if (nums.length - i + k - 1 <= nums.length) {
                check[nums.length - i - 1][1] = stackRight.size() == k;
                if (nums.length - i - 1 + k == stackRight.peekFirst() + 1) stackRight.pollFirst();
            }
            // System.out.println(stackLeft);
            // System.out.println(stackRight);
            // System.out.println();
        }
        // for (int i = 0; i < nums.length; i++) System.out.println(check[i][0] +" " + check[i][1]);
        for (int i = k; i < nums.length - k; i++) {
            if ((check[i - 1][0] && check[i + 1][1])) res.add(i);
        }
        return res;
    }



}
