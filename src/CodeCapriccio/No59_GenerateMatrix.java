package CodeCapriccio;

public class No59_GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int row = 0, col = 0;
        int num = 1;
        for (int i = 0; i < n / 2 - 1; i++) {
            for (int j = 0; j < n - 1 - i * 2; j++) res[row][col++] = num++;
            for (int j = 0; j < n - 1 - i * 2; j++) res[row++][col] = num++;
            for (int j = 0; j < n - 1 - i * 2; j++) res[row][col--] = num++;
            for (int j = 0; j < n - 1 - i * 2; j++) res[row--][col] = num++;
        }
        if (n % 2 == 1) res[n / 2][n / 2] = num;
        return res;
    }
}
