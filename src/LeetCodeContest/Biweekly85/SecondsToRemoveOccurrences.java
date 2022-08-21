package LeetCodeContest.Biweekly85;

public class SecondsToRemoveOccurrences {
    public int secondsToRemoveOccurrences(String s) {
        int max = 0;
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') left++;
            if (s.charAt(s.length() - i - 1) == '1') right++;
            if (s.charAt(i) == '1') max = Math.max(max, left);
            if (s.charAt(s.length() - i - 1) == '0') max = Math.max(max, right);
        }
        return max;
    }
    public int secondsToRemoveOccurrences2(String s) {
        int cnt0 = 0, cnt1 = 0;
        int right = 0;
        int constant = 0;
        int resConstant = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                cnt0++;
                resConstant = Math.max(resConstant, constant);
                constant = 0;
            }
            else {
                right = i;
                cnt1++;
                if (i > 0 && s.charAt(i - 1) == '1' && cnt0 > 0) constant++;
            }
        }
        return right + 1 - cnt1 + constant;
    }

    public int secondsToRemoveOccurrences3(String s) {
        char[] chs = s.toCharArray();
        int n = s.length();
        char[] tmp = new char[n];
        int times = 0;
        while (true) {
            boolean hasSwap = false;
            for (int i = 0; i < n; i++) {
                if (i < n - 1 && chs[i] == '0' && chs[i + 1] == '1') {
                    tmp[i] = '1';
                    tmp[i + 1] = '0';
                    i++;
                    hasSwap = true;
                } else {
                    tmp[i] = chs[i];
                }
            }
            if (!hasSwap) break;
            for (int i = 0; i < n; i++) chs[i] = tmp[i];
            times++;
        }
        return times;
    }
}
