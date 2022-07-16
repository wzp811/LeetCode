package CodeCapriccio;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Pattern;

public class No150_EvalRPN {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int a = stack.pollLast();
                int b = stack.pollLast();
                if (token.equals("+")) {
                    stack.push(a + b);
                } else if (token.equals("-")) {
                    stack.push(a - b);
                } else if (token.equals("*")) {
                    stack.push(a * b);
                } else if (token.equals("/")) {
                    stack.push(a / b);
                }
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String str) {
        return !(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
    }


}
