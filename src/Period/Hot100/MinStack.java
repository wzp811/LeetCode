package Period.Hot100;

import java.util.Stack;

public class MinStack {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> assistStack = new Stack<>();
    public MinStack(){

    }
    public void push(int val){
        assistStack.push(val);
        if(mainStack.isEmpty()||val<=mainStack.peek()) mainStack.push(val);
    }
    public void pop(){
//    两种表达二选一
        if(assistStack.peek().equals(mainStack.peek())) mainStack.pop();
//        if(Objects.equals(assistStack.peek(), mainStack.peek())) mainStack.pop();
        assistStack.pop();
    }
    public int top(){
        return assistStack.peek();
    }
    public int getMin(){
        return mainStack.peek();
    }
    public void display(){
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("main");
        System.out.println(mainStack);
        System.out.println("assist");
        System.out.println(assistStack);
        System.out.println("--------------------------------------");
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(512);
        obj.display();
        obj.push(-1024);
        obj.display();
        obj.push(-1024);
        obj.display();
        obj.push(512);
        obj.display();
        obj.pop();
        obj.display();
        System.out.println(obj.getMin());
        obj.display();
        obj.pop();
        obj.display();
        System.out.println(obj.getMin());
        obj.display();
        obj.pop();
        obj.display();
        System.out.println(obj.getMin());
        obj.display();
    }
}
