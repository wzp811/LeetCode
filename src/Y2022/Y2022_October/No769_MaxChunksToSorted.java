package Y2022.Y2022_October;

public class No769_MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                res++;
                max = 0;
            }
        }
        return res;
    }
}