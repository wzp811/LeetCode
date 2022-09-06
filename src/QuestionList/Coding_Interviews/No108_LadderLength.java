package QuestionList.Coding_Interviews;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No108_LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        String[] nextWords = new String[wordList.size() + 1];
        for (int i = 0; i < wordList.size(); i++) nextWords[i + 1] = wordList.get(i);
        nextWords[0] = beginWord;
        boolean[][] matrix = new boolean[wordList.size() + 1][wordList.size() + 1];
        for (int i = 0; i < nextWords.length; i++) {
            for (int j = 0; j < nextWords.length; j++) {
                if (i == j) continue;
                int cnt = 0;
                for (int k = 0; k < len; k++) {
                    if (nextWords[i].charAt(k) != nextWords[j].charAt(k)) cnt++;
                    if (cnt > 1) break;
                }
                if (cnt == 1) matrix[i][j] = true;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[nextWords.length];
        queue.add(0);
        visited[0] = true;
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                for (int j = 0; j < nextWords.length; j++) {
                    if (matrix[index][j] && !visited[j]) {
                        visited[j] = true;
                        queue.add(j);
                        if (nextWords[j].equals(endWord)) return res;
                    }
                }
            }
        }
        return 0;
    }
}
