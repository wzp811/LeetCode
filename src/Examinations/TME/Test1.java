package Examinations.TME;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int cnt0 = 0, cnt1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                cnt1++;
                i++;
            }
        }
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '1') {
                cnt0++;
                i++;
            }
        }
        System.out.println(Math.min(cnt0, cnt1));
    }
}
