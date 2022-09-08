package Y2022.Y2022_September;

public class No667_ConstructArray {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n - k; i++) {
            res[i] = res[i - 1] + 1;
        }
        int left = n - k + 1, right = n;
        int index = n - k;
        while (left <= right) {
            res[index++] = right--;
            if (left > right) break;
            res[index++] = left++;
        }
        return res;
    }
}
