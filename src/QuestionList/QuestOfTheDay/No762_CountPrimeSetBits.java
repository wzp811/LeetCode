package QuestionList.QuestOfTheDay;

import java.util.HashSet;
import java.util.Set;

public class No762_CountPrimeSetBits {
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(7);
        set.add(11);
        set.add(13);
        set.add(17);
        set.add(19);
        set.add(23);
        int ans = 0;
        for (int i = left; i <= right; i++) {
            int digit = 1;
            int cur = 0;
            while (digit < i) {
                cur += (digit & i) != 0 ? 1 : 0;
                digit <<= 1;
            }
            if (set.contains(cur)) ans++;
        }
        return ans;
    }
}
