package Y2022.Y2022_September;

import java.util.*;

public class No1636_FrequencySort {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<int[]> list = new ArrayList<>();
        for (int key : map.keySet()) {
            list.add(new int[]{key, map.get(key)});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[1] == o1[1]) return o2[0] - o1[0];
                return o1[1] - o2[1];
            }
        });
        int[] res = new int[nums.length];
        int index = 0;
        for (int[] cur : list) {
            System.out.println(Arrays.toString(cur));
            int last = index;
            for (; index < last + cur[1]; index++) res[index] = cur[0];
            System.out.println(Arrays.toString(res));
        }
        return res;
    }
}
