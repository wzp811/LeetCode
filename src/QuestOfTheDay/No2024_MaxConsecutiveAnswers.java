package QuestOfTheDay;

public class No2024_MaxConsecutiveAnswers {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left = 0, right = 0;
        int res = 1;
        int rest = k;
        while (right < answerKey.length()) {
            if (answerKey.charAt(right) == 'T') {
                res = Math.max(res, right - left + 1);
                right++;
            } else {
                if (rest > 0) {
                    res = Math.max(res, right - left + 1);
                    right++;
                    rest--;
                } else {
                    if (answerKey.charAt(left) == 'F') {
                        rest++;
                    }
                    left++;
                }
            }
        }
        left = 0;
        right = 0;
        rest = k;
        while (right < answerKey.length()) {
            if (answerKey.charAt(right) == 'F') {
                res = Math.max(res, right - left + 1);
                right++;
            } else {
                if (rest > 0) {
                    res = Math.max(res, right - left + 1);
                    right++;
                    rest--;
                } else {
                    if (answerKey.charAt(left) == 'T') {
                        rest++;
                    }
                    left++;
                }
            }
        }
        return res;
    }
}
