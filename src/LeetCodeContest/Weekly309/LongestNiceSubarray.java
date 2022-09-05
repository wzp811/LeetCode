package LeetCodeContest.Weekly309;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestNiceSubarray {
    public int longestNiceSubarray1(int[] nums) {
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            int or = 0;
            int j = i;
            while (j >= 0 && (or & nums[j]) == 0) {
                or |= nums[j--];
            }
            res = Math.max(res, i - j);
        }
        return res;
    }
    public int longestNiceSubarray(int[] nums) {
        int res = 1;
        int left = 0, right = 0;
        int or = 0;
        while (right < nums.length) {
            while ((or & nums[right]) != 0) {
                or ^= nums[left++];
            }
            right++;
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
