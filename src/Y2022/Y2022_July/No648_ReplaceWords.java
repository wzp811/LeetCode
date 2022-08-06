package Y2022.Y2022_July;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No648_ReplaceWords {
    public String replaceWords1(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            int len = words[i].length();
            for (String dict : dictionary) {
                if (words[i].startsWith(dict) && dict.length() < len) {
                    len = dict.length();
                    words[i] = dict;
                }
            }
        }
        StringBuilder res = new StringBuilder(words[0]);
        for (int i = 1; i < words.length; i++) {
            res.append(" ");
            res.append(words[i]);
        }
        return new String(res);
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (set.contains(words[i].substring(0, j + 1))) {
                    words[i] = words[i].substring(0, j + 1);
                    break;
                }
            }
        }
        StringBuilder res = new StringBuilder(words[0]);
        for (int i = 1; i < words.length; i++) {
            res.append(" ");
            res.append(words[i]);
        }
        return new String(res);
    }
}
