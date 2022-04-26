package Coding_Interviews;

public class No76_FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int[] heap = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            heapInsert(heap, i, nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            swap(heap, 0, nums.length - i - 1);
            heapify(heap, nums.length - i - 1);
        }
        return heap[0];
    }

    public void heapInsert(int[] nums, int size, int val) {
        nums[size] = val;
        int index = size;
        while (index > 0 && nums[(index - 1) / 2] < nums[index]) {
            swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public void heapify(int[] nums, int size) {
        int index = 0;
        int left = index * 2 + 1;
        while (left < size) {
            int maxIndex = left + 1 <= size && nums[left + 1] > nums[left] ? left + 1 : left;
            if (nums[index] >= nums[maxIndex]) break;
            swap(nums, index, maxIndex);
            index = maxIndex;
            left = index * 2 + 1;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
