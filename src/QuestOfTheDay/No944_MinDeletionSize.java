package QuestOfTheDay;

public class No944_MinDeletionSize {
    public int minDeletionSize(String[] strs) {
        int len = strs[0].length();
        int n = strs.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            char last = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (strs[j].charAt(i) < last) {
                    res++;
                    break;
                }
                last = strs[j].charAt(i);
            }
        }
        return res;
    }
}
