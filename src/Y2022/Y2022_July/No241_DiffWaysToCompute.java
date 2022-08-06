package Y2022.Y2022_July;

import java.util.ArrayList;
import java.util.List;

public class No241_DiffWaysToCompute {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> nums = new ArrayList<>();
        int cur = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                cur *= 10;
                cur += (expression.charAt(i) - '0');
            } else {
                nums.add(cur);
                cur = 0;
                if (expression.charAt(i) == '+') nums.add(-1);
                else if (expression.charAt(i) == '-') nums.add(-2);
                else if (expression.charAt(i) == '*') nums.add(-3);
            }
        }
        nums.add(cur);
        // System.out.println(nums);
        return dfs(nums, 0, nums.size() - 1);
    }

    List<Integer> dfs(List<Integer> nums, int l, int r) {
        List<Integer> ans = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (nums.get(i) >= 0) continue;
            List<Integer> left = dfs(nums, l, i - 1);
            List<Integer> right = dfs(nums, i + 1, r);
            for (int a : left) {
                for (int b : right) {
                    if (nums.get(i) == -1) {
                        ans.add(a + b);
                    } else if (nums.get(i) == -2) {
                        ans.add(a - b);
                    } else if (nums.get(i) == -3) {
                        ans.add(a * b);
                    }
                }
            }
        }
        if (ans.isEmpty() && l <= r) ans.add(nums.get(l));
        return ans;
    }
}
