package QuestOfTheDay;

public class No812_LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double res = 0;
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0] - x1;
                int y2 = points[j][1] - y1;
                for (int k = j + 1; k < points.length; k++) {
                    int x3 = points[k][0] - x1;
                    int y3 = points[k][1] - y1;
                    res = Math.max(res, Math.abs(x2 * y3 - x3 * y2) / 2.0);
                }
            }
        }
        return res;
    }
}
