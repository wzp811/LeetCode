package QuestionList.Coding_Interviews;

import java.util.Stack;

public class No36_EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token: tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int num = 0;
                switch (token) {
                    case "+":
                        num = num1 + num2;
                        break;
                    case "-":
                        num = num1 - num2;
                        break;
                    case "*":
                        num = num1 * num2;
                        break;
                    case "/":
                        num = num1 / num2;
                        break;
                }
                stack.push(num);
            }
        }
        return stack.pop();
    }
    public boolean isNumber(String str) {
        return !(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
    }
}
