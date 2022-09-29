package Examinations.Ant;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] res = new int[n];
        if (n < 3) {
            System.out.println(-1);
            return;
        } else {
            res[0] = 3;
            res[1] = 2;
            res[2] = 1;
            for (int i = 3; i < n; i++) {
                res[i] = i + 1;
            }
        }
        System.out.print(res[0]);
        for (int i = 1; i < n; i++) System.out.print(" " + res[i]);
    }
}
