package Examinations.ZhongXinBank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        StringBuilder res = new StringBuilder();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                res.append(Character.toLowerCase(s.charAt(i)));
            } else {
                res.append(Character.toUpperCase(s.charAt(i)));
            }
        }
        System.out.println(new String(res));
    }
}
