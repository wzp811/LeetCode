package Examinations.Meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int x = input.nextInt();
        int y = input.nextInt();
        int[] ranks = new int[n];
        for (int i = 0; i < n; i++) {
            ranks[i] = input.nextInt();
        }
        Arrays.sort(ranks);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (ranks[i] * ranks[i] >= y && 2 * ranks[i] >= x) {
                sum += n - i - 1;
            } else if (ranks[i] + ranks[ranks.length - 1] < x || ranks[i] * ranks[ranks.length - 1] < y) {
                continue;
            } else {
                for (int j = i + 1; j < n; j++) {
                    if (ranks[i] + ranks[j] >= x && ranks[i] * ranks[j] >= y) {
                        sum += n - j;
                        break;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
