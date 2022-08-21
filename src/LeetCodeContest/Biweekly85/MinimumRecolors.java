package LeetCodeContest.Biweekly85;

public class MinimumRecolors {
    public int minimumRecolors(String blocks, int k) {
        int left = 0;
        int right = k;
        int cur = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') cur++;
        }
        int min = cur;
        while (right < blocks.length()) {
            if (blocks.charAt(left++) == 'W') cur--;
            if (blocks.charAt(right++) == 'W') cur++;
            min = Math.min(min, cur);
        }
        return min;
    }
}
