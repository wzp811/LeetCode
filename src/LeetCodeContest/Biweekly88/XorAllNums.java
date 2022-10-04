package LeetCodeContest.Biweekly88;

import java.util.Arrays;

public class XorAllNums {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int left = nums1[0];
        for (int i = 1; i < nums1.length; i++) left ^= nums1[i];
        int right = nums2[0];
        for (int i = 1; i < nums2.length; i++) right ^= nums2[i];
        if (nums1.length % 2 == 0 && nums2.length % 2 == 0) return 0;
        if (nums1.length % 2 == 0) return left;
        else if (nums2.length % 2 == 0) return right;
        else return left ^ right;
    }
}
