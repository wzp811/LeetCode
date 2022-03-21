package _TwoPointers;

import java.util.*;

public class No15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        int k = 0;
        while (k < nums.length - 2) {
            if (k > 0 && k < nums.length && nums[k] == nums[k - 1]) k++;
            if (k >= nums.length || nums[k] > 0) break;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[k]);
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    res.add(tmp);
                }
                if (sum >= 0) {
                    i++;
                    while (i < j && nums[i] == nums[i - 1]) i++;
                } else {
                    j--;
                    while (j > i && nums[j] == nums[j + 1]) j--;
                }
            }
            k++;
        }
        return res;
    }
}
