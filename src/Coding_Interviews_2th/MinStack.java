package Coding_Interviews_2th;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()||minStack.peek()>=x) minStack.push(x);
    }

    public void pop() {
        int tmp = stack.pop();
        int minTmp = minStack.peek();
        if(tmp==minTmp) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}