package Coding_Interviews;

public class Trie {
    class Node{
        Node[] child;
        boolean end = false;
        Node() {
            child = new Node[26];
            for (int i = 0; i < 26; i++) child[i] = null;
        }
    }
    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.child[index] == null) cur.child[index] = new Node();
            cur = cur.child[index];
        }
        cur.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            cur = cur.child[index];
            if (cur == null) return false;
        }
        return cur.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            cur = cur.child[index];
            if (cur == null) return false;
        }
        return true;
    }
}
