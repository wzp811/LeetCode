package Coding_Interviews;

import java.util.HashMap;

public class No17_MinWindow {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        String ans = new String(s + s);
        HashMap<Character, Integer> map = new HashMap<>();
        int rest = 0;
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
            if (map.get(t.charAt(i)) == 1) rest++;
        }
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) rest--;
            }
            if (rest == 0 && ans.length() > i - j + 1) {
                ans = s.substring(j, i + 1);
            }
            while (rest == 0) {
                if (map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                    if (map.get(s.charAt(j)) == 1) rest++;
                }
                j++;
                if (rest == 0 && ans.length() > i - j + 1) {
                    ans = s.substring(j, i + 1);
                }
            }
        }
        return ans.equals(s + s) ? "" : ans;
    }
}
