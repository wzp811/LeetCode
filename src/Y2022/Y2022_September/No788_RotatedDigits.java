package Y2022.Y2022_September;

public class No788_RotatedDigits {
    public int rotatedDigits(int n) {
        int res = 0;

        for (int i = 2; i <= n; i++) {
            int tmp = i;
            boolean is = true;
            boolean flag = false;
            while (tmp > 0) {
                int cur = tmp % 10;
                if (cur == 2 || cur == 5 || cur == 6 || cur == 9) {
                    flag = true;
                } else if (cur == 1 || cur == 9 || cur == 0) {

                } else {
                    is = false;
                    break;
                }
                tmp /= 10;
            }
            res += is && flag ? 1 : 0;
        }
        return res;
    }
}
