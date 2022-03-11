package Hot100;

public class Trie {
    public class Node{
        boolean end = false;
        Node[] next = new Node[26];
    }
    Node head;
    public Trie() {
        head = new Node();
    }

    public void insert(String word) {
        Node cur = head;
        for(int i=0;i<word.length();i++){
            cur.next[word.charAt(i)-'a'] = new Node();
            cur = cur.next[word.charAt(i)-'a'];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        Node cur = head;
        for(int i=0;i<word.length();i++){
            if(cur.next[word.charAt(i)-'a']==null) return false;
            else cur = cur.next[word.charAt(i)-'a'];
        }
        return cur.end;
    }

    public boolean startsWith(String prefix) {
        Node cur = head;
        for(int i=0;i<prefix.length();i++){
            if(cur.next[prefix.charAt(i)-'a']==null) return false;
            else cur = cur.next[prefix.charAt(i)-'a'];
        }
        return true;
    }
}
