import java.util.*;
public class Test{
    public static void main(String []args){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) stack.push(i);
        for (int num: stack) System.out.println(num);
    }
}