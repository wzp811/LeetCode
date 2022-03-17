package QuestOfTheDay;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class No720_LongestWord {
    public String longestWord(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()) return o2.compareTo(o1);
                return o1.length()-o2.length();
            }
        });
        Set<String> set = new HashSet<>();
        String ans = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 1) {
                set.add(words[i]);
                ans = words[i];
            }
            else {
                if(set.contains(words[i].substring(0,words[i].length()-1))){
                    set.add(words[i]);
                    ans = words[i];
                }
            }
        }
        return ans;
    }
}
