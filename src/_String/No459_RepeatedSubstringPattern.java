package _String;

public class No459_RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() % 2 != 0) return false;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() / 2 + i)) return false;
        }
        return true;
    }
}
