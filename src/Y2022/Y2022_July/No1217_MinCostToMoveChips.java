package Y2022.Y2022_July;

public class No1217_MinCostToMoveChips {
    public int minCostToMoveChips(int[] position) {
        int sum1 = 0, sum2 = 0;
        for (int pt : position) {
            sum1 += pt % 2;
            sum2 += (pt + 1) % 2;
        }
        return Math.min(sum1, sum2);
    }
}
