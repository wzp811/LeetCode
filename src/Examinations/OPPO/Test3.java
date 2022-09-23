package Examinations.OPPO;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        int[] values = new int[n + 1];
        int[] index = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            values[i] = input.nextInt();
            index[values[i]] = i;
        }
        while (input.hasNext()) {
            input.nextLine();
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (values[i] == i) continue;
            res++;
            int swapIndex = index[i];
            index[i] = index[values[i]];
            index[values[i]] = swapIndex;
            int tmp = values[i];
            values[i] = values[swapIndex];
            values[swapIndex] = tmp;
        }
        System.out.println(res);
    }
}
