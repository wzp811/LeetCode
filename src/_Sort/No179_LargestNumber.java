package _Sort;

import java.util.Arrays;
import java.util.Comparator;

public class No179_LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) strs[i] = String.valueOf(nums[i]);
        StringBuilder res = new StringBuilder();
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        for (int i = 0; i < strs.length; i++) {
            res.append(strs[i]);
        }
        return res.charAt(0) == '0' ? "0" : res.toString();
    }
}
