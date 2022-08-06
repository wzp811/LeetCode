package Y2022.Y2022_August;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class No1408_StringMatching {

    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                if (words[j].indexOf(words[i]) >= 0) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}
