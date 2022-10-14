package Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Huawei1 {
    public int getMax1(int[] lines) {
        Deque<Integer> stackLeft = new ArrayDeque<>();
        Deque<Integer> stackRight = new ArrayDeque<>();
        int[] left = new int[lines.length];
        int[] right = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            left[i] = i;
            right[lines.length - 1 - i] = lines.length - 1 - i;
            while (!(stackLeft.isEmpty() || lines[stackLeft.peekLast()] <= lines[i])) {
                stackLeft.pollLast();
            }
            stackLeft.addLast(i);
            left[i] = stackLeft.peekFirst();
            while (!(stackRight.isEmpty() || lines[stackRight.peekLast()] <= lines[lines.length - 1 - i])) {
                stackRight.pollLast();
            }
            stackRight.addLast(lines.length - 1 - i);
            right[lines.length - 1 - i] = stackRight.peekFirst();
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        return 0;
    }

    public int getMax(int[] lines) {
        int[] lefts = new int[lines.length];
        int[] rights = new int[lines.length];
        int res = 0;
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (lines[j] >= lines[i]) {
                    lefts[i] = j;
                    break;
                }
            }
            for (int j = lines.length - 1; j >= i; j--) {
                if (lines[j] >= lines[i]) {
                    rights[i] = j;
                    break;
                }
            }
            res = Math.max(res, lines[i] * (rights[i] - lefts[i]));
        }
        System.out.println(Arrays.toString(lefts));
        System.out.println(Arrays.toString(rights));
        return res;
    }

    public static void main(String[] args) {
        int[] lines = new int[] {1, 1, 100, 100, 1, 1};
        Huawei1 obj = new Huawei1();
        System.out.println(obj.getMax(lines));
    }
}
