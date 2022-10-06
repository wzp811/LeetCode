package Examinations.ChinaRenShou;

import java.util.Scanner;

public class Test3_2 {
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
        int[] dp = new int[n];
        dp[0] = a[0];
        for (int i = 1; i < n; i++) {

        }
        System.out.println(dp[n - 1]);
    }
}
