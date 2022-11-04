package Y2022.Y2022_November;

public class No754_ReachNumber {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int steps = 0;
        int cur = 0;
        while (cur < target || (cur - target) % 2 == 1) {
            cur += ++steps;
        }
        return steps;
    }
}
