package Coding_Interviews;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    int capacity = 0;
    int curSize = 0;
    int sum = 0;
    Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        capacity = size;
    }

    public double next(int val) {
        if (curSize == capacity) {
            int tmp = queue.poll();
            sum -= tmp;
        } else {
            curSize++;
        }
        queue.add(val);
        sum += val;
        return (double) sum / curSize;
    }
}
