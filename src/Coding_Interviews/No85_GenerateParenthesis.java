package Coding_Interviews;

import java.util.LinkedList;
import java.util.List;

public class No85_GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        process(res, sb, n, n);
        return res;
    }

    public void process(List<String> res, StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(new String(sb));
            return;
        }
        if (left > 0) {
            sb.append('(');
            process(res, sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left) {
            sb.append(')');
            process(res, sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
