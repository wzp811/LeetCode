package Y2022_July;

import java.util.Arrays;

public class No899_OrderlyQueue {
    public String orderlyQueue(String s, int k) {
        char[] chs = s.toCharArray();
        int n = s.length();
        if (k > 1) {
            Arrays.sort(chs);
            return String.valueOf(chs);
        } else {
            int i = 0, j = 1, p = 0;
            while (i < n && j < n && p < n) {
                char a = chs[(i + p) % n], b = chs[(j + p) % n];
                if (a == b) p++;
                else {
                    if (a > b) i += p + 1;
                    else j += p + 1;
                    if (i == j) i++;
                    p = 0;
                }
            }
            i = Math.min(i, j);
            return s.substring(i) + s.substring(0, i);
        }
    }
}
