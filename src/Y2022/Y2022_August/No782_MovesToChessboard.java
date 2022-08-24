package Y2022.Y2022_August;

public class No782_MovesToChessboard {
    public int movesToChessboard(int[][] board) {
        int n = board.length;
        int cnt0 = 0, cnt1 = 0;
        int equalCnt = 0;
        for (int i = 0; i < n; i++) {
            cnt1 += board[0][i];
            equalCnt += (board[i][0] == board[0][0]) ? 1 : 0;
            cnt0 += board[i][0];
        }
        if (Math.abs(cnt1 - (n - cnt1)) > 1 || Math.abs(cnt0 - (n - cnt0)) > 1) return -1;
        for (int i = 1; i < n; i++) {
            boolean equal = board[i][0] == board[0][0];
            for (int j = 1; j < n; j++) {
                if (equal != (board[i][j] == board[0][j])) return -1;
            }
        }
        int cnt = cnt1;
        cnt0 = 0;
        cnt1 = 0;
        // (0, 0) 为1的情况
        for (int i = 1; i < n; i += 2) {
            cnt0 += board[0][i];
            cnt0 += board[i][0];
        }
        // (0, 0) 为0的情况
        for (int i = 1; i < n; i += 2) {
            cnt1 += 1 - board[0][i];
            cnt1 += 1 - board[i][0];
        }
        return n % 2 == 0 ? Math.min(cnt0, cnt1) : (n * n - 2 * n * equalCnt - 2 * n * cnt + 4 * equalCnt * cnt) > 0 ? cnt0 : cnt1;
    }
}
