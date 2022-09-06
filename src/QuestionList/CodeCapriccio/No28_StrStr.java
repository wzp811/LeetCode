package QuestionList.CodeCapriccio;

public class No28_StrStr {
    public int strStr(String haystack, String needle) {
        return getIndexOf(haystack, needle);
    }

    public int getIndexOf(String str, String match) {
        if (str.length() < match.length() || match.length() < 1) return -1;
        int[] next = getNextArray(match);
        int x = 0, y = 0;
        while (x < str.length() && y < match.length()) {
            if (str.charAt(x) == match.charAt(y)) {
                x++;
                y++;
            } else if (next[y] == -1) {
                x++;
            } else {
                y = next[y];
            }
        }
        return y == match.length() ? x - y : -1;

    }

    public int[] getNextArray(String match) {
        if (match.length() == 1) return new int[]{-1};
        int[] next = new int[match.length()];
        next[0] = -1;
        next[1] = 0;
        int i = 2, x = 0;
        while (i < match.length()) {
            if (match.charAt(i - 1) == match.charAt(x)) {
                next[i++] = ++x;
            } else if (x > 0) {
                x = next[x];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
