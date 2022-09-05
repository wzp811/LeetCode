package Test;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) x[i] = input.nextInt();
        long[] r = new long[n];
        int res = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - i - 1; j++) r[i] += x[j] * x[j + i];
            for (int j = n - i; j <= n - 1; j++) r[i] += x[j] * x[j + i - n];
            if (Math.abs(r[i]) > Math.abs(r[res])) {
                res = i;
                count = 0;
            } else if (Math.abs(r[i]) == Math.abs(r[res])) count++;
        }
        System.out.print(r[0]);
        for (int i = 1; i < n; i++) {
            System.out.print(" " + r[i]);
        }
        System.out.println();
        System.out.println(count == 0 ? r[res] : "NO");
    }
}
