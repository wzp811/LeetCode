package LeetCodeContest.Weekly313;

public class MinimizeXor {
    public int minimizeXor(int num1, int num2) {
        int cnt = 0;
        while (num2 > 0) {
            if (num2 % 2 == 1) cnt++;
            num2 /= 2;
        }
        // System.out.println(cnt);
        int res1 = 0;
        for (int i = 31; i >= 0; i--) {
            if (((1 << i) & num1) != 0) {
                cnt--;
                res1 += (1 << i);
            }
            if (cnt == 0) break;
        }
        // System.out.println(res1);
        int res2 = 0;
        for (int i = 0; i < 32; i++) {
            if (cnt == 0) break;
            if (((1 << i) & num1) == 0) {
                cnt--;
                res2 += (1 << i);
            }
        }
        // System.out.println(res2);
        return res1 | res2;
    }
}
