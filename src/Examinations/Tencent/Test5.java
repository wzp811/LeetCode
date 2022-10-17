package Examinations.Tencent;

import java.util.*;

public class Test5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
            sum += a[i];
        }
        int[] dp = new int[sum / 2 + 2];
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = sum / 2; j >= a[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - a[i]] + a[i]);
                max = Math.max(dp[j], max);
            }
        }
        Set<Integer> set = new HashSet<>();
        process(set, 0, 0, max, a);
        System.out.println(max + " " + -(sum - max));
        for (int i = 0; i < n; i++) {
            if (set.contains(i)) System.out.print("Y");
            else System.out.print("X");
        }
    }

    public static boolean process(Set<Integer> set, int index, int cur, int target, int[] a) {
        if (cur == target) {
            return true;
        }
        if (index >= a.length) {
            return false;
        }
        for (int i = index; i < a.length; i++) {
            if (cur + a[i] <= target) {
                set.add(i);
                if (process(set, i + 1, cur + a[i], target, a)) return true;
                set.remove(i);
            }
        }
        return false;
    }
}
