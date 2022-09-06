package QuestionList.Coding_Interviews;

import java.util.ArrayList;
import java.util.List;

public class No87_RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        process(res, cur, 0, 4, s);
        return res;
    }

    public void process(List<String> res, StringBuilder cur, int index, int rest, String s) {
        if (index == s.length() || rest == 0) {
            if (index == s.length() && rest == 0) {
                res.add(new String(cur.deleteCharAt(cur.length() - 1)));
                cur.append('.');
            }
            return;
        }
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
        for (int i = 0; i < 3 && i + index < s.length(); i++) {
            num *= 10;
            num += s.charAt(i + index) - '0';
            cnt++;
            cur.append(s.charAt(i + index));
            if (num <= 255) {
                cur.append('.');
                process(res, cur, i + index + 1, rest - 1, s);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
        for (int i = 0; i < cnt; i++) cur.deleteCharAt(cur.length() - 1);
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
