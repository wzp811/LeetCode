package QuestionList.QuestOfTheDay;

import java.util.Arrays;

public class No691_MinStickers {
    public int minStickers(String[] stickers, String target) {
        int[] steps = new int[1 << target.length()];
        Arrays.fill(steps, -1);
        int res = process(stickers, target, steps, 0);
        return res == Integer.MAX_VALUE || res <= 0 ? -1 : res;
    }

    public int process(String[] stickers, String target, int[] steps, int state) {
        if (state == (1 << target.length()) - 1) return 0;
        if (steps[state] != -1) return steps[state];
        int res = Integer.MAX_VALUE;
        for (String sticker : stickers) {
            int nextState = state;
            for (char ch : sticker.toCharArray()) {
                for (int i = 0; i < target.length(); i++) {
                    if (ch == target.charAt(i) && ((1 << i) & nextState) == 0) {
                        nextState |= (1 << i);
                        break;
                    }
                }
            }
            if (nextState != state) {
                res = Math.min(res, process(stickers, target, steps, nextState) + 1);
            }
        }
        steps[state] = res;
        return res;
    }
}
