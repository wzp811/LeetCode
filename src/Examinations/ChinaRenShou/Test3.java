package Examinations.ChinaRenShou;

import java.util.Scanner;

public class Test3 {
    static int res = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        input.nextLine();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = input.nextInt();
        input.nextLine();
        int[] b = new int[4];
        for (int i = 0; i < 4; i++) b[i] = input.nextInt();
        dfs(a, b, 0, 0);
        System.out.println(res);
    }

    public static void dfs(int[] a, int[] b, int index, int cur) {
        cur += a[index];
        if (index == a.length - 1) {
            res = Math.max(res, cur);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (b[i] == 0) continue;
            b[i]--;
            dfs(a, b, index + i + 1, cur);
            b[i]++;
        }
    }
}
