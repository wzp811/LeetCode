package QuestionList.Coding_Interviews;

public class No1_Divide {
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE) {
            if (b == 1) return Integer.MIN_VALUE;
            if (b == -1) return Integer.MAX_VALUE;
        }
        if (b == Integer.MIN_VALUE) {
            if (a == Integer.MIN_VALUE) return 1;
            else return 0;
        }
        if (a == 0) return 0;
        boolean isNegative = false;
        if (a > 0) {
            isNegative = !isNegative;
            a = -a;
        }
        if (b > 0) {
            isNegative = !isNegative;
            b = -b;
        }
        int res = 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            boolean tmp = quickMulti(a, mid, b);
            if (!tmp) {
                right = mid - 1;
            } else {
                res = mid;
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            }
        }
        return isNegative ? -res : res;
    }

    // return false if b * mid < a
    public boolean quickMulti(int a, int mid, int b) {
        int res = 0;
        while (mid != 0) {
            if ((mid & 1) != 0) {
                if (res < a - b) {
                    return false;
                }
                res += b;
            }
            if (mid != 1) {
                if (b < a - b) {
                    return false;
                }
                b += b;
            }
            mid >>= 1;
        }
        return true;
    }
}
