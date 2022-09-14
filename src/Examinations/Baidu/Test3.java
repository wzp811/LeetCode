package Examinations.Baidu;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder codeb = new StringBuilder();
        while (input.hasNext()) {
            codeb.append(input.nextLine());
        }
        String code = codeb.toString();
        Deque<Integer> stack = new ArrayDeque<>();
        // 1 == for
        // 2 == if
        int type = 0;
        int forCnt = 0;
        boolean inString = false;
        int res = 0;
        for (int i = 5; i < code.length(); i++) {
            if (code.charAt(i) == '{') {
                stack.addLast(type);
                if (type == 1) forCnt++;
                res = Math.max(res, forCnt);
                type = 0;
            } else if (code.charAt(i) == '}') {
                int curType = stack.pollLast();
                if (curType == 1) forCnt--;
            } else if (!inString && code.substring(i - 5, i - 1).equals(" for") && !Character.isLetter(code.charAt(i))) {
                type = 1;
            } else if (!inString && code.substring(i - 4, i - 1).equals(" if") && !Character.isLetter(code.charAt(i))) {
                type = 2;
            } else if (code.charAt(i) == '"' && code.charAt(i + 1) != '\'' && code.charAt(i - 1) != '\'' && code.charAt(i - 1) != '\\') {
                inString = !inString;
            }
        }
//        "\\" '"' "\"" "'"
        System.out.println(res);
    }
}
