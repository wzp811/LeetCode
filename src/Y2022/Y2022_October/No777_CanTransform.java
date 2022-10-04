package Y2022.Y2022_October;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Locale;

public class No777_CanTransform {
    public boolean canTransform(String start, String end) {
        int cntL = 0;
        int cntR = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == end.charAt(i)) continue;
            if (end.charAt(i) == 'L') cntL++;
            else if (end.charAt(i) == 'R') cntR--;
            if (start.charAt(i) == 'L') cntL--;
            else if (start.charAt(i) == 'R') cntR++;
            if (cntL < 0 || cntR < 0) return false;
        }
        return cntL == 0 && cntR == 0;
    }

    public void swap(char[] s, int a, int b) {
        char tmp = s[a];
        s[a] = s[b];
        s[b] = tmp;
    }
}
