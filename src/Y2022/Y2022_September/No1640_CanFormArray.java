package Y2022.Y2022_September;

public class No1640_CanFormArray {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int index = 0;
        boolean[] visited = new boolean[pieces.length];
        while (index < arr.length) {
            boolean has = false;
            for (int i = 0; i < pieces.length; i++) {
                if (pieces[i][0] == arr[index] && !visited[i]) {
                    visited[i] = true;
                    has = true;
                    for (int j = 0; j < pieces[i].length; j++) {
                        if (arr[index] != pieces[i][j]) return false;
                        index++;
                    }
                    break;
                }
            }
            if (!has) return false;
        }
        return true;
    }
}
