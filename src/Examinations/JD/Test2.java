package Examinations.JD;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {

//    public static void main(String[] args) {
//        long[] dp = new long[n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (num[i] % 2 == num[j] % 2) {
//                    dp[i] += dp[j];
//                    dp[i]++;
//                    dp[i] %= mod;
//                }
//            }
//        }
//    }
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) nums[i] = input.nextInt();

    System.out.println(getRes(nums));
}

    public static int getRes(int[] nums) {
        int mod = (int) (10E9 + 7);
        int cnt0 = 0, cnt1 = 0;
        int cur0 = 0, cur1 = 0;
        int sum0 = 0, sum1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                cur0 += cnt0;
                cur0 += sum0;
                cnt0++;
                sum0 += cur0;
                sum0 %= mod;
                cur0 %= mod;
            } else {
                cur1 += cnt1;
                cur1 += sum1;
                cnt1++;
                sum1 += cur1;
                sum1 %= mod;
                cur1 %= mod;
            }
        }
        return (cur0 + cur1) % mod;
    }
}
