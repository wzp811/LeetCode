package Coding_Interviews;

public class No118_FindRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] father = new int[n];
        for (int i = 0; i < n; i++) father[i] = i;
        for (int i = 0; i < edges.length; i++) {
            if (find(father, edges[i][0]) == find(father, edges[i][1])) {
                return edges[i];
            } else {
                union(father, edges[i][0], edges[i][1]);
            }
        }
        return new int[0];
    }

    public void union(int[] father, int i, int j) {
        father[find(father, i)] = find(father, j);
    }

    public int find(int[] father, int i) {
        if (father[i] != i) {
            father[i] = find(father, father[i]);
        }
        return father[i];
    }
}
