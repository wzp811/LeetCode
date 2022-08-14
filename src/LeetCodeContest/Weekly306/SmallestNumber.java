package LeetCodeContest.Weekly306;

public class SmallestNumber {
    public String smallestNumber(String pattern) {
        int n = pattern.length() + 1;
        int[] res = new int[n];
        int[] rightDownTimes = new int[n];
        int cnt = 0;
        for (int i = n - 1; i >= 1; i--) {
            if (pattern.charAt(i - 1) == 'D') cnt++;
            else {
                rightDownTimes[i] = cnt;
                cnt = 0;
            }
        }
        rightDownTimes[0] = cnt;
        int cur = 1;
        int max = 0;
        res[0] = 1 + rightDownTimes[0];
        if (pattern.charAt(0) == 'I') res[0] = 1;
        max = res[0];
        for (int i = 1; i < n; i++) {
            if (pattern.charAt(i - 1) == 'I') {
                res[i] = Math.max(res[i - 1] + 1, max + rightDownTimes[i] + 1);
            } else {
                res[i] = res[i - 1] - 1;
            }
            max = Math.max(res[i], max);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(res[i]);
        return sb.toString();
    }
}
