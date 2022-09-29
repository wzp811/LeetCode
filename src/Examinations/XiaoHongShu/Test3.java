package Examinations.XiaoHongShu;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        int[][] matrix = new int[n + 1][n + 1];
        int[] tmp = new int[n];
        for (int i = 1; i <= n - 1; i++) {
            tmp[i] = input.nextInt();
        }
        input.nextLine();
        for (int i = 1; i <= n - 1; i++) {
            int len = input.nextInt();
            matrix[i + 1][tmp[i]] = len;
            matrix[tmp[i]][i + 1] = len;
        }
        input.nextLine();
        int[] distances = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < 3; i++) {
            int location = input.nextInt();
            Arrays.fill(visited, false);
            Deque<int[]> queue = new ArrayDeque<>();
            queue.addLast(new int[]{location, 0});
            visited[location] = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int[] cur = queue.pollFirst();
                    for (int p = 1; p <= n; p++) {
                        if (matrix[cur[0]][p] == 0 || visited[p]) continue;
                        visited[p] = true;
                        queue.addLast(new int[]{p, cur[1] + matrix[cur[0]][p]});
                        distances[p] += cur[1] + matrix[cur[0]][p];
                    }
                }
            }
        }
        distances[0] = Integer.MAX_VALUE;
        System.out.println(Arrays.stream(distances).min().getAsInt());
    }
}
