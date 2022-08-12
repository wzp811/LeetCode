package Y2022.Y2022_August;

import java.util.Arrays;

public class No768_MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int[] right = new int[arr.length];
        int[] left = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            left[i] = max;
            right[arr.length - i - 1] = min;
            min = Math.min(min, arr[arr.length - i - 1]);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (left[i] <= right[i]) res++;
        }
        return res;
    }
}
