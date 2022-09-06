package Tags._Sort;

import java.util.Arrays;

public class No242_IsAnagram {
    public boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) if (ss[i] != tt[i]) return false;
        return true;
    }
}
