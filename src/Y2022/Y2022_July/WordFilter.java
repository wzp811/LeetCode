package Y2022.Y2022_July;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class WordFilter {

    class Trie {
        Trie[] children;
        int endIndex;
        Trie() {
            children = new Trie[26];
            endIndex = -1;
        }
    }

    Trie positive, negative;

    public WordFilter(String[] words) {
        positive = new Trie();
        negative = new Trie();
        for (int j = 0; j < words.length; j++) {
            String word = words[j];
            Trie cur = positive;
            for (int i = 0; i < word.length(); i++) {
                if (cur.children[word.charAt(i) - 'a'] == null) cur.children[word.charAt(i) - 'a'] = new Trie();
                cur = cur.children[word.charAt(i) - 'a'];
            }
            cur.endIndex = j;
            cur = negative;
            for (int i = word.length() - 1; i >= 0; i--) {
                if (cur.children[word.charAt(i) - 'a'] == null) cur.children[word.charAt(i) - 'a'] = new Trie();
                cur = cur.children[word.charAt(i) - 'a'];
            }
            cur.endIndex = j;
        }

    }

    public int f(String pref, String suff) {
        int res = -1;
        Set<Integer> set = new HashSet<>();
        Trie cur = positive;
        for (int i = 0; i < pref.length(); i++) {
            if (cur.children[pref.charAt(i) - 'a'] == null) return -1;
            cur = cur.children[pref.charAt(i) - 'a'];
        }
        Deque<Trie> queue = new ArrayDeque<>();
        queue.addLast(cur);
        while (!queue.isEmpty()) {
            Trie node = queue.pollLast();
            if (node.endIndex != -1) set.add(node.endIndex);
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    queue.addLast(node.children[i]);
                }
            }
        }
        cur = negative;
        for (int i = suff.length() - 1; i >= 0; i--) {
            if (cur.children[suff.charAt(i) - 'a'] == null) return -1;
            cur = cur.children[suff.charAt(i) - 'a'];
        }
        queue.addLast(cur);
        while (!queue.isEmpty()) {
            Trie node = queue.pollLast();
            if (node.endIndex != -1 && set.contains(node.endIndex)) res = Math.max(res, node.endIndex);
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    queue.addLast(node.children[i]);
                }
            }
        }
        return res;
    }

}
