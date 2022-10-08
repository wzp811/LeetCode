package Y2022.Y2022_October;

import java.util.Arrays;
import java.util.Comparator;

public class No870_AdvantageCount {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int[][] tmp2 = new int[nums2.length][2];
        for (int i = 0; i < nums2.length; i++) {
            tmp2[i][0] = nums2[i];
            tmp2[i][1] = i;
        }
        Arrays.sort(tmp2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int index1 = 0;
        int index2 = 0;
        int right = nums2.length - 1;
        int[] res = new int[nums1.length];
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] > tmp2[index2][0]) {
                res[tmp2[index2][1]] = nums1[index1];
                index1++;
                index2++;
            } else {
                res[tmp2[right--][1]] = nums1[index1++];
            }
        }
        while (index1 < nums1.length) {
            res[tmp2[right--][1]] = nums1[index1++];
        }
        return res;
    }
}
