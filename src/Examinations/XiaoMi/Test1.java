package Examinations.XiaoMi;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        while (input.hasNext()) {
            int a = input.nextInt();
            int b = input.nextInt();
            queue.add(new int[]{a, b});
        }
        int res = 0;
        int[] tmp = queue.poll();
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] > tmp[1]) {
                res += tmp[1] - tmp[0];
                tmp = cur;
            } else {
                tmp[1] = Math.max(tmp[1], cur[1]);
            }
        }
        res += tmp[1] - tmp[0];
        System.out.println(res);
    }
}
