package Coding_Interviews;

import java.util.LinkedList;
import java.util.List;

public class No87_RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        StringBuilder cur = new StringBuilder();
        process(s, res, cur, 0, 4);
        return res;
    }

    public void process(String s, List<String> res, StringBuilder cur, int index, int rest) {
        if (index == s.length() || rest == 0) {
            if (rest == 0 && index == s.length()) res.add(new String(cur));
            return;
        }
        int num = 0;
        if (s.charAt(index) == '0') {
            cur.append('0');
            cur.append('.');
            process(s, res, cur, index + 1, rest - 1);
            cur.deleteCharAt(cur.length() - 1);
            cur.deleteCharAt(cur.length() - 1);
            return;
        }
        for (int i = index; i < s.length(); i++) {
            num *= 10;
            num += s.charAt(i) - '0';
            if (num > 255) return;
            cur.append(s.charAt(i));
            if (num >= 0 && num <= 255) {
                cur.append('.');
                process(s, res, cur, i + 1, rest - 1);
                cur.deleteCharAt(cur.length() - 1);
            }
            num /= 10;
        }
    }
}
