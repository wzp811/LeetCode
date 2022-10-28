package Y2022.Y2022_October;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class No907_SumSubarrayMins {
    public int sumSubarrayMins(int[] arr) {
        int mod = (int) (1e9 + 7);
        int[] lefts = new int[arr.length];
        int[] rights = new int[arr.length];
        Arrays.fill(lefts, -1);
        Arrays.fill(rights, arr.length);
        Deque<Integer> stackLeft = new ArrayDeque<>();
        Deque<Integer> stackRight = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!(stackRight.isEmpty() || arr[stackRight.peekLast()] <= arr[i])) {
                rights[stackRight.pollLast()] = i;
            }
            stackRight.addLast(i);
            while (!(stackLeft.isEmpty() || arr[stackLeft.peekLast()] < arr[arr.length - i - 1])) {
                lefts[stackLeft.pollLast()] = arr.length - i - 1;
            }
            stackLeft.add(arr.length - i - 1);
        }
        // System.out.println(Arrays.toString(lefts));
        // System.out.println(Arrays.toString(rights));
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            long cur = 0;
            cur = (i - lefts[i]) * (rights[i] - i) % mod;
            cur %= mod;
            sum += cur * arr[i];
            sum %= mod;
        }
        return (int) (sum % mod);
    }
}
