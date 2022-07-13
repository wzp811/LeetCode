package Y2022_July;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No735_AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> res = new ArrayList<>();
        int index = 0;
        while (index < asteroids.length && asteroids[index] < 0) res.add(asteroids[index++]);
        Stack<Integer> stack = new Stack<>();
        while (index < asteroids.length) {
            if (asteroids[index] > 0) {
                stack.push(asteroids[index]);
            } else if (asteroids[index] < 0) {
                int last = 0;
                while (!stack.isEmpty()) {
                    last = stack.pop();
                    if (last == -asteroids[index]) {
                        break;
                    } else if (last > -asteroids[index]) {
                        stack.push(last);
                        break;
                    }
                }
                if (stack.isEmpty() && last != -asteroids[index]) res.add(asteroids[index]);
            }
            index++;
        }
        int[] ans = new int[res.size() + stack.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        for (int i = 0; i < ans.length - res.size(); i++) ans[ans.length - i - 1] = stack.pop();
        return ans;
    }
}
