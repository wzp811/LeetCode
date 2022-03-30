package QuestOfTheDay;

import java.util.ArrayList;
import java.util.List;

public class No728_SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int cur = i;
            int digit = 1;
            boolean satisfy = true;
            while (digit <= cur) {
                if (cur / digit % 10 == 0 || cur % (cur / digit % 10) != 0) {
                    satisfy = false;
                    break;
                }
                digit *= 10;
            }
            if (!satisfy) continue;
            res.add(cur);
        }
        return res;
    }
}
