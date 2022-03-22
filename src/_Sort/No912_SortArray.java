package _Sort;

import java.util.Arrays;
import java.util.Random;

public class No912_SortArray {
    /**
     * merget sort
     */
    public int[] sortArrayMerge(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + ((right - left) >> 1);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, right);
    }

    public void merge(int[] nums, int left, int right) {
        int mid = left + ((right - left) >> 1);
        int i = left, j = mid + 1;
        int[] cpy = new int[right - left + 1];
        int index = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                cpy[index++] = nums[i++];
            } else {
                cpy[index++] = nums[j++];
            }
        }
        if (i > mid) {
            while (index <= right - left) cpy[index++] = nums[j++];
        } else if (j > right) {
            while (index <= right - left) cpy[index++] = nums[i++];
        }
        for (int k = left; k <= right; k++) {
            nums[k] = cpy[k - left];
        }
    }


    /**
     * heap sort
     */
    public int[] sortArrayHeap(int[] nums) {
        int[] heap = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            heapInsert(heap, nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            swap(heap, 0, nums.length - 1 - i);
            heapify(heap, nums.length - 2 - i);
        }
        return heap;
    }

    public void heapInsert(int[] nums, int num, int len) {
        nums[len] = num;
        while (len > 0 && nums[len] > nums[(len - 1) / 2]) {
            swap(nums, len, (len - 1) / 2);
            len = (len - 1) / 2;
        }
    }

    public void heapify(int[] nums, int len) {
        int cur = 0;
        int left = cur * 2 + 1;
        int right = cur * 2 + 2;
        while (left <= len) {
            int maxIndex = nums[cur] < nums[left] ? left : cur;
            maxIndex = right <= len && nums[maxIndex] < nums[right] ? right : maxIndex;
            if (cur == maxIndex) break;
            swap(nums, cur, maxIndex);
            cur = maxIndex;
            left = cur * 2 + 1;
            right = cur * 2 + 2;
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    /**
     * quick sort
     */
    public int[] sortArray(int[] nums) {
        if (nums.length < 2) return nums;
        process(nums, 0, nums.length - 1);
        return nums;
    }

    public void process(int[] nums, int left, int right) {
        if (left >= right) return;
        int rand = new Random().nextInt(right - left + 1) + left;
        swap(nums, right, rand);
        int loc = partition(nums, left, right);
        process(nums, left, loc - 1);
        process(nums, loc + 1, right);
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int index = left - 1;
        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                index++;
                swap(nums, i, index);
            }
        }
        swap(nums, index + 1, right);
        return index + 1;
    }


    public static void main(String[] args) {
        No912_SortArray obj = new No912_SortArray();
        int[] nums = new int[]{5, 2, 3, 1};
        System.out.println(Arrays.toString(obj.sortArray(nums)));
    }
}
