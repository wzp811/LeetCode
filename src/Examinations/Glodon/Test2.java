package Examinations.Glodon;

import java.util.Scanner;

public class Test2 {
    static int mod = (int) 1e9 + 7;
    static long res = 0;
    static int k;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        k = input.nextInt();
        input.nextLine();
        String s = input.nextLine();
        dfs(s, 0, 0);
        System.out.println(res);
    }

    public static void dfs(String s, int index, long cur) {
        if (index == s.length()) return;
        if (cur % k == 0) {
            res++;
            res %= mod;
            System.out.println(cur);
        }
        for (int i = index + 1; i < s.length(); i++) {
            long next = cur * 10 + s.charAt(i) - '0';
            dfs(s, i, next);
        }
    }
}
