package Examinations.QiAnXin;

public class Test2_2 {
    public int getMinLen(int[][] points) {
        // write code here
        int n = points.length;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < points.length; i++) {
            matrix[i][i] = Integer.MAX_VALUE;
            int curI = points[i][0];
            int curJ = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int nextI = points[j][0];
                int nextJ = points[j][1];
                int len = Math.abs(nextI - curI) + Math.abs(nextJ - curJ);
                matrix[i][j] = len;
                matrix[j][i] = len;
            }
        }

    }
}
