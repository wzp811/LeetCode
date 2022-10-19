package Examinations.H3C;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        char[] ch = str.toCharArray();
        int left = -1;
        for (int i = 0; i < ch.length; i++) {
            if (Character.isLetter(ch[i])) continue;
            if (i - left >= 2) {
                swap(ch, left + 1, i - 1);
            }
            left = i;
        }
        if (ch.length - left >= 2) swap(ch, left + 1, ch.length - 1);
        int cnt = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != ' ') {
                if (cnt > 0) res.append(" ");
                cnt = 0;
                res.append(ch[i]);
                continue;
            }
            cnt++;
        }
        System.out.println(new String(res));
    }

    public static void swap(char[] ch, int left, int right) {
        while (left < right) {
            char tmp = ch[left];
            ch[left] = ch[right];
            ch[right] = tmp;
            left++;
            right--;
        }
    }
}
