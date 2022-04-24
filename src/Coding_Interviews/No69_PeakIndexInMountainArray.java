package Coding_Interviews;

public class No69_PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        int mid = 0;
        int res = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[mid + 1]) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
