package QuestOfTheDay;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

public class No819_MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < banned.length; i++) {
            set.add(banned[i]);
        }
        String res = "";
        int max = 0;
        for (int i = 0; i <= paragraph.length(); i++) {
            if (i == paragraph.length() || !Character.isLetter(paragraph.charAt(i))) {
                if (sb.length() != 0) {
                    String cur = new String(sb).toLowerCase();
                    sb = new StringBuilder();
                    if (set.contains(cur)) continue;
                    int cnt = map.getOrDefault(cur, 0) + 1;
                    if (max < cnt) {
                        max = cnt;
                        res = cur;
                    }
                    map.put(cur, cnt);
                }
            } else {
                sb.append(paragraph.charAt(i));
            }
        }
        return res;
    }
}
