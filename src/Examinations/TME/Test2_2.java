package Examinations.TME;

import java.util.ArrayList;

public class Test2_2 {

    public int getSubarrayNum(ArrayList<Integer> a, int x) {
        // write code here
        long[][] cnt = new long[a.size()][3];
        long res = 0;
        long mod = (long) 1e9 + 7;
        for (int i = 0; i < a.size(); i++) {
            int num = a.get(i);
            long tmp = 0;
            while (num % 10 == 0) {
                tmp++;
                num /= 10;
            }
            cnt[i][0] = tmp;
            tmp = 0;
            while (num % 5 == 0) {
                tmp++;
                num /= 5;
            }
            cnt[i][1] = tmp;
            tmp = 0;
            while (num % 2 == 0) {
                tmp++;
                num /= 2;
            }
            cnt[i][2] = tmp;
        }
        int left = 0, right = 0;
        long cnt10 = 0;
        long cnt5 = 0, cnt2 = 0;
        while (right < a.size()) {
            cnt10 += cnt[right][0];
            cnt5 += cnt[right][1];
            cnt2 += cnt[right][2];
            if (cnt10 + Math.min(cnt2, cnt5) >= x) {
                while (cnt10 + Math.min(cnt2, cnt5) >= x) {
                    cnt10 -= cnt[left][0];
                    cnt5 -= cnt[left][1];
                    cnt2 -= cnt[left][2];
                    left++;
                }
                res += left % mod;
                res %= mod;
            }
            right++;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Test2_2 obj = new Test2_2();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(10);
        a.add(4);
        a.add(10);
        System.out.println(obj.getSubarrayNum(a, 1));
    }
}
