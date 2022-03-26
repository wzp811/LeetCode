package QuestOfTheDay;

import java.util.Stack;

public class No682_CalPoints {
    public int calPoints(String[] ops) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            int cur = 0;
            if(ops[i].equals("+")) {
                int tmp1 = stack.pop();
                int tmp2 = stack.pop();
                cur = tmp1 + tmp2;
                res += cur;
                stack.push(tmp2);
                stack.push(tmp1);
                stack.push(cur);
            } else if(ops[i].equals("D")) {
                int tmp = stack.pop();
                cur = 2 * tmp;
                res += cur;
                stack.push(tmp);
                stack.push(cur);
            } else if(ops[i].equals("C")) {
                int tmp = stack.pop();
                res -= tmp;
            } else {
                cur = Integer.parseInt(ops[i]);
                stack.push(cur);
                res += cur;
            }
        }
        return res;
    }
}
