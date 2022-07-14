package CodeCapriccio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No349_Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums1) set.add(num);
        for (int num : nums2) {
            if (set.contains(num)) {
                res.add(num);
                set.remove(num);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }
}
