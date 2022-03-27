package QuestOfTheDay;

public class No2028_MissingRolls {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = mean * (rolls.length + n);
        for (int i = 0; i < rolls.length; i++) sum -= rolls[i];
        if (sum > 6 * n || sum < n) return new int[0];
        int[] res = new int[n];
        process(res, sum, 0, n);
        return res;
    }

    public boolean process(int[] res, int rest, int index, int n) {
        if (index == n && rest == 0) return true;
        if(rest>6*(n-index)||rest<n-index) return false;
        if (rest < 0) return false;
        for (int i = 1; i <= Math.min(6, rest); i++) {
            res[index] = i;
            if (process(res, rest - i, index + 1, n)) return true;
        }
        return false;
    }
}
