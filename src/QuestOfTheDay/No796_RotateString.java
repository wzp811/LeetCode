package QuestOfTheDay;

public class No796_RotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String ss = s + s;
        int[] next = getNextArray(goal);
        int i = 0, j = 0;
        while (i < ss.length() && j < goal.length()) {
            if (ss.charAt(i) == goal.charAt(j)) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j];
            }
        }
        return j == goal.length();
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
