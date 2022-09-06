package QuestionList.QuestOfTheDay;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No433_MinMutation {
    public int minMutation(String start, String end, String[] bank) {
        String[] strs = new String[bank.length + 2];
        strs[0] = start;
        strs[strs.length - 1] = end;
        for (int i = 0; i < bank.length; i++) strs[i + 1] = bank[i];
        boolean[][] matrix = new boolean[bank.length + 2][bank.length + 2];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                int cnt = 0;
                for (int k = 0; k < 8; k++) {
                    if (strs[i].charAt(k) != strs[j].charAt(k)) {
                        cnt++;
                    }
                }
                if (cnt == 1) matrix[i][j] = true;
                else matrix[i][j] = false;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[strs.length];
        Arrays.fill(visited, false);
        visited[0] = true;
        queue.add(0);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cnt == strs.length - 1) return cnt - 1;
                for (int j = 0; j < strs.length; j++) {
                    if (matrix[cur][j] && cur != j && !visited[j]) {
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
            cnt++;
        }
        return cnt - 1;
    }
}
