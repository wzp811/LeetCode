package Coding_Interviews;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No106_IsBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int flag = 1;
        visited[0] = 1;
        int cnt = 1;
        while (!queue.isEmpty() || cnt != graph.length) {
            if (queue.isEmpty()) {
                for (int i = 0; i < graph.length; i++) {
                    if (visited[i] == 0) {
                        queue.add(i);
                        visited[i] = flag;
                        cnt++;
                        break;
                    }
                }
            }
            int size = queue.size();
            flag = -flag;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 0; j < graph[cur].length; j++) {
                    if (visited[graph[cur][j]] == 0) {
                        visited[graph[cur][j]] = flag;
                        queue.add(graph[cur][j]);
                        cnt++;
                    } else {
                        if (visited[graph[cur][j]] != flag) return false;
                    }
                }
            }
        }
        return true;
    }
}
