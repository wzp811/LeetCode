package Y2022.Y2022_October;

import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanner {
    Deque<int[]> stack = new ArrayDeque<>();
    int index = 0;
    public StockSpanner() {

    }

    public int next(int price) {
        int[] cur = new int[]{price, index};
        while (!(stack.isEmpty() || stack.peekLast()[0] > price)) {
            stack.pollLast();
        }
        int res = stack.isEmpty() ? index : index - stack.peekLast()[1];
        stack.add(cur);
        index++;
        return res;
    }
}
