package Y2022.Y2022_September;

import java.util.ArrayList;
import java.util.List;

public class No1592_ReorderSpaces {
    public String reorderSpaces(String text) {
        List<String> words = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        int cntSpaces = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (cur.length() > 0) {
                    words.add(cur.toString());
                    cur.setLength(0);
                }
                cntSpaces++;
            } else {
                cur.append(text.charAt(i));
            }
        }
        if (cur.length() > 0) words.add(cur.toString());
        cur.setLength(0);
        if (words.size() <= 1) {
            for (String word : words) cur.append(word);
            for (int i = 0; i < cntSpaces; i++) cur.append(' ');
        } else {
            cur.append(words.get(0));
            for (int i = 1; i < words.size(); i++) {
                for (int j = 0; j < cntSpaces / (words.size() - 1); j++) cur.append(' ');
                cur.append(words.get(i));
            }
            for (int i = 0; i < cntSpaces % (words.size() - 1); i++) cur.append(' ');
        }
        return cur.toString();
    }
}
