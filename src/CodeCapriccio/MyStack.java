package CodeCapriccio;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack {
    /*
    Deque<Integer> queue, assistantQueue;

    public MyStack() {
        queue = new ArrayDeque<>();
        assistantQueue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.addLast(x);
    }

    public int pop() {
        while (queue.size() != 1) {
            assistantQueue.addLast(queue.pollFirst());
        }
        int res = queue.pollFirst();
        while (!assistantQueue.isEmpty()) {
            queue.addLast(assistantQueue.pollFirst());
        }
        return res;
    }

    public int top() {
        while (queue.size() != 1) {
            assistantQueue.addLast(queue.pollFirst());
        }
        int res = queue.pollFirst();
        assistantQueue.addLast(res);
        while (!assistantQueue.isEmpty()) {
            queue.addLast(assistantQueue.pollFirst());
        }
        return res;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
    */

    Deque<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.addLast(x);
    }

    public int pop() {
        for (int i = 0; i < queue.size(); i++) {
            if (i == queue.size() - 1) return queue.pollFirst();
            queue.addLast(queue.pollFirst());
        }
        return -1;
    }

    public int top() {
        int res = -1;
        for (int i = 0; i < queue.size(); i++) {
            if (i == queue.size() - 1) res = queue.peekFirst();
            queue.addLast(queue.pollFirst());
        }
        return res;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}
