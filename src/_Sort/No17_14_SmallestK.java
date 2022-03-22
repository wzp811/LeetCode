package _Sort;

public class No17_14_SmallestK {
    public int[] smallestK(int[] arr, int k) {
        int[] heap = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            heapInsert(heap, i, arr[i]);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap[0];
            swap(heap, 0, heap.length - 1 - i);
            heapify(heap, heap.length - 2 - i);
        }
        return res;
    }

    public void heapInsert(int[] heap, int len, int num) {
        heap[len] = num;
        while (len > 0 && heap[len] < heap[(len - 1) / 2]) {
            swap(heap, len, (len - 1) / 2);
            len = (len - 1) / 2;
        }
    }

    public void heapify(int[] heap, int len) {
        int left = 1, cur = 0;
        while (left <= len) {
            int minIndex = heap[left] < heap[cur] ? left : cur;
            minIndex = left + 1 <= len && heap[minIndex] > heap[left + 1] ? left + 1 : minIndex;
            if (cur == minIndex) break;
            swap(heap, cur, minIndex);
            cur = minIndex;
            left = minIndex * 2 + 1;
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
