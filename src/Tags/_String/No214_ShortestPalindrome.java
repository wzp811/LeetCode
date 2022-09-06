package Tags._String;

public class No214_ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s.length() < 2) return s;
        char[] match = new char[s.length() * 2 + 1];
        for (int i = 0; i < s.length() * 2; i++) {
            match[i] = s.charAt(i);
            match[s.length() * 2 - i] = s.charAt(i);
        }
        match[s.length()] = '#';
        int[] next = getNextArray(match);
        int maxLen = next[2 * s.length() + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - maxLen; i++) {
            sb.append(match[s.length() + 1 + i]);
        }
        sb.append(s);
        return sb.toString();
    }

    public int[] getNextArray(char[] match) {
        int[] next = new int[match.length + 1];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int x = 0;
        while (i <= match.length) {
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

    public static void main(String[] args) {
        No214_ShortestPalindrome obj = new No214_ShortestPalindrome();
        System.out.println(obj.shortestPalindrome("adcba"));
    }
}
