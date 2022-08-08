package Y2022.Y2022_August;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No761_MakeLargestSpecial {
    public String makeLargestSpecial(String s) {
        int n = s.length();
        if (n <= 4) return s;
        int count1 = 0;
        List<String> list = new ArrayList<>();
        int pre = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '1') {
                count1++;
            } else {
                count1--;
                if (count1 == 0) {
                    list.add("1" + makeLargestSpecial(s.substring(pre + 1, i)) + "0");
                    pre = i + 1;
                }
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) sb.append(list.get(i));
        return sb.toString();
    }
}
