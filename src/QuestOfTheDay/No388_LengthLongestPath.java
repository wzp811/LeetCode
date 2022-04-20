package QuestOfTheDay;

import java.util.Arrays;
import java.util.Stack;

public class No388_LengthLongestPath {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = input.split("\n");
        int[] prevCnt = new int[tokens.length];
        for (int i = 0; i < prevCnt.length; i++) {
            int cnt = 0;
            while (tokens[i].charAt(cnt) == '\t') cnt++;
            prevCnt[i] = cnt;
            tokens[i] = tokens[i].substring(cnt);
        }
        int curLength = 0;
        int cnt = 0;
        int maxLen = 0;
        for (int i = 0; i < tokens.length; i++) {
            while (!(stack.isEmpty() || prevCnt[stack.peek()] < prevCnt[i])) {
                int index = stack.pop();
                curLength -= tokens[index].length();
                cnt--;
            }
            curLength += tokens[i].length();
            cnt++;
            if (curLength + cnt - 1 > maxLen && tokens[i].contains(".")) maxLen = curLength + cnt - 1;
            stack.push(i);
        }
        return maxLen;
    }
}
