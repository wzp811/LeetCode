package QuestionList.CodeCapriccio;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {

    Deque<Integer> stack, reverseStack;

    public MyQueue() {
        stack = new ArrayDeque<>();
        reverseStack = new ArrayDeque<>();
    }

    public void push(int x) {
        while (!reverseStack.isEmpty()) {
            stack.push(reverseStack.pop());
        }
        stack.push(x);
    }

    public int pop() {
        while (!stack.isEmpty()) {
            reverseStack.push(stack.pop());
        }
        return reverseStack.pop();
    }

    public int peek() {
        while (!stack.isEmpty()) {
            reverseStack.push(stack.pop());
        }
        return reverseStack.peekFirst();
    }

    public boolean empty() {
        return stack.isEmpty() && reverseStack.isEmpty();
    }
}
