package QuestOfTheDay;

public class No883_ProjectionArea {
    public int projectionArea(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, grid[i][j]);
            }
            sum += max;
        }
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
            }
            sum += max;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) sum++;
            }
        }
        return sum;
    }
}
