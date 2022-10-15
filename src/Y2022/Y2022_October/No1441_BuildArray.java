package Y2022.Y2022_October;

import java.util.ArrayList;
import java.util.List;

public class No1441_BuildArray {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int index = 0;
        for (int i = 1; i <= n; i++) {
            res.add("Push");
            if (index < target.length && target[index] == i) {
                if (index == target.length - 1) break;
                index++;
            }
            else res.add("Pop");
        }
        return res;
    }
}
