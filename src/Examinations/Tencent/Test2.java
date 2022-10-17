package Examinations.Tencent;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        input.nextLine();
        int[] q = new int[n];
        // { i的cnt, i, 序列中有多少个i }
        // o[0] - o[1] : 差
        int[][] cntBetween0to32 = new int[32][3];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int sum = 0;
        for (int i = 0; i < n; i++) {
            q[i] = input.nextInt();
            sum += q[i];
            int cnt = 0;
            for (int j = 0; j < 32; j++) {
                if ((q[i] & (1 << j)) != 0) cnt++;
            }
            queue.add(new int[]{cnt - q[i], q[i]});
            // cnt = o[0] + o[1]
        }
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 6; j++) {
                if ((i & (1 << j)) != 0) cntBetween0to32[i][0]++;
            }
            cntBetween0to32[i][1] = i;
        }
        Arrays.sort(cntBetween0to32, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] - o1[1]) - (o2[0] - o2[1]);
            }
        });
        while (k-- > 0) {
            int min = queue.isEmpty() ? 100 : queue.peek()[0];
            int cur = queue.isEmpty() ? -1 : queue.peek()[1];
            boolean flag = false;
            for (int i = 0; i < 32; i++) {
                if (cntBetween0to32[i][2] == 0) continue;
                if (cntBetween0to32[i][0] - cntBetween0to32[i][1] >= min) break;
                else if (cntBetween0to32[i][2] > 0) {
                    cur = cntBetween0to32[i][1];
                    min = cntBetween0to32[i][0] - cntBetween0to32[i][1];
                    cntBetween0to32[i][2]--;
                    flag = true;
                    break;
                }
            }
            if (!flag) queue.poll();
            cntBetween0to32[cur + min][2]++;
            sum += min;
        }
        System.out.println(sum);
    }

    public static void main1(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        input.nextLine();
        int[] q = new int[n];
        int[] cntBetween0to32 = new int[32];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int sum = 0;
        for (int i = 0; i < n; i++) {
            q[i] = input.nextInt();
            sum += q[i];
            int cnt = 0;
            for (int j = 0; j < 32; j++) {
                if ((q[i] & (1 << j)) != 0) cnt++;
            }
            queue.add(new int[]{cnt - q[i], q[i]});
            // cnt = o[0] + o[1]
        }
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 6; j++) {
                if ((i & (1 << j)) != 0) cntBetween0to32[i]++;
            }

            while (k-- > 0) {
                int[] cur = queue.poll();
                sum += cur[0];
                queue.add(new int[]{cntBetween0to32[cur[0] + cur[1]] - cur[0] - cur[1], cur[0] + cur[1]});
            }
            System.out.println(sum);
        }
    }
}