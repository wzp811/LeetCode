package Tags._String;

public class No459_RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        return kmp(s + s, s);
    }

    public int[] getNextArray(char[] match) {
        if (match.length == 1) return new int[]{-1};
        int[] next = new int[match.length];
        int i = 2;
        int x = 0;
        while (i < match.length) {
            if (match[i - 1] == match[x]) {
                next[i++] = ++x;
            } else if (x > 0) {
                x = next[x];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public boolean kmp(String str, String match) {
        char[] pattern = match.toCharArray();
        int[] next = getNextArray(pattern);
        int i = 1, j = 0;
        while (i < str.length() - 1 && j < match.length()) {
            if (str.charAt(i) == match.charAt(j)) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j];
            }
        }
        return j == match.length();
    }
}
