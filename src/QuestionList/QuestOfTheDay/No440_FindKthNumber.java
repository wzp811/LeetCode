package QuestionList.QuestOfTheDay;

public class No440_FindKthNumber {
    public int findKthNumber(int n, int k) {
        int cnt = 0;
        int digit = 1;
        while (k > 1) {
            cnt = getCnt(digit, n);
            if (k <= cnt) {
                k--;
                digit *= 10;
            } else {
                k -= cnt;
                digit++;
            }
        }
        return digit;
    }

    public int getCnt(int digit, int limit) {
        int lenDigit = String.valueOf(digit).length();
        int lenLimit = String.valueOf(limit).length();
        int k = lenLimit - lenDigit;
        int cnt = 0;
        int u = Integer.parseInt(String.valueOf(limit).substring(0, lenDigit));
        for (int i = 0; i < k; i++) cnt += Math.pow(10, i);
        if (u > digit) cnt += Math.pow(10, k);
        else if (u == digit) cnt += limit - digit * Math.pow(10, k) + 1;
        return cnt;
    }
}
