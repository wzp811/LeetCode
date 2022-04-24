package Coding_Interviews;

import java.util.List;

public class No63_ReplaceWords {
    class Node {
        Node[] child;
        boolean end;
        Node() {
            child = new Node[26];
            for (int i = 0; i < 26; i++) child[i] = null;
            end = false;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder res = new StringBuilder();
        String[] words = sentence.split(" ");
        Node root = new Node();
        for (String word: dictionary) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (cur.child[index] == null) cur.child[index] = new Node();
                cur = cur.child[index];
            }
            cur.end = true;
        }
        for (String word: words) {
            Node cur = root;
            boolean has = true;
            StringBuilder curWord = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (cur.child[index] == null) {
                    has = false;
                    break;
                }
                cur = cur.child[index];
                curWord.append((char)(index + 'a'));
                if (cur.end) {
                    break;
                }
            }
            if (has) res.append(curWord);
            else res.append(word);
            res.append(" ");
        }
        return new String(res).trim();
    }
}
