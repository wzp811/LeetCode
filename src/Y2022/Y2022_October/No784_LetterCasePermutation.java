package Y2022.Y2022_October;

import java.util.ArrayList;
import java.util.List;

public class No784_LetterCasePermutation {
    List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        StringBuilder sb = new StringBuilder();
        dfs(sb, s, 0);
        return res;
    }

    public void dfs(StringBuilder sb, String s, int index) {
        if (index == s.length()) {
            res.add(new String(sb));
            return;
        }
        if (!Character.isLetter(s.charAt(index))) {
            sb.append(s.charAt(index));
            dfs(sb, s, index + 1);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        sb.append(Character.toUpperCase(s.charAt(index)));
        dfs(sb, s, index + 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(Character.toLowerCase(s.charAt(index)));
        dfs(sb, s, index + 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}
