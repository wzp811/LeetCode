package _BinarySearch;

public class No69_MySqrt {
    public int mySqrt(int x){
        if (x < 2) return x;
        int left = 1, right = x;
        int mid = 1;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if ((long) mid * mid > x) {
                right = mid;
            } else if ((long) mid * mid < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return 0;
    }
}
