package QuestionList.Coding_Interviews;

import java.util.LinkedList;
import java.util.List;

public class No15_FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new LinkedList<>();
        if (p.length() > s.length()) return ans;
        int[] cnt = new int[26];
        for (int i = 0; i < p.length(); i++) {
            cnt[p.charAt(i) - 'a']++;
        }
        int i = 0, j = 0;
        int rest = 0;
        for (int c : cnt) if (c != 0) rest++;
        for (; j < p.length(); j++) {
            int cur = s.charAt(j) - 'a';
            if (cnt[cur] == 0) rest++;
            cnt[cur]--;
            if (cnt[cur] == 0) rest--;
        }
        j--;
        if (rest == 0) ans.add(i);
        while (j < s.length() - 1) {
            int leftChar = s.charAt(i) - 'a';
            int rightChar = s.charAt(j + 1) - 'a';
            if (cnt[leftChar] == 0) rest++;
            cnt[leftChar]++;
            if (cnt[leftChar] == 0) rest--;
            if (cnt[rightChar] == 0) rest++;
            cnt[rightChar]--;
            if (cnt[rightChar] == 0) rest--;
            i++;
            j++;
            if (rest == 0) ans.add(i);
        }
        return ans;
    }
}
