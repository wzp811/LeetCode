package QuestOfTheDay;

import java.util.HashSet;
import java.util.Set;

public class No804_UniqueMorseRepresentations {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{
                ".-", "-...", "-.-.", "-..", ".", "..-.",
                "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(morse[word.charAt(i) - 'a']);
            }
            set.add(new String(sb));
        }
        return set.size();
    }
}
