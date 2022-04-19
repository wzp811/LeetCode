package QuestOfTheDay;

import java.util.Arrays;

public class No821_ShortestToChar {
    public int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];
        Arrays.fill(res, s.length());
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                index = i;
                res[i] = 0;
            } else if (index != -1) {
                res[i] = i - index;
            }
        }
        index = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) index = i;
            else if (index != s.length()) res[i] = Math.min(res[i], index - i);
        }
        return res;
    }
}
