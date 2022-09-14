package Y2022.Y2022_September;

import java.util.Arrays;

public class No1619_TrimMean {
    public double trimMean(int[] arr) {
        int sum = 0;
        Arrays.sort(arr);
        for (int i = arr.length / 20; i < 19 * (arr.length / 20); i++) {
            sum += arr[i];
        }
        return sum * 1.0 / (arr.length / 20 * 18);
    }
}
