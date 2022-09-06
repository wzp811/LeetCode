package QuestionList.Coding_Interviews;

import java.util.Random;

public class Solution {
    int[] pre;
    Random random;
    int total;

    public Solution(int[] w) {
        random = new Random();
         total = 0;
         pre = new int[w.length];
         for (int i = 0; i < w.length; i++) {
             total += w[i];
             pre[i] = w[i] + (i > 0 ? pre[i - 1] : 0);
         }
    }

    public int pickIndex() {
        int num = random.nextInt(total) + 1;
        int left = 0, right = pre.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (pre[mid] >=num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
