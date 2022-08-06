package Y2022.Y2022_July;

import java.util.Arrays;
import java.util.HashMap;

public class No1331_ArrayRankTransform {
    public int[] arrayRankTransform(int[] arr) {
        int[] tmp = new int[arr.length];
        int[] res = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        System.arraycopy(arr, 0, tmp, 0, arr.length);
        Arrays.sort(tmp);
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(tmp[i])) map.put(tmp[i], map.size());
        }
        for (int i = 0; i < res.length; i++) res[i] = map.get(arr[i]) + 1;
        return res;
    }

}
