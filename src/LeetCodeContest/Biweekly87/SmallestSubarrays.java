package LeetCodeContest.Biweekly87;

import java.util.Arrays;

public class SmallestSubarrays {
    public int[] smallestSubarrays1(int[] nums) {
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int bit = 1;
            for (int j = 0; j < 32; j++) {
                if ((bit & nums[i]) != 0) bits[j]++;
                bit <<= 1;
            }
        }
        int[] res = new int[nums.length];
        boolean useLast = false;
        int[] tmpBits = bits.clone();
        for (int i = 0; i < nums.length; i++) {
            if (useLast) {
                res[i] = res[i - 1] - 1;
                useLast = false;
            } else {
                tmpBits = bits.clone();
                int right = nums.length - 1;
                while (right > i) {
                    boolean flag = false;
                    int bit = 1;
                    for (int j = 0; j < 32; j++) {
                        if ((bit & nums[right]) != 0) {
                            if (tmpBits[j] == 1) {
                                flag = true;
                                break;
                            }
                            tmpBits[j]--;
                        }
                        bit <<= 1;
                    }
                    if (flag) {
                        break;
                    }
                    right--;
                }
                res[i] = right - i + 1;
            }
            System.out.println(Arrays.toString(bits));
            System.out.println(Arrays.toString(tmpBits));
            int bit = 1;
            boolean to0 = false;
            for (int j = 0; j < 32; j++) {
                if ((bit & nums[i]) != 0) {
                    bits[j]--;
                    tmpBits[j]--;
                    if (tmpBits[j] <= 0) to0 = true;
                }
                bit <<= 1;
            }
            useLast = !to0;
        }
        return res;
    }
}
