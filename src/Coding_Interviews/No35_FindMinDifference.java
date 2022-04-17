package Coding_Interviews;

import java.util.List;

public class No35_FindMinDifference {
    public int findMinDifference(List<String>timePoints) {
        if (timePoints.size() > 60 * 24) return 0;
        int[][] times = new int[timePoints.size()][2];
        for (int i = 0; i < times.length; i++) {
            String[]k = timePoints.get(i).split(":");
            times[i][0] = Integer.parseInt(k[0]);
            times[i][1] = Integer.parseInt(k[1]);
        }
        mergeSort(times, 0, times.length - 1);
        for (int i = 0; i < times.length; i++) {
            System.out.println(times[i][0] + " " + times[i][1]);
        }
        int min = (times[0][0] - 0) * 60 + times[0][1] - 0 + (24 - times[times.length - 1][0] - 1) * 60 + 60 - times[times.length - 1][1];
        for (int i = 1; i < times.length; i++) {
            int cur = (times[i][0] - times[i - 1][0]) * 60 + times[i][1] - times[i - 1][1];
            if (min > cur) min = cur;
        }
        return min;
    }
    public void mergeSort(int[][] times, int left, int right) {
        if (left == right) return;
        int mid = left + ((right - left) >> 1);
        mergeSort(times, left, mid);
        mergeSort(times, mid + 1, right);
        merge(times, left, mid, right);
    }
    public void merge(int[][] times, int left, int mid, int right) {
        int[][] cpy = new int[right - left + 1][2];
        for (int i = left; i <= right; i++) {
            cpy[i - left][0] = times[i][0];
            cpy[i - left][1] = times[i][1];
        }
        int i = left, j = mid + 1;
        int index = left;
        while (i <= mid && j <= right) {
            if (cpy[i - left][0] > cpy[j - left][0] || cpy[i - left][0] == cpy[j - left][0] && cpy[i - left][1] > cpy[j - left][1]) {
                times[index][0] = cpy[j - left][0];
                times[index][1] = cpy[j - left][1];
                j++;
            } else {
                times[index][0] = cpy[i - left][0];
                times[index][1] = cpy[i - left][1];
                i++;
            }
            index++;
        }
        while (i <= mid) {
            times[index][0] = cpy[i - left][0];
            times[index][1] = cpy[i - left][1];
            index++;
            i++;
        }
        while (j <= right) {
            times[index][0] = cpy[j - left][0];
            times[index][1] = cpy[j - left][1];
            index++;
            j++;
        }

    }
}
