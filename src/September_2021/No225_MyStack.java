package September_2021;
import java.util.*;

public class No225_MyStack {
    Queue<Integer> q;
    Queue<Integer> qtmp;
    int top;
    public No225_MyStack() {
        q = new LinkedList<>();
        qtmp = new LinkedList<>();
    }

    public void push(int x) {
        q.offer(x);
        top = x;
    }

    public int pop() {
        int res = top;
        while(q.size()!=1){
            qtmp.add(q.peek());
            top = q.peek();
            q.poll();
        }
        q.poll();
        while(!qtmp.isEmpty()){
            q.offer(qtmp.peek());
            qtmp.poll();
        }
        return res;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q.isEmpty()&&qtmp.isEmpty();
    }

    public static void main(String[] args) {
        No225_MyStack ex = new No225_MyStack();
        Scanner input = new Scanner(System.in);

    }
}
