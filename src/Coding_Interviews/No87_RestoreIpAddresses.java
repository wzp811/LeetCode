package Coding_Interviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No87_RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        process(res, cur, 0, 4, s);
        return res;
    }

    public void process(List<String> res, StringBuilder cur, int index, int rest, String s) {
        if (index == s.length()) {
            if (rest == 0) {
                res.add(new String(cur).substring(0, cur.length() - 1));
            }
            return;
        }
        StringBuilder tmp = new StringBuilder(cur);
        if (s.charAt(index) == '0') {
            cur.append('0');
            cur.append('.');
            process(res, cur, index + 1, rest - 1, s);
            cur.deleteCharAt(cur.length() - 1);
            cur.deleteCharAt(cur.length() - 1);
            return;
        }
        int num = 0;
        int cnt = 0;
        for (int i = 0; i < 3 && index + i < s.length(); i++) {
            num *= 10;
            num += s.charAt(i + index) - '0';
            cur.append(s.charAt(index + i));
            cnt++;
            if (num <= 255 && s.length() - i - index - 1 <= rest * 3 && s.length() - i - index - 1 >= rest) {
                cur.append('.');
                process(res, cur, index + i + 1, rest - 1, s);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
        while (cnt > 0) {
            cnt--;
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        StringBuilder cur = new StringBuilder();
        cur.append("1234");
        StringBuilder tmp = new StringBuilder(cur);
        cur.deleteCharAt(cur.length() - 1);
        System.out.println(cur);
        System.out.println(tmp);
    }
}
