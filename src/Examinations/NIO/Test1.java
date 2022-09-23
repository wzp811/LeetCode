package Examinations.NIO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int w = input.nextInt();
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = input.nextInt();
        int colorCnt = Arrays.stream(a).sum();
        int whiteCnt = w - colorCnt;
        int rest = whiteCnt - n + 1;
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        if (whiteCnt == n - 1) {
            System.out.println(colorCnt);
            int index = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < a[i]; j++) {
                    list.add(index++);
                }
                index++;
            }
        } else if (whiteCnt >= colorCnt) {
            //
        } else {
            for (int i = 0; i < n; i++) {
                int left = sum + a[i] + 1;
                int right = sum + rest;
                for (int j = right; j <= left; j++) {
                    list.add(j + 1);
                }
                sum += a[i] + 1;
            }
        }
        System.out.println(list.size());
        if (list.size() != 0) {
            System.out.print(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                System.out.print(" " + list.get(i));
            }
        }
    }

}
