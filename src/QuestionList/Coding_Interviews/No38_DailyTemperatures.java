package QuestionList.Coding_Interviews;

import java.util.Stack;

public class No38_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!(stack.isEmpty() || temperatures[stack.peek()] > temperatures[i])) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(temperatures[i]);
        }
        while (!stack.isEmpty()) {
            res[stack.pop()] = 0;
        }
        return res;
    }
}
