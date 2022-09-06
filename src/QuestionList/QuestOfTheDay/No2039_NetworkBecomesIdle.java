package QuestionList.QuestOfTheDay;

import java.util.*;

public class No2039_NetworkBecomesIdle {
    // Shit Mountain
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length - 1;
        int[] times = new int[n + 1];
        List<Integer>[] matrix = new List[n + 1];
        for (int i = 0; i < n + 1; i++) matrix[i] = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(visited, false);
        for (int i = 0; i < edges.length; i++) {
            matrix[edges[i][0]].add(edges[i][1]);
            matrix[edges[i][1]].add(edges[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int steps = 1;
        queue.add(0);
        visited[0] = true;
        int ans = 0;
        int[] pass = new int[n + 1];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int t = 0; t < matrix[cur].size(); t++) {
                    if (!visited[matrix[cur].get(t)]) {
                        int j = matrix[cur].get(t);
                        visited[j] = true;
                        queue.add(j);
                        if (times[j] == 0) {
                            times[j] = steps;
                            if (2 * times[j] <= patience[j]) {
                                pass[j] = 2 * times[j] + 1;
                            } else {
                                int loc = (2 * times[j]) % patience[j];
                                if (loc == 0) loc = patience[j];
                                pass[j] = 2 * times[j] + (2 * times[j] - loc) + 1;
                            }
                            ans = Math.max(ans, pass[j]);
                        }
                    }
                }
            }
            steps++;
        }
        return ans;
    }
}
