package QuestOfTheDay;

import java.util.*;

public class No310_FindMinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Set<Integer>[] adj = new Set[n];
        List<Integer> ans = new ArrayList<>();
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) adj[i] = new HashSet<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        int remainNodes = n;
        boolean[] visited = new boolean[n];
        while (remainNodes > 2) {
            int[] tmpDegree = degree.clone();
            for (int i = 0; i < n; i++) {
                if (degree[i] == 1) {
                    int node = adj[i].iterator().next();
                    tmpDegree[i]--;
                    tmpDegree[node]--;
                    adj[i].remove(node);
                    adj[node].remove(i);
                    visited[i] = true;
                    remainNodes--;
                }
            }
            System.arraycopy(tmpDegree, 0, degree, 0, n);
            for (int i = 0; i < n; i++) {
                System.out.println(adj[i]);
            }
            System.out.println(Arrays.toString(degree));
            System.out.println(Arrays.toString(visited));
            System.out.println();
        }
        for (int i = 0; i < n; i++) if (!visited[i]) ans.add(i);
        return ans;
    }
}
