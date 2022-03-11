package Coding_Interviews_2th;

import java.util.LinkedList;

public class CQueue {
    LinkedList<Integer> stack1 = new LinkedList<>();
    LinkedList<Integer> stack2 = new LinkedList<>();
    public CQueue() {}
    public void appendTail(int value) {
        stack1.push(value);
    }
    public int deleteHead() {
        if(stack1.isEmpty()) return -1;
        while(stack1.size()>1) stack2.push(stack1.pop());
        int ans = stack1.pop();
        while(!stack2.isEmpty()) stack1.push(stack2.pop());
        return ans;
    }
}
