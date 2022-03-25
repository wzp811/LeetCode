package _Heap;

import java.util.HashMap;
import java.util.Map;

public class No347_TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int[] res = new int[k];
    }
    public void heapInsert(int[] heap, int len, Map<Integer,Integer> map) {
        int cur = len;
        while(cur>0) {

        }
    }
    public void swap(int[] heap, int a, int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }
}
