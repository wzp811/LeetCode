package LeetCodeContest.Weekly312;

import java.util.*;

public class NumberOfGoodPaths {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int res = vals.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < vals.length; i++) {
            List<Integer> list = map.getOrDefault(vals[i], new ArrayList<>());
            list.add(i);
            map.put(vals[i], list);
        }
        boolean[][] matrix = new boolean[vals.length][vals.length];
        for (int i = 0; i < edges.length; i++) {
            matrix[edges[i][0]][edges[i][1]] = true;
            matrix[edges[i][1]][edges[i][0]] = true;
        }
        boolean[] visited = new boolean[vals.length];
        for (int key : map.keySet()) {
            if (map.get(key).size() < 2) continue;
            List<Integer> list = map.get(key);
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    boolean ret = true;
                    Arrays.fill(visited, false);
                    int a = list.get(i);
                    visited[a] = true;
                    int b = list.get(j);
                    Deque<Integer> queue = new ArrayDeque<>();
                    queue.addLast(a);
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int cur = queue.pollFirst();
                            for (int p = 0; p < vals.length; p++){
                                if (visited[p] || !matrix[cur][p]) continue;
                                visited[p] = true;
                                if (vals[p] > key) {
                                    break;
                                }
                                queue.addLast(p);
                                if (p == b) {
                                    res++;
                                    ret = false;
                                    break;
                                }
                            }
                            if (!ret) break;
                        }
                        if (!ret) break;
                    }
                }
            }
        }
        return res;
    }
}
