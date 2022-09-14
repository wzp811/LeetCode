package Examinations.Baidu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test1 {
    static boolean[] letters = new boolean[26];

    public static void main(String[] args) {
        letters[0] = true;
        letters['e' - 'a'] = true;
        letters['i' - 'a'] = true;
        letters['o' - 'a'] = true;
        letters['u' - 'a'] = true;
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int cnt = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i <= s.length() - 5; i++) {
            if (allDiff(chs, i) && isBaidu(chs, i)) cnt++;
        }
        System.out.println(cnt);
    }

    public static boolean allDiff(char[] chs, int index) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 5; i++) set.add(chs[index + i]);
        return set.size() == 5;
    }

    public static boolean isBaidu(char[] chs, int index) {
        return letters[chs[index + 1] - 'a'] && letters[chs[index + 2] - 'a'] && letters[chs[index + 4] - 'a']
                && !letters[chs[index] - 'a'] && !letters[chs[index + 3] - 'a'];
    }

}
