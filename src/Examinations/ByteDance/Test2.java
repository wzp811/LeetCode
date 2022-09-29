package Examinations.ByteDance;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        while (t-- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            input.nextLine();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = input.nextInt();
            int res = 0;
            int len = 1;
            for (int i = 1; i < n; i++) {
                if (a[i] * 2 > a[i - 1]) {
                    len++;
                } else {
                    len = 1;
                }
                if (len >= k + 1) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
