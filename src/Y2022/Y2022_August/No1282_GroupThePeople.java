package Y2022.Y2022_August;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No1282_GroupThePeople {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            List<Integer> list = map.getOrDefault(size, new ArrayList<>());
            list.add(i);
            if (size == list.size()) {
                if (size != 1) map.remove(size);
                res.add(list);
            } else {
                map.put(size, list);
            }
        }
        return res;
    }
}
