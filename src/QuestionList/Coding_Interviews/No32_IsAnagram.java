package QuestionList.Coding_Interviews;

public class No32_IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) return false;
        int[] cnt = new int[26];
        int rest = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = cnt[s.charAt(i) - 'a']++;
            if (count == 0) rest++;
        }
        for (int i = 0; i < t.length(); i++) {
            int count = cnt[t.charAt(i) - 'a']--;
            if (count == 1) rest--;
        }
        return rest == 0;
    }
}
