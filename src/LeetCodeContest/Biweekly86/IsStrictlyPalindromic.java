package LeetCodeContest.Biweekly86;

import java.util.ArrayDeque;
import java.util.Deque;

public class IsStrictlyPalindromic {
    public boolean isStrictlyPalindromic(int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 2; i <= n - 2; i++) {
            boolean ret = true;
            int bits = (int) (Math.log(n) / Math.log(i) + 1);
            int tmp = n;
            int index = 0;
            while (tmp > 0) {
                if (index > bits / 2) {
                    if (stack.peekLast() != tmp % i) ret = false;
                    stack.pollLast();
                } else {
                    if (!(index == bits / 2 && bits % 2 == 1))
                        stack.addLast(tmp % i);
                }
                tmp /= 10;
            }
            if (stack.isEmpty() && ret) return true;
        }
        return false;
    }
}
