package LeetCodeContest.Weekly302;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestTrimmedNumbers {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            int[] query = queries[j];
            PriorityQueue<String[]> queue = new PriorityQueue<>(new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    int res = isBigger(o1[0], o2[0]);
                    if (res == 0) return isBigger(o1[1], o2[1]);
                    return res;
                }
            });
            for (int i = nums.length - 1; i >= 0; i--) {
                queue.add(new String[]{nums[i].substring(nums[i].length() - query[1]), String.valueOf(i)});
            }
            for (int i = 0; i < query[0] - 1; i++) queue.poll();
            res[j] = Integer.parseInt(queue.peek()[1]);
        }
        return res;
    }
    public int isBigger(String s1, String s2) {
        if (s1.length() != s2.length()) return s1.length() - s2.length();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) continue;
            return s1.charAt(i) - s2.charAt(i);
        }
        return 0;
    }
}
