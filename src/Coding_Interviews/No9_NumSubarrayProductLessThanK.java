package Coding_Interviews;

import java.util.HashMap;

public class No9_NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int cnt = 0;
        int cur = 1;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            cur *= nums[j];
            while (cur >= k && i < j) {
                cur /= nums[i++];
            }
            if(cur < k) cnt += j - i + 1;
        }
        return cnt;
    }
}
