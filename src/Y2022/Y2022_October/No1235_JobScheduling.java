package Y2022.Y2022_October;

import java.util.Arrays;
import java.util.Comparator;

public class No1235_JobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int[] dp = new int[startTime.length];
        dp[0] = jobs[0][2];
        for (int i = 1; i < startTime.length; i++) {
            int left = 0, right = i - 1;
            int index = -1;
            dp[i] = Math.max(dp[i - 1], jobs[i][2]);
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (jobs[mid][1] > jobs[i][0]) {
                    right = mid - 1;
                } else {
                    index = mid;
                    left = mid + 1;
                }
            }
            if (index != -1 && jobs[index][1] <= jobs[i][0]) dp[i] = Math.max(dp[index] + jobs[i][2], dp[i]);
        }
        return dp[startTime.length - 1];
    }
}
