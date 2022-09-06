package QuestionList.CodeCapriccio;

import java.util.ArrayDeque;
import java.util.Deque;

public class No20_IsValid {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '{' || cur == '[') {
                stack.push(cur);
            } else {
                if (cur == ')' && stack.peekLast() != '('
                        || cur == ']' && stack.peekLast() != '['
                        || cur == '}' && stack.peekLast() != '{')
                    return false;
                else
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
