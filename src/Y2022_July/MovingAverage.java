package Y2022_July;

import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverage {

    Deque<Integer> queue;
    int size;
    int sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new ArrayDeque<>();
        this.size = size;
        this.sum = 0;
    }

    public double next(int val) {
        queue.addLast(val);
        sum += val;
        if (queue.size() > size) {
            sum -= queue.pollFirst();
        }
        return (double) sum / queue.size();
    }

}
