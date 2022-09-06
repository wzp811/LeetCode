package Tags._Sort;

import java.util.ArrayList;
import java.util.List;

public class CountSmaller {
    public List<Integer> countSmaller(int[] nums) {
        int[] counts = new int[nums.length];
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) index[i] = i;
        mergeSort(nums, counts, 0, nums.length - 1, index);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) res.add(counts[i]);
        return res;
    }

    public void mergeSort(int[] nums, int[] counts, int left, int right, int[] index) {
        if (right - left < 1) return;
        int mid = left + ((right - left) >> 1);
        mergeSort(nums, counts, left, mid, index);
        mergeSort(nums, counts, mid + 1, right, index);
        merge(nums, counts, left, mid, right, index);
    }

    public void merge(int[] nums, int[] counts, int left, int mid, int right, int[] helper) {
        int[] cpy = new int[right - left + 1];
        int[] cpyIndex = new int[right - left + 1];
        int index = 0;
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                cpy[index] = nums[j];
                cpyIndex[index] = helper[j];
                j++;
            } else {
                cpy[index] = nums[i];
                cpyIndex[index] = helper[i];
                counts[helper[i]] += right - j + 1;
                i++;
            }
            index++;
        }
        for (; i <= mid; i++) {
            cpy[index] = nums[i];
            cpyIndex[index] = helper[i];
            index++;
        }
        for (; j <= right; j++) {
            cpy[index] = nums[j];
            cpyIndex[index] = helper[j];
            index++;
        }
        for (i = 0; i < index; i++) {
            nums[i + left] = cpy[i];
            helper[i + left] = cpyIndex[i];
        }
    }
}
