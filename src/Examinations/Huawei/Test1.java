package Examinations.Huawei;


import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        List<int[]> list = new ArrayList<>();
        int last = 0;
        for (int i = 0; i < n; i++) {
            int[] cur = new int[2];
            cur[0] = input.nextInt();
            cur[1] = input.nextInt();
            last = Math.max(last, cur[1]);

            list.add(cur);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        int[] dp = new int[last + 1];
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            int[] cur = list.get(i);
            for (int j = cur[1]; j >= cur[0]; j--) {
                dp[j] = Math.max(dp[j - cur[0]] + 1, dp[j]);
                res = Math.max(dp[j], res);
            }
        }
        System.out.println(res);
    }
}
