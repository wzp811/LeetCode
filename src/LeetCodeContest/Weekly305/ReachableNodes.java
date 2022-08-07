package LeetCodeContest.Weekly305;

import java.util.*;

public class ReachableNodes {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        int res = 1;
        Set<Integer> set = new HashSet<>();
        for (int r : restricted) set.add(r);
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            map.put(edge[0], list);
            list = map.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[0]);
            map.put(edge[1], list);
        }
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(0);
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.pollFirst();
                List<Integer> list = map.get(cur);
                for (int j : list) {
                    if (!visited[j] && !set.contains(j)) {
                        visited[j] = true;
                        queue.addLast(j);
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
