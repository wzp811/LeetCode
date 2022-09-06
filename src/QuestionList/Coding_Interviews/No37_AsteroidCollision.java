package QuestionList.Coding_Interviews;

import java.util.Stack;

public class No37_AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid: asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else if (asteroid < 0) {
                int cur = asteroid;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    int last = stack.pop();
                    if (cur + last == 0) {
                        cur = 0;
                        break;
                    } else if (cur + last > 0) {
                        cur = last;
                        break;
                    }
                }
                if (cur != 0) stack.push(cur);
            }
        }
        int[] res = new int[stack.size()];
        int index = 0;
        for (int num : stack) res[index++] = num;
        return res;
    }
}
