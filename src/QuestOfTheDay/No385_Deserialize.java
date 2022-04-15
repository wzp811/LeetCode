package QuestOfTheDay;

import java.util.Stack;

public class No385_Deserialize {
    public NestedInteger deserializeTest(String s) {
        NestedInteger ans = new NestedInteger();
        NestedInteger left1 = new NestedInteger(123);
        NestedInteger right1 = new NestedInteger();
        NestedInteger left2 = new NestedInteger(456);
        NestedInteger right2 = new NestedInteger();
        NestedInteger left3 = new NestedInteger(789);
        right2.add(left3);
        right1.add(left2);
        right1.add(right2);
        ans.add(left1);
        ans.add(right1);
        return ans;
    }

    public NestedInteger deserialize(String s ){
        Stack<NestedInteger> stack = new Stack<>();
        int num = 0;
        int isNegative = 0;
        NestedInteger cur = new NestedInteger();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                stack.push(cur);
                cur = new NestedInteger();
            } else if (s.charAt(i) == ']' || s.charAt(i) == ',') {
                if (isNegative != 0) {
                    NestedInteger tmp = new NestedInteger(num * isNegative);
                    isNegative = 0;
                    num = 0;
                    cur.add(tmp);
                }
                if (s.charAt(i) == ']') {
                    NestedInteger last = stack.pop();
                    last.add(cur);
                    cur = last;
                }
            } else if (s.charAt(i) == '-') {
                isNegative = -1;
            } else {
                if (isNegative == 0) isNegative = 1;
                num *= 10;
                num += s.charAt(i) - '0';
            }
        }
        if (s.charAt(s.length() - 1) != ']') {
            return new NestedInteger(num * isNegative);
        }
        return cur.getList();
    }
}
