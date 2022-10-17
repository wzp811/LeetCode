package Examinations.Tencent;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long l = input.nextLong();
        long r = input.nextLong();
        l--;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < 64; i++) {
            if (((1 << i) & l) != 0) queue.addLast(i);
        }
        boolean flag = queue.size() % 2 == 0;
        long left = 0;
        while (!queue.isEmpty()) {
            int cur = queue.pollFirst();
            if (cur == 1) {
                left += flag ? 1 : 0;
                break;
            }
            left += 1 << (cur - 1);
        }
        for (int i = 0; i < 64; i++) {
            if (((1 << i) & r) != 0) queue.addLast(i);
        }
        flag = queue.size() % 2 == 0;
        long right = 0;
        while (!queue.isEmpty()) {
            int cur = queue.pollFirst();
            if (cur == 1) {
                right += flag ? 1 : 0;
                break;
            }
            right += 1 << (cur - 1);
        }
        System.out.println(right - left);
    }
}
