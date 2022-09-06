package Tags._Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No349_Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> res = new ArrayList<>();
        int prev = -1;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j] && nums1[i] != prev) {
                res.add(nums1[i]);
                prev = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            }
        }
        int[] ans = new int[res.size()];
        for (i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }

}
