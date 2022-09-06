package QuestionList.Coding_Interviews;

import java.util.*;

public class No114_AlienOrder {
    public String alienOrderShit(String[] words) {
        HashMap<Character, Set<Character>> map = new HashMap<>();
        int[] inDegree = new int[26];
        Arrays.fill(inDegree, -1);
        int index = 0;
        boolean ok = true;
        Set<Character> his = new HashSet<>();
        int resLen = 0;
        while (ok) {
            ok = false;
            his.clear();
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() > index) ok = true;
                else continue;
                if (inDegree[words[i].charAt(index) - 'a'] == -1) {
                    inDegree[words[i].charAt(index) - 'a'] = 0;
                    resLen++;
                }
                for (char last : his) {
                    Set<Character> next = map.getOrDefault(last, new HashSet<>());
                    if (next.contains(words[i].charAt(index))) continue;
                    next.add(words[i].charAt(index));
                    map.put(last, next);
                    inDegree[words[i].charAt(index) - 'a']++;
                }
            }
            index++;
        }
        StringBuilder res = new StringBuilder();
        while (res.length() < resLen) {
            ok = false;
            for (int i = 0; i < 26; i++) {
                if (inDegree[i] == 0) {
                    ok = true;
                    char curCh = (char)('a' + 1);
                    res.append(curCh);
                    inDegree[i]--;
                    Set<Character> tmpSet = map.getOrDefault(curCh, new HashSet<>());
                    for (char next : tmpSet) {
                        inDegree[next - 'a']--;
                    }
                }
            }
            if (!ok && res.length() < resLen - 1) return "";
        }
        return new String(res);
    }

    class Trie {
        char val;
        List<Trie> children;
        HashMap<Character, Integer> map;
        Trie() {
            map = new HashMap<>();
            children = new LinkedList<>();
        }
        Trie(char val) {
            map = new HashMap<>();
            children = new LinkedList<>();
            this.val = val;
        }
        @Override
        public String toString() {
            return "Trie{" +
                    "val=" + val +
                    '}';
        }
    }
    public String alienOrder(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            Trie cur = root;
            for (int i = 0; i < word.length(); i++) {
                if (!cur.map.containsKey(word.charAt(i))) {
                    cur.children.add(new Trie(word.charAt(i)));
                    cur.map.put(word.charAt(i), cur.children.size() - 1);
                } else if (cur.map.get(word.charAt(i)) != cur.children.size() - 1) return "";
                cur = cur.children.get(cur.map.get(word.charAt(i)));
            }
            if (cur.children.size() > 0) return "";
        }
        int[] inDegree = new int[26];
        int resLen = 0;
        Arrays.fill(inDegree, -1);
        Queue<Trie> queue = new LinkedList<>();
        queue.add(root);
        HashMap<Character, Set<Character>> map = new HashMap<>();
        Set<Character> lasts = new HashSet<>();
        char lastCh = '0';
        while (!queue.isEmpty()) {
            lasts.clear();
            Trie cur = queue.poll();
            for (Trie next : cur.children) {
                if (lasts.contains(next.val) && next.val != lastCh) return "";
                if (lasts.contains(next.val)) continue;
                queue.add(next);
                if (inDegree[next.val - 'a'] == -1) {
                    resLen++;
                    inDegree[next.val - 'a'] = 0;
                }
                for (char last : lasts) {
                    Set<Character> tmpSet = map.getOrDefault(last, new HashSet<>());
                    if (tmpSet.contains(next.val)) continue;
                    inDegree[next.val - 'a']++;
                    tmpSet.add(next.val);
                    map.put(last, tmpSet);
                }
                lasts.add(next.val);
            }
        }
        StringBuilder res = new StringBuilder();
        boolean ok = false;
        List<Integer> tmp = new LinkedList<>();
        while (res.length() < resLen) {
            ok = false;
            tmp.clear();
            System.out.println(Arrays.toString(inDegree));
            for (int i = 0; i < 26; i++) {
                if (inDegree[i] == 0) {
                    ok = true;
                    char curCh = (char)('a' + i);
                    res.append(curCh);
                    inDegree[i]--;
                    Set<Character> tmpSet = map.getOrDefault(curCh, new HashSet<>());
                    for (char next : tmpSet) {
                        tmp.add(next - 'a');
                    }
                }
            }
            System.out.println(res + " " + ok + " " + res.length() + " " + resLen);
            for (int index : tmp) inDegree[index]--;
            if (!ok) return "";
        }
        return new String(res);
    }
}
