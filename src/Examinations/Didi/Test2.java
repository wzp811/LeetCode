package Examinations.Didi;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        int[][] times = new int[n][2];
        for (int i = 0; i < n; i++) times[i][0] = input.nextInt();
        input.nextLine();
        for (int i = 0; i < n; i++) times[i][1] = input.nextInt();
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        int[][] dp = new int[n][3];
        int[] left = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!(stack.isEmpty() || times[stack.peekLast()][1] < times[i][0])) {
                stack.pollLast();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.addLast(i);
        }
        dp[0][0] = 1;
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (left[i] == -1) {
                dp[i][0] = 1;
                continue;
            }
            dp[i][0] = dp[i - 1][0] + 1;
            dp[i][1] = dp[left[i]][0];
            dp[i][2] = dp[left[i]][1];
            res += dp[i][2];
        }
        System.out.println(res);
    }
}
