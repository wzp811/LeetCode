package Y2022.Y2022_July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No1200_MinimumAbsDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(arr[i + 1] - arr[i], min);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == min) {
                List<Integer> cur = new ArrayList<>();
                cur.add(arr[i]);
                cur.add(arr[i + 1]);
                res.add(cur);
            }
        }
        return res;
    }
}
