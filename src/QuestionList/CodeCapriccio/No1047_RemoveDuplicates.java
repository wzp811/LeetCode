package QuestionList.CodeCapriccio;

import java.util.ArrayDeque;
import java.util.Deque;

public class No1047_RemoveDuplicates {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (stack.isEmpty() || stack.peekFirst() != cur)
                stack.push(cur);
            else
                stack.pop();
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty())
            res.append(stack.pollLast());
        return new String(res);
    }
}
