package Y2022.Y2022_August;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class No658_FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int dis = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (dis > Math.abs(x - arr[i])) {
                dis = Math.abs(x - arr[i]);
                index = i;
            }
        }
        Deque<Integer> queue = new ArrayDeque<>();
        int left = index, right = index + 1;
        while (left >= 0 && right < arr.length) {
            if (left >= 0 && Math.abs(x - arr[left]) < Math.abs(x - arr[right])) {
                queue.addFirst(arr[left--]);
            } else {
                queue.addLast(arr[right++]);
            }
        }
        List<Integer> res = new ArrayList<>(queue);
        return res;
    }
}
