package Examinations.Didi;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        input.nextLine();
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) weight[i] = input.nextInt();
        Arrays.sort(weight);
        int left = 0, right = 0;
        int res = 0;
        while (right < n) {
            if (weight[right] - weight[left] > k) {
                res = Math.max(res, right - left);
                left++;
            } else {
                right++;
            }
        }
        res = Math.max(res, right - left);
        System.out.println(res);
    }
}
