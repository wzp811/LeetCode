package QuestionList.Coding_Interviews;

import java.util.HashSet;

public class No65_MinimumLengthEncoding {
    public int minimumLengthEncoding(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                if (set.contains(word.substring(i))) {
                    set.remove(word.substring(i));
                }
            }
        }
        int length = 0;
        for (String word : set) {
            length += word.length();
        }
        length += set.size() - 1;
        return length;
    }
}
