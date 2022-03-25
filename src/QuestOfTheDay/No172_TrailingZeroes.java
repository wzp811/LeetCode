package QuestOfTheDay;

public class No172_TrailingZeroes {
    public int trailingZeroes(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 5 == 0) {
                int tmp = i;
                while (tmp > 0) {
                    res += 1;
                    tmp /= 5;
                }
            }
        }
        return res;
    }

    public int trailingZeroes1(int n) {
        int res = 0;
        while(n >= 5) {
            n /= 5;
            res += n;
        }
        return res;
    }
}
