package Examinations.Huawei;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        long[][] matrix = new long[m][n];
        long[][] prev = new long[m][n];
        long[][] cnt = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input.nextInt();
                if (matrix[i][j] == 0) {
                    prev[i][j] = 0;
                    cnt[i][j] = 0;
                } else {
                    prev[i][j] = matrix[i][j];
                    cnt[i][j] = 1;
                    if (j > 0) {
                        prev[i][j] += prev[i][j - 1];
                        cnt[i][j] += cnt[i][j - 1];
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) System.out.println(Arrays.toString(prev[i]));
        for (int i = 0; i < m; i++) System.out.println(Arrays.toString(cnt[i]));
        long res = 0;
        int[][] lefts = new int[m][n];
        int[][] rights = new int[m][n];
        Deque<Integer> stackLeft = new ArrayDeque<>();
        Deque<Integer> stackRight = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            stackLeft.clear();
            stackRight.clear();
            Arrays.fill(lefts, -1);
            Arrays.fill(rights, m);
            for (int j = 0; j < m; j++) {
                while (!(stackLeft.isEmpty() || cnt[stackLeft.peekLast()][i] >= cnt[j][i])) {
                    lefts[j][i] = stackLeft.pollLast();
                }
                stackLeft.add(j);
                while (!(stackRight.isEmpty() || cnt[stackRight.peekLast()][i] >= cnt[m - j + 1][i])) {
                    rights[m - j + 1][i] = stackLeft.pollLast();
                }
                stackRight.add(m - j + 1);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) continue;

                int left = i - 1, right = i + 1;
                long cur = prev[i][j];
                while (left >= 0 && cnt[left][j] >= cnt[i][j]) {
                    cur += prev[left][j] - prev[left][(int) (j - cnt[i][j])];
                    left--;
                }
                while (right < m && cnt[right][j] >= cnt[i][j]) {
                    cur += prev[right][j] - prev[right][(int) (j - cnt[i][j])];
                    right++;
                }
                res = Math.max(res, cur);
            }
        }
        System.out.println(res);
    }
}

/*
4 5
1 0 0 0 0
0 1 2 1 1
0 1 1 1 1
0 0 0 0 0
 */

/*

4 5
1 0 5 0 0
0 1 2 1 1
0 1 1 1 1
0 0 5 0 0
 */
