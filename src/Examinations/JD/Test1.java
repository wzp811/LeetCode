package Examinations.JD;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Test1 {
    public static int getRes(String s) {
        int res = 0;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                if (cur > 1) {
                    res += (cur + 1) / 3;
                    cur = 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(getRes(s));
    }
}
