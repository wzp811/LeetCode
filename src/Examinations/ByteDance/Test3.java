package Examinations.ByteDance;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        while (n-- > 0) {
            long x = input.nextLong();
            long y = input.nextLong();
            input.nextLine();
            long num = Math.abs(y - x);
            if (num <= 4) System.out.println(num);
            else if (num <= 6) System.out.println(4);
            else {
                long tmp = (long) Math.sqrt(num - 1) + 1;
                if (num > tmp * tmp) System.out.println(tmp * 2);
                else if (num > tmp * (tmp - 1)) System.out.println(tmp * 2 - 1);
                else System.out.println(tmp * 2 - 2);
            }
        }
    }
}
