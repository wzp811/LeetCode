package Y2022.Y2022_September;

public class No1582_NumSpecial {
    public int numSpecial(int[][] mat) {
        int[] cntCol = new int[mat[0].length];
        int[] cntRow = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                cntCol[j] += mat[i][j];
                cntRow[i] += mat[i][j];
            }
        }
        int cnt = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && cntCol[j] == 1 && cntRow[i] == 1) cnt++;
            }
        }
        return cnt;
    }
}
