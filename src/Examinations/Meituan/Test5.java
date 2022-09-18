package Examinations.Meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n - 1; i++)
                a[i] = input.nextInt();
            for (int i = 0; i < n - 1; i++)
                b[i] = input.nextInt();
            int[] v = new int[n + 1];
            for (int i = 1; i <= n; i++)
                v[i] = input.nextInt();
            boolean[][] matrix = new boolean[n + 1][n + 1];
            for (int i = 0; i < n - 1; i++) {
                matrix[a[i]][b[i]] = true;
                matrix[b[i]][a[i]] = true;
            }
            boolean[] visited = new boolean[n + 1];
            for (int i = 1; i < matrix.length; i++) {
                visited[i] = true;
                if (dfs(matrix, v, visited, i) != -1) {
                    System.out.println(i);
                    break;
                }
                visited[i] = false;
            }
        }
    }

    public static int dfs(boolean[][] matrix, int[] v, boolean[] visited, int cur) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[cur][i] && !visited[i]) {
                if (v[i] >= v[cur]) return -1;
                list.add(i);
            }
        }
        for (int next : list) {
            visited[next] = true;
            if (dfs(matrix, v, visited, next) == -1) return -1;
            visited[next] = false;
        }
        return 0;
    }

}
