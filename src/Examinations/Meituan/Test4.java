package Examinations.Meituan;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] indexRed = new int[n + 1];
        int[] indexBlue = new int[n + 1];
        int[] balls = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            int cur = input.nextInt();
            if (cur > 0) {
                indexRed[cur] = i;
            } else {
                indexBlue[-cur] = i;
            }
            balls[i] = cur;
        }
        long res = 0;
        for (int i = 1; i <= n; i++) {
            int left = n;
            for (int j = i + 1; j <= n; j++) {
                left = Math.min(left, indexRed[j]);
            }
            for (int j = indexRed[i]; j > left; j--) {
                int cur = balls[j];
                int last = balls[j - 1];
                if (cur > 0) {
                    indexRed[cur]--;
                } else {
                    indexBlue[-cur]--;
                }
                if (last > 0) {
                    indexRed[last]++;
                } else {
                    indexBlue[-last]++;
                }
                int tmp = balls[j];
                balls[j] = balls[j - 1];
                balls[j - 1] = tmp;
                res++;
            }
        }

        for (int i = 1; i <= n; i++) {
            int left = n;
            for (int j = i + 1; j <= n; j++) {
                left = Math.min(left, indexBlue[j]);
            }
            for (int j = indexBlue[i]; j > left; j--) {
                int cur = balls[j];
                int last = balls[j - 1];
                if (cur > 0) {
                    indexRed[cur]--;
                } else {
                    indexBlue[-cur]--;
                }
                if (last > 0) {
                    indexRed[last]++;
                } else {
                    indexBlue[-last]++;
                }
                int tmp = balls[j];
                balls[j] = balls[j - 1];
                balls[j - 1] = tmp;
                res++;
            }
        }
        System.out.println(res);
    }
}
