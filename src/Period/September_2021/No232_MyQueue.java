package Period.September_2021;
import java.util.*;

public class No232_MyQueue {
    Stack<Integer> s1,s2;
    int len;
    int peek;
    public No232_MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        len = 0;
    }

    public void push(int x) {
        if(len==0)  peek = x;
        len++;
        s1.push(x);
    }

    public int pop() {
        int res = peek;
        len--;
        while(!s1.empty()){
            s2.push(s1.peek());
            s1.pop();
        }
        s2.pop();
        if(!s2.empty())
            peek = s2.peek();
        while(!s2.empty()){
            s1.push(s2.peek());
            s2.pop();
        }
        return res;
    }

    public int peek() {
        return peek;
    }

    public boolean empty() {
        return len==0;
    }

    public static void main(String[] args) {
        No232_MyQueue obj = new No232_MyQueue();
        Scanner input = new Scanner(System.in);

    }
}
