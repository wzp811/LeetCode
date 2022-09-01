package Y2022.Y2022_September;

public class No1475_FinalPrices {
    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int tmp = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    tmp = prices[j];
                    break;
                }
            }
            res[i] = prices[i] - tmp;
        }
        return res;
    }
}
