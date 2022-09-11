package Y2022.Y2022_September;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No857_MincostToHireWorkers {
    public static double mincostToHireWorkers(int[] quantity, int[] wage, int k) {
        double[][] rate = new double[quantity.length][2];
        for (int i = 0; i < quantity.length; i++) {
            rate[i][0] = wage[i] * 1.0 / quantity[i];
            rate[i][1] = i * 1.0;
        }
        Arrays.sort(rate, (a, b)->Double.compare(a[0], b[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)->(b - a));
        int total = 0;
        double res = Double.MAX_VALUE;
        for (int i = 0; i < rate.length; i++) {
            int cur = quantity[(int)rate[i][1]];
            total += cur;
            queue.add(cur);
            if (queue.size() > k) total -= queue.poll();
            if (queue.size() == k) res = Math.min(res, total * rate[i][0]);
        }
        // System.out.println(Arrays.toString(rate));
        return res;
    }

    public static void main(String[] args) {
        int[] quantity = new int[]{3, 1, 10, 10, 1};
        int[] wage = new int[]{4, 8, 2, 2, 7};
        mincostToHireWorkers(quantity, wage, 3);
    }
}
