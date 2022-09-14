package Examinations.Baidu;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main1(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] monsters = new int[n];
        for (int i = 0; i < n; i++) monsters[i] = input.nextInt();
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (monsters[i] <= 0) continue;
            if (i + 1 >= n || i + 2 >= n || monsters[i + 1] < 2 || monsters[i + 2] < 3) {
                res += monsters[i];
                monsters[i] = 0;
                continue;
            }
            int cur = monsters[i];
            cur = Math.min(monsters[i + 1] / 2, cur);
            cur = Math.min(monsters[i + 2] / 3, cur);
            res += 5L * cur;
            monsters[i] -= cur;
            monsters[i + 1] -= cur * 2;
            monsters[i + 2] -= cur * 3;
            res += monsters[i];
            monsters[i] = 0;
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] monsters = new int[n];
        for (int i = 0; i < n; i++) monsters[i] = input.nextInt();
        long[] dp = new long[monsters.length + 1];
        dp[0] = 0;
        dp[1] = monsters[0];
        dp[2] = monsters[1] + dp[1];
        for (int i = 3; i <= dp.length; i++) {
            int cur = monsters[i - 3];
            cur = Math.min(cur, monsters[i - 2] / 2);
            cur = Math.min(cur, monsters[i - 1] / 3);
            dp[i] = Math.min(dp[i - 1] + monsters[i], dp[i - 3] + cur * 5 + monsters[i - 3] - cur + monsters[i - 2] - cur * 2 + monsters[i - 1] - cur * 3);
        }
        System.out.println(dp[dp.length]);

    }
    public static void main3(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] monsters = new int[n];
        for (int i = 0; i < n; i++) monsters[i] = input.nextInt();
        long[] dp = new long[monsters.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 0;
        for (int i = 3; i <= monsters.length; i++) {
            if (monsters[i - 1] < 3 || monsters[i - 2] < 2 || monsters[i - 3] < 1) dp[i] = dp[i - 1];
            dp[i] = monsters[i - 3];
            dp[i] = Math.min(dp[i], monsters[i - 2] / 2);
            dp[i] = Math.min(dp[i], monsters[i - 1] / 3);

        }

    }
}
