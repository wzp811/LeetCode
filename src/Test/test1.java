package Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int l = input.nextInt();
        int m = input.nextInt();
        int[][] a = new int[m][2];
        for (int i = 0; i < m; i++) {
            a[i][0] = input.nextInt();
            a[i][1] = input.nextInt();
        }
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        if (a[0][0] > 1) {
            System.out.println("fail");
            return;
        }
        int[] dp = new int[m];
        int res = m + 1;
        for (int i = 0; i < m; i++) {
            if (a[i][0] == 1) {
                dp[i] = 1;
                continue;
            }
            int index = i - 1;
            while (index >= 0) {
                if (dp[index] > 0 && a[index][1] + 1 >= a[i][0]) dp[i] = Math.min(dp[index] + 1, dp[i]);
                index--;
            }
            if (dp[i] > 0 && a[i][1] >= l) res = Math.min(res, dp[i]);
        }
        System.out.println(res > m ? "fail" : res);
    }
}
