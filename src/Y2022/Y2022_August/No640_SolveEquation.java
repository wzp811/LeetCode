package Y2022.Y2022_August;

public class No640_SolveEquation {
    public String solveEquation(String equation) {
        int right = 0, left = 0;
        int cur = 0;
        int signal = 1;
        int isLeft = 1;
        for (int i = 0; i < equation.length(); i++) {
            char ch = equation.charAt(i);
            if (Character.isDigit(ch)) {
                cur *= 10;
                cur += ch - '0';
            } else {
                if (ch == 'x') {
                    if (i == 0 || !Character.isDigit(equation.charAt(i - 1))) cur = 1;
                    left += (cur * signal * isLeft);
                } else {
                    right += (cur * signal * isLeft);
                }
                cur = 0;
                signal = 1;
                if (ch == '=') isLeft = -1;
                else if (ch == '-') signal = -1;
            }
        }
        right += (cur * signal * isLeft);
        if (left == 0) {
            if (right == 0) return "Infinite solutions";
            else return "No solution";
        }
        else return "x=" + String.valueOf(-right / left);
    }
}
