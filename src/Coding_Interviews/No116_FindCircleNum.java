package Coding_Interviews;

import java.util.*;

public class No116_FindCircleNum {
    public int findCircleNum1(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        int cnt = 0;
        Deque<Integer> queue = new LinkedList<>();
        queue.addLast(0);
        while (true) {
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int cur = queue.pollFirst();
                    for (int j = 0; j < n; j++) {
                        if (isConnected[cur][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            queue.addLast(j);
                        }
                    }
                }
            }
            cnt++;
            boolean done = true;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    queue.addLast(i);
                    done = false;
                    break;
                }
            }
            if (done) return cnt;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] father = new int[n];
        for (int i = 0; i < n; i++) father[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    System.out.println(i + " " + j);
                    combine(father, i, j);
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) if (father[i] == i) cnt++;
        return cnt;
    }

    public void combine(int[] father, int i, int j) {
        father[find(father, i)] = find(father, j);
    }

    public int find(int[] father, int i) {
        System.out.println(Arrays.toString(father) + " " + i + " " + father[i]);
        if (father[i] != i) {
            father[i] = find(father, father[i]);
        }
        return father[i];
    }

    public int findCircleNum2(int[][] isConnected) {
        int cities = isConnected.length;
        int[] parent = new int[cities];
        for (int i = 0; i < cities; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < cities; i++) {
            for (int j = i + 1; j < cities; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            if (parent[i] == i) {
                provinces++;
            }
        }
        return provinces;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find2(parent, index1)] = find2(parent, index2);
    }

    public int find2(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find2(parent, parent[index]);
        }
        return parent[index];
    }

    public static void main(String[] args) {
        No116_FindCircleNum obj = new No116_FindCircleNum();
        int[][] isConnected = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        System.out.println(obj.findCircleNum(isConnected));
    }
}
