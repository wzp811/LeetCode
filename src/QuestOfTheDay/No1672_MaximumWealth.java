package QuestOfTheDay;

public class No1672_MaximumWealth {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int cur = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                cur += accounts[i][j];
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
