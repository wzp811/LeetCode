package Y2022.Y2022_November;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No1684_CountConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        int count = 0;
        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (!set.contains(word.charAt(i))) {
                    flag = false;
                    break;
                }
            }
            count += flag ? 1 : 0;
        }
        return count;
    }
}
