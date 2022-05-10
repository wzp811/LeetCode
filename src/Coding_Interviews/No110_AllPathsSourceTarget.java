package Coding_Interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No110_AllPathsSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        process(res, cur, graph, visited, 0);
        return res;
    }

    public void process(List<List<Integer>> res, List<Integer> cur, int[][] graph, boolean[] visited, int index) {
        for (int i = 0; i < graph[index].length; i++) {
            int nextIndex = graph[index][i];
            if (!visited[nextIndex]) {
                cur.add(nextIndex);
                if (nextIndex == graph.length - 1) {
                    res.add(new ArrayList<>(cur));
                    return;
                }
                process(res, cur, graph, visited, nextIndex);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
