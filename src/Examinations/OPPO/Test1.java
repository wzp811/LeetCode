package Examinations.OPPO;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int q = input.nextInt();
        input.nextLine();
        while (q-- > 0) {
            String s = input.nextLine();
            String t = input.nextLine();
            boolean ret = true;
            if (s.length() != t.length()) {
                ret = false;
            } else {
                int cnt = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != t.charAt(i)) {
                        cnt++;
                        if (cnt > 2) {
                            ret = false;
                            break;
                        }
                        if (cnt == 2) {
                            if (!(s.charAt(i) == t.charAt(i - 1) && s.charAt(i - 1) == t.charAt(i))) {
                                ret = false;
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println(ret ? "Yes" : "No");
        }
    }
}
