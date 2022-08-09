package Y2022.Y2022_August;

public class No1413_MinStartValue {
    public int minStartValue(int[] nums) {
        int min = 0;
        int cur = 0;
        for (int num : nums) {
            cur += num;
            min = Math.min(cur, min);
        }
        return -min + 1;
    }
}
