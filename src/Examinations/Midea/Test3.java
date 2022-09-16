package Examinations.Midea;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int res = 0;
        int cntM = 0;
        int cntP = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'M') {
                cntM++;
                cntP = 0;
                if (cntM == 3) {
                    break;
                }
            } else if (s.charAt(i) == 'P') {
                cntP++;
                if (cntP > 3) {
                    res += 15;
                } else {
                    res += 10;
                }
            } else if (s.charAt(i) == 'G') {
                cntP = 0;
                res += 5;
            }
        }
        System.out.println(res);
    }
}
