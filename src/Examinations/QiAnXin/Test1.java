package Examinations.QiAnXin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputA = input.nextLine();
        String inputB = input.nextLine();
        String[] kA = inputA.split(",");
        String[] kB = inputB.split(",");
        int[][] prices = new int[kA.length][2];
        for (int i = 0; i < prices.length; i++) {
            prices[i][0] = Integer.valueOf(kA[i]);
            prices[i][1] = Integer.valueOf(kB[i]);
        }

    }
}
