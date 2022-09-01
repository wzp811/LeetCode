package Y2022.Y2022_August;

import java.util.ArrayDeque;
import java.util.Deque;

public class No946_ValidateStackSSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && index < popped.length && stack.peekLast() == popped[index]) {
                stack.pollLast();
                index++;
            }
        }
        return stack.isEmpty() && index == popped.length;
    }
}
