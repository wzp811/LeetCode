package Y2022.Y2022_July;

public class MagicDictionary {

    class Trie {
        Trie[] children;
        boolean end;
        Trie() {
            end = false;
            children = new Trie[26];
        }
    }

    Trie root;

    public MagicDictionary() {
        root = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Trie cur = root;
            for (int i = 0; i < word.length(); i++) {
                if (cur.children[word.charAt(i) - 'a'] == null) cur.children[word.charAt(i) - 'a'] = new Trie();
                cur = cur.children[word.charAt(i) - 'a'];
            }
            cur.end = true;
        }
    }

    public boolean search(String searchWord) {
        Trie node = root;
        return dfs(searchWord, 0, node, false);
    }

    public boolean dfs(String word, int index, Trie node, boolean hasTrans){
        if (index == word.length()) return hasTrans;
        if (hasTrans) {
            return node.children[word.charAt(index) - 'a'] != null && dfs(word, index + 1, node.children[word.charAt(index) - 'a'], hasTrans);
        } else {
            boolean res = false;
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    res |= dfs(word, index + 1, node.children[i], word.charAt(index) - 'a' == i ? false : true);
                }
            }
            return res;
        }
    }

}
