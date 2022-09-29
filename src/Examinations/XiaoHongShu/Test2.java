package Examinations.XiaoHongShu;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        while (n-- > 0) {
            String s1 = input.nextLine();
            String s2 = input.nextLine();
            int i = 0, j = 0;
            while (i < s1.length() && j < s2.length()) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            if (j == s2.length()) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
