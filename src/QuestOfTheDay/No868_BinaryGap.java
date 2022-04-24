package QuestOfTheDay;

public class No868_BinaryGap {
    public int binaryGap(int n) {
        int res = 0;
        int last = 0;
        int cur = -1;
        while (n > 0) {
            cur++;
            int digit = n % 2;
            n /= 2;
            if (digit == 1) {
                res = Math.max(cur - last, res);
                last = cur;
            }
        }
        return res;
    }
}
