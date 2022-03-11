package Coding_Interviews_2th;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
    Queue<Integer> queue = new LinkedList<>();
    Deque<Integer> max = new LinkedList<>();
    public MaxQueue() {}

    public int max_value() {
        return max.isEmpty()?-1:max.peekFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while(!(max.isEmpty()||max.peekLast()>=value)) max.pollLast();
        max.addLast(value);
    }

    public int pop_front() {
        int ans = queue.isEmpty()?-1:queue.poll();
        if(ans!=-1&&ans==max.peekFirst()) max.pollFirst();
        return ans;
    }
}
