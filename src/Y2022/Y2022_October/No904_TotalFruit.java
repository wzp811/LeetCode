package Y2022.Y2022_October;

public class No904_TotalFruit {
    public int totalFruit(int[] fruits) {
        int res = 0;
        int left = 0, right = 0;
        int[] cnt = new int[fruits.length];
        int cur = 0;
        while (right < fruits.length) {
            while (right < fruits.length && cur <= 2) {
                cnt[fruits[right]]++;
                if (cnt[fruits[right]] == 1) cur++;
                if (cur <= 2) res = Math.max(right - left + 1, res);
                right++;
            }
            while (cur > 2) {
                cnt[fruits[left]]--;
                if (cnt[fruits[left]] == 0) cur--;
                if (cur <= 2) res = Math.max(right - left - 1, res);
                left++;
            }
        }
        return res;
    }
}
