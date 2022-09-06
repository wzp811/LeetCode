package QuestionList.Coding_Interviews;

import java.util.Arrays;
import java.util.Stack;

public class No39_LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Arrays.fill(left, -1);
        Arrays.fill(right, heights.length);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!(stack.isEmpty() || heights[stack.peek()] < heights[i])) {
                int index = stack.pop();
                right[index] = i;
            }
            if (!stack.isEmpty()) left[i] = stack.peek();
            stack.push(i);
        }
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }
        return max;
    }
}
