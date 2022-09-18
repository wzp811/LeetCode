package Examinations.Meituan;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int x = input.nextInt();
        int y = input.nextInt();
        boolean[] inStack1 = new boolean[n + 1];
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        for (int i = 0; i < x; i++) {
            int cur = input.nextInt();
            stack1.addLast(cur);
            inStack1[cur] = true;
        }
        for (int i = 0; i < y; i++) {
            int cur = input.nextInt();
            stack2.addLast(cur);
        }
        long steps = 0;
        for (int i = 1; i <= n; i++) {
            if (inStack1[i]) {
                while (stack1.peekLast() != i) {
                    int cur = stack1.pollLast();
                    stack2.addLast(cur);
                    inStack1[cur] = false;
                    steps++;
                }
                stack1.pollLast();
                steps++;
            } else {
                while (stack2.peekLast() != i) {
                    int cur = stack2.pollLast();
                    stack1.addLast(cur);
                    inStack1[cur] = true;
                    steps++;
                }
                stack2.pollLast();
                steps++;
            }
        }
        System.out.println(steps);
    }
}
