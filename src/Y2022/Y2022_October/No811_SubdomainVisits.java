package Y2022.Y2022_October;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No811_SubdomainVisits {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            String[] k = domain.split(" ");
            int cnt = Integer.parseInt(k[0]);
            map.put(k[1], map.getOrDefault(k[1], 0) + cnt);
            for (int i = k[1].length() - 1; i >= 0; i--) {
                if (k[1].charAt(i) == '.') {
                    String d = k[1].substring(i + 1);
                    map.put(d, map.getOrDefault(d, 0) + cnt);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(String.valueOf(map.get(key) + " " + key));
        }
        return res;
    }
}
