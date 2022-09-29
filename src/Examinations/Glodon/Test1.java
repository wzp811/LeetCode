package Examinations.Glodon;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        input.nextLine();
        boolean[] flag = new boolean[2];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
            flag[a[i] % 2] = true;
        }
        if (flag[0] && flag[1]) Arrays.sort(a);
        for (int num : a) System.out.print(num + " ");
    }
}
