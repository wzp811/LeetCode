package Coding_Interviews;

public class No73_MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int left = 1, right = max;
        int res = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            System.out.println(mid);
            if (canEat(piles, h, mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    public boolean canEat(int[] piles, int h, int k) {
        int cnt = 0;
        for (int pile : piles) {
            cnt += (pile - 1) / k + 1;
        }
        return cnt <= h;
    }
}
