package Coding_Interviews;

public class No14_CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] cnt = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            cnt[s1.charAt(i) - 'a']++;
        }
        int i = 0, j = 0;
        int rest = 0;
        for (int c : cnt) if (c != 0) rest++;
        for (; j < s1.length(); j++) {
            int cur = s2.charAt(j) - 'a';
            if (cnt[cur] == 0) rest++;
            cnt[cur]--;
            if (cnt[cur] == 0) rest--;
        }
        j--;
        if (rest == 0) return true;
        while (j < s2.length() - 1) {
            int leftChar = s2.charAt(i) - 'a';
            int rightChar = s2.charAt(j + 1) - 'a';
            if (cnt[leftChar] == 0) rest++;
            cnt[leftChar]++;
            if (cnt[leftChar] == 0) rest--;
            if (cnt[rightChar] == 0) rest++;
            cnt[rightChar]--;
            if (cnt[rightChar] == 0) rest--;
            if (rest == 0) return true;
            i++;
            j++;
        }
        return false;
    }
}
