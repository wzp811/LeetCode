package _Heap;

public class No239_MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int[] heap = new int[k];
        for(int i = 0; i < k; i++) {
            heapInsert(heap, nums[i]);
        }
        return nums;
    }
    public void heapInsert(int[] heap, int len) {

    }
}
