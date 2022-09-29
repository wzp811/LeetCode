package Examinations.Ant;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        input.nextLine();
        int[] a = new int[n];
        int res = 0;
        boolean[][] used = new boolean[k + 1][(int) (1e5 / k + 1)];
        int[][] cnt = new int[k + 1][(int) (1e5 / k + 1)];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
            int p = a[i] % k;
            int q = a[i] / k;
            if (set.contains(a[i])) {
                cnt[p][q]++;
            } else {
                set.add(a[i]);
                used[p][q] = true;
            }
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j <= (int) (1e5 / k); j++) {
                if (cnt[i][j] == 0) continue;
                int cur = cnt[i][j];
                int index = j;
                while (index <= (1e5 / k) && cur > 0) {
                    index++;
                    res += cur;
                    if (used[i][index]) continue;
                    used[i][index] = true;
                    cur--;
                }
                res += (cur + 1) * cur / 2;
            }
        }
        System.out.println(res);
    }
}
