package Examinations.NIO;

import java.util.Scanner;

public class Test2 {
    public static void main1(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        String s = input.nextLine();
        char[] ss = s.toCharArray();
        for (int i = 0; i < k; i++) {
            reverse(ss, i, i + k - 1);
        }
        System.out.println(ss.toString());
    }

    public static void reverse(char[] s, int i, int j) {
        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        String s = input.nextLine();
        StringBuilder res = new StringBuilder();
        for (int i = k - 1; i < s.length(); i++) {
            res.append(s.charAt(i));
        }
        if ((n - k) % 2 == 0) {
            for (int i = k - 2; i >= 0; i--) {
                res.append(s.charAt(i));
            }
        } else {
            for (int i = 0; i < k - 1; i++) {
                res.append(s.charAt(i));
            }
        }
        System.out.println(res.toString());

    }
}
