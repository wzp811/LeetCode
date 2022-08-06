package Y2022.Y2022_July;

import java.util.HashMap;

public class No736_Evaluate {
    public int evaluate(String expression) {
        return dfs(0, expression.length() - 1, expression, new HashMap<>());
    }
    public int dfs(int l, int r, String expression, HashMap<String, Integer> map) {
        String op;
        int next;
        next = getToken(l + 1, expression);
        op = expression.substring(l + 1, next);
        if (op.equals("let")) {
            String value = "";
            int tmp = next + 1;
            for (int i = tmp; i < r; i++) {
                next = getToken(i, expression);
                if (value.equals("")) {
                    value = expression.substring(i, next);
                    if (value.charAt(0) == '(') return dfs(i, next, expression, new HashMap<>(map));
                }
                else {
                    map.put(value, expression.charAt(i) == '(' ?
                            dfs(i, next, expression, new HashMap<>(map)) : (Character.isLetter(expression.charAt(i)) ?
                            map.get(expression.substring(i, next)) : Integer.parseInt(expression.substring(i, next))));
                    value = "";
                }
                i = next;
            }
            return Character.isLetter(value.charAt(0)) ? map.get(value) : Integer.parseInt(value);
        } else {
            int v1, v2;
            int last = next;
            next = getToken(next + 1, expression);
            String e1 = expression.substring(last + 1, next);
            if (e1.charAt(0) == '(') v1 = dfs(last + 1, next, expression, new HashMap<>(map));
            else v1 = Character.isLetter(e1.charAt(0)) ? map.get(e1) : Integer.parseInt(e1);
            last = next;
            next = getToken(next + 1, expression);
            String e2 = expression.substring(last + 1, next);
            if (e2.charAt(0) == '(') v2 = dfs(last + 1, next, expression, new HashMap<>(map));
            else v2 = Character.isLetter(e2.charAt(0)) ? map.get(e2) : Integer.parseInt(e2);
            return op.equals("add") ? v1 + v2 : v1 * v2;
        }
    }
    public int getToken(int index, String expression) {
        int cnt = 0;
        for (int i = index; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') cnt++;
            else if (expression.charAt(i) == ')') {
                cnt--;
                if (cnt == 0) return i + 1;
            }
            if (cnt == 0 && expression.charAt(i) == ' ' || cnt < 0) return i;
        }
        return expression.length();
    }

    public static void main(String[] args) {
        No736_Evaluate obj = new No736_Evaluate();
//        String str = "(let x 2 (mult x (let x 3 y 4 (add x y))))";
//        String str = "(let x 3 x 2 x)";
//        String str = "(let x 1 y 2 x (add x y) (add x y))";
        String str = "(let a1 3 b2 (add a1 1) b2)";
        System.out.println(obj.evaluate(str));
    }
}
