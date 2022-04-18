package Coding_Interviews;

import java.util.Arrays;
import java.util.Stack;

public class No40_MaximalRectangle {
    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length();
        int[][] widths = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int width = 0;
            for (int j = 0; j < cols; j++) {
                if (matrix[i].charAt(j) == '1') {
                    width++;
                    widths[i][j] = width;
                } else {
                    width = 0;
                }
            }
        }
        int[][] above = new int[rows][cols];
        int[][] below = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(above[i], -1);
            Arrays.fill(below[i], rows);
        }
        Stack<Integer> stack;
        for (int i = 0; i < cols; i++) {
            stack = new Stack<>();
            for (int j = 0; j < rows; j++) {
                while (!(stack.isEmpty() || widths[stack.peek()][i] < widths[j][i])) {
                    int index = stack.pop();
                    below[index][i] = j;
                }
                if (!stack.isEmpty()) above[j][i] = stack.peek();
                stack.push(j);
            }
        }
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, (below[i][j] - above[i][j] - 1) * widths[i][j]);
            }
        }
        return max;
    }
}
