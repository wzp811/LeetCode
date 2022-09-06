package QuestionList.Coding_Interviews;

public class MagicDictionary {
    class Node {
        boolean end;
        Node[] child;
        Node() {
            end = false;
            child = new Node[26];
            for (int i = 0; i < 26; i++) child[i] = null;
        }
    }
    Node root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new Node();
    }

    public void buildDict(String[] dictionary) {
        for (String word: dictionary) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (cur.child[index] == null) cur.child[index] = new Node();
                cur = cur.child[index];
            }
            cur.end = true;
        }
    }

    public boolean search(String searchWord) {
        return process(searchWord, 0, false, root);
    }
    public boolean process(String searchWord, int index, boolean hasChange, Node cur) {
        if (index == searchWord.length()) return cur != null && cur.end && hasChange;
        if (cur == null) return false;
        int digit = searchWord.charAt(index) - 'a';
        if (hasChange) {
            return process(searchWord, index + 1, true, cur.child[digit]);
        } else {
            for (int i = 0; i < 26; i++) {
                if (process(searchWord, index + 1, i != digit, cur.child[i])) return true;
            }
        }
        return false;
    }
}
