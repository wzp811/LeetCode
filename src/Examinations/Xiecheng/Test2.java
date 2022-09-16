package Examinations.Xiecheng;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        boolean[][] res = new boolean[16][16];
        int[] tmp1 = new int[]{12, 3, 10, 5};
        for (int i = 0; i < 4; i++) {
            res[9][tmp1[i]] = true;
            res[tmp1[i]][9] = true;
            res[6][tmp1[i]] = true;
            res[tmp1[i]][6] = true;
        }
        res[1][8] = true;
        res[8][1] = true;
        res[2][4] = true;
        res[4][2] = true;
        res[7][14] = true;
        res[14][7] = true;
        res[11][13] = true;
        res[13][11] = true;
        while (t-- > 0) {
            int a = 0, b = 0;
            int cnta = 0, cntb = 0;
            for (int i = 0; i < 4; i++) {
                int cur = input.nextInt();
                a *= 2;
                a += cur;
                cnta += cur;
            }
            for (int i = 0; i < 4; i++) {
                int cur = input.nextInt();
                b *= 2;
                b += cur;
                cntb += cur;
            }
            if (cnta != cntb) {
                System.out.println(-1);
            } else if (cnta == 0 || cntb == 4 || a == b){
                System.out.println(0);
            } else if (cnta == 2) {
                System.out.println(res[a][b] ? 1 : 2);
            } else if (cnta == 1 || cnta == 3) {
                System.out.println(res[a][b] ? 2 : 1);
            }
        }
    }
}
