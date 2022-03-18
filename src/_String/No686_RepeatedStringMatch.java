package _String;

public class No686_RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        return getIndexOf(a, b);
    }

    public int getIndexOf(String str, String match) {
        int[] next = getNextArray(match);
        int i = 0, j = 0;
        int cnt = 1;
        while (cnt < match.length() / str.length() + 3 && j < match.length()) {
            if (str.charAt(i) == match.charAt(j)) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j];
            }
            if (j == 0 && cnt > 1) return -1;
            if (i == str.length() && j < match.length()) {
                i = str.length();
                cnt++;
            }
        }
        return cnt;
    }

    public int[] getNextArray(String match) {
        if (match.length() == 1) return new int[]{-1};
        int[] next = new int[match.length()];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int x = 0;
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
