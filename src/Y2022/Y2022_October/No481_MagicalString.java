package Y2022.Y2022_October;

public class No481_MagicalString {
    public int magicalString(int n) {
        int[] dp = new int[n];
        int cnt = 1;
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 2;
        int index = 3;
        int start = 2;
        boolean isOne = true;
        while (index < n) {
            dp[index++] = isOne ? 1 : 2;
            cnt += isOne ? 1 : 0;
            if (dp[start] == 2 && index < n) {
                dp[index++] = isOne ? 1 : 2;
                cnt += isOne ? 1 : 0;
                isOne = !isOne;
            }
            start++;
        }
        return cnt;
    }
}
