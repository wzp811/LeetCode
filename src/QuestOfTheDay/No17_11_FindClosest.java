package QuestOfTheDay;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class No17_11_FindClosest {
    public int findClosest(String[] words, String word1, String word2) {
        int res = words.length;
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            List<Integer> list = map.getOrDefault(word, new LinkedList<>());
            list.add(i);
            map.put(word, list);
            String other = "";
            if (word.equals(word1)) other = word2;
            if (word.equals(word2)) other = word1;
            if (!map.containsKey(other)) continue;
            List<Integer> otherList = map.get(other);
            res = Math.min(i - otherList.get(otherList.size() - 1), res);
        }
        return res;
    }
}
