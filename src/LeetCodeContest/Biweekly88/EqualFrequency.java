package LeetCodeContest.Biweekly88;

import java.util.Arrays;

public class EqualFrequency {
    public boolean equalFrequency(String word) {
        int[] cnt = new int[26];
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            cnt[index]++;
        }
        Arrays.sort(cnt);
        int index = 0;
        while (cnt[index] == 0) index++;
        if (index == 25) return true;
        if (cnt[index] == 1) {
            return cnt[index + 1] == cnt[25] || cnt[index] == cnt[24] && cnt[25] == cnt[24] + 1;
        } else if (cnt[25] == 1) {
            return true;
        } else {
            return cnt[index] == cnt[24] && cnt[25] == cnt[24] + 1;
        }
    }
}
