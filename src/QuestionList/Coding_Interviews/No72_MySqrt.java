package QuestionList.Coding_Interviews;

public class No72_MySqrt {
    public int mySqrt(int x) {
        int left = 0, right = x;
        int res = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if ((long)mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
