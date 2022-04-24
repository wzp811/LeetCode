package Coding_Interviews;

public class MapSum {
    class Node {
        boolean end;
        Node[] child;
        int val;
        Node () {
            end = false;
            child = new Node[26];
            val = 0;
        }
    }
    Node root;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (cur.child[index] == null) cur.child[index] = new Node();
            cur = cur.child[index];
        }
        cur.end = true;
        cur.val = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (cur.child[index] == null) return 0;
            cur = cur.child[index];
        }
        return process(cur);
    }
    public int process(Node root) {
        int sum = 0;
        if (root.end) sum = root.val;
        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null) sum += process(root.child[i]);
        }
        return sum;
    }
}
