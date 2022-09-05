package Test;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] a = new int[3][2];
        for (int i = 0; i < 3; i++) {
            a[i][0] = input.nextInt();
            a[i][1] = input.nextInt();
        }
        int k = input.nextInt();
        int[][][] b = new int[k][3][2];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 3; j++) {
                b[i][j][0] = input.nextInt();
                b[i][j][1] = input.nextInt();
            }
        }
        double[] s = new double[k + 1];
        s[k] = getS(a);
        int res = k;
        double tmp = Double.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            s[i] = getS(b[i]);
            if (s[i] >= s[k] && s[i] <= tmp && cont(a, b[i])) {
                tmp = s[i];
                res = i;
            }
        }
        for (int i = 0; i < 3; i++){
            System.out.print(b[res][i][0] + " " + b[res][i][1]);
            if (i != 2) System.out.print(" ");
        }
    }

    public static double getS(int[][] a) {
        double res = 0;
        for (int i = 0; i < 3; i++) {
            res += a[i][0] * a[(i + 1) % 3][1];
            res -= a[i][0] * a[(i + 2) % 3][1];
        }
        return Math.abs(res / 2.0);
    }

    public static boolean cont(int[][] a, int[][] b) {
        return true;
    }
}
