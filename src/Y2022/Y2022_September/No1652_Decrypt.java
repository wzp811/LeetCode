package Y2022.Y2022_September;

public class No1652_Decrypt {
    public int[] decrypt(int[] code, int k) {
        int[] pre = new int[code.length];
        int[] pos = new int[code.length];
        pre[0] = code[0];
        pos[code.length - 1] = code[code.length - 1];
        for (int i = 1; i < code.length; i++) {
            pre[i] = pre[i - 1] + code[i];
            pos[code.length - i - 1] = pos[code.length - i] + code[code.length - i - 1];
        }
        int[] res = new int[code.length];
        for (int i = 0; i < code.length; i++) {
            if (k == 0) {
                res[i] = 0;
            } else if (k > 0) {
                // 5 12 13 17
                res[i] += pre[Math.min(i + k, code.length - 1)] - pre[i];
                if (i + k - code.length >= 0) res[i] += pre[i + k - code.length];
            } else {
                // 18 16 12 3
                res[i] += pos[Math.max(i + k, 0)] - pos[i];
                if (i + k < 0) res[i] += pos[i + k + code.length];
            }
        }
        return res;
    }
}
