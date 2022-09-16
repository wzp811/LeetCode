package Examinations.QiAnXin;

public class Test2 {

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int res = Integer.MAX_VALUE;

    public int getMinLen(int[][] points) {
        // write code here
        int n = points.length;
        boolean[][] matrix = new boolean[100][100];
        boolean[][] visited = new boolean[100][100];
        for (int i = 0; i < n; i++) {
            matrix[points[i][0]][points[i][1]] = true;
        }
        dfs(matrix, visited, 0, 0, n, 0);
        return res;
    }

    public void dfs(boolean[][] matrix, boolean[][] visited, int curI, int curJ, int rest, int steps) {
        System.out.println(curI + " " + curJ + " " + rest + " " + steps);
        boolean last = matrix[curI][curJ];
        if (matrix[curI][curJ]) {
            rest--;
            if (rest == 0) {
                res = Math.min(steps, res);
                return;
            }
            matrix[curI][curJ] = false;
        }
        if (steps >= res) return;

        for (int i = 0; i < 4; i++) {
            int nextI = curI + dirs[i][0];
            int nextJ = curJ + dirs[i][1];
            if (nextI < 0 || nextI >= 100 || nextJ < 0 || nextJ >= 100 || visited[nextI][nextJ]) continue;
            visited[nextI][nextJ] = true;
            dfs(matrix, visited, nextI, nextJ, rest, steps + 1);
            visited[nextI][nextJ] = false;
        }

        matrix[curI][curJ] = last;
    }

    public static void main(String[] args) {
        Test2 obj = new Test2();
//        int[][] points = new int[][] {{0, 1}, {0, 2}, {0, 3}};
        int[][] points = new int[][] {{0, 5}, {1, 1}};
        System.out.println(obj.getMinLen(points));
    }
}
