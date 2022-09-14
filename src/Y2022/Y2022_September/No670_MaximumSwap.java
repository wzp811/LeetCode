package Y2022.Y2022_September;

import java.util.ArrayList;
import java.util.List;

public class No670_MaximumSwap {
    public int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();
        int tmp = num;
        while (tmp > 0) {
            list.add(tmp % 10);
            tmp /= 10;
        }
        int[] bits = new int[list.size()];
        for (int i = 0; i < bits.length; i++) bits[bits.length - i - 1] = list.get(i);
        int index = 0;
        for (int i = 1; i < bits.length; i++) {
            if (bits[i] > bits[i - 1] && bits[i] > bits[index]) {
                index = i;
            }
        }
        int loc = index;
        while (index >= 0 && bits[index] < bits[loc]) index--;
        tmp = bits[index + 1];
        bits[index + 1] = bits[loc];
        bits[loc] = tmp;
        int res = 0;
        for (int i = 0; i < bits.length; i++) {
            res *= 10;
            res += bits[i];
        }
        return res;
    }
}
