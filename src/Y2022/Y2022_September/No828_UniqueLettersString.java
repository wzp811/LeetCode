package Y2022.Y2022_September;

import java.util.*;

public class No828_UniqueLettersString {
    public int uniqueLettersString(String s) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
                map.get(key).add(-1);
            }
            map.get(key).add(i);
        }
        int res = 0;
        for (Character key : map.keySet()) {
            map.get(key).add(s.length());
            List<Integer> list = map.get(key);
            for (int i = 1; i < list.size() - 1; i++) {
                res += (list.get(i) - list.get(i - 1)) * (list.get(i + 1) - list.get(i));
            }
        }
        return res;
    }
}
