package QuestionList.QuestOfTheDay;

public class No467_FindSubstringInWraproundString {
    public int findSubstringInWraproundString(String p) {
        int res = 0;
        int cur = 0;
        int[] dp = new int[26];
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) == 'a' && p.charAt(i - 1) == 'z' || p.charAt(i) == p.charAt(i - 1) + 1)) {
                cur++;
            } else {
                cur = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], cur);
        }
        for (int i = 0; i < 26; i++) res += dp[i];
        return res;
    }
}
