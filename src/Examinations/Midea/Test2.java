package Examinations.Midea;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String[] k = s.split(",");
        int num1 = 0;
        for (int i = 0; i < k[0].length(); i++) {
            if (Character.isDigit(k[0].charAt(i))) {
                num1 *= 10;
                num1 += k[0].charAt(i) - '0';
            }
        }
        System.out.println(num1 + Double.valueOf(k[1]) + Double.valueOf(k[2]));
    }
}
